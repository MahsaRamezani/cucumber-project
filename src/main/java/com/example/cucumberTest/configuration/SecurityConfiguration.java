package com.example.cucumberTest.configuration;

import com.hazelcast.core.IMap;
import ir.bmi.identity.client.security.config.BmiOAuth2Properties;
import ir.bmi.identity.client.security.config.BmiSsoTokenProvider;
import ir.bmi.identity.client.security.exception.BmiSsoAuthorizationException;
import ir.bmi.identity.client.security.reactive.exception.BmiReactiveSsoExceptionHandler;
import ir.bmi.identity.client.security.reactive.filter.SsoReactiveAuthenticationWebFilter;
import ir.bmi.identity.client.security.reactive.filter.SsoReactiveExcludedUrlsWebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;

@Slf4j
@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfiguration {

  private final BmiSsoTokenProvider bmiSsoTokenProvider;
  private final BmiOAuth2Properties bmiOAuth2Properties;
  private final BmiReactiveSsoExceptionHandler bmiReactiveSsoExceptionHandler;
  private final IMap<String, String> revokedTokensCache;
  private final IMap<String, String> revokedSSNsCache;

  public SecurityConfiguration(BmiSsoTokenProvider bmiSsoTokenProvider, BmiOAuth2Properties bmiOAuth2Properties,BmiReactiveSsoExceptionHandler bmiReactiveSsoExceptionHandler, IMap<String, String> revokedTokensCache,
      IMap<String, String> revokedSSNsCache) {
    this.bmiSsoTokenProvider = bmiSsoTokenProvider;
    this.bmiOAuth2Properties = bmiOAuth2Properties;
    this.bmiReactiveSsoExceptionHandler=bmiReactiveSsoExceptionHandler;
    this.revokedTokensCache = revokedTokensCache;
    this.revokedSSNsCache = revokedSSNsCache;
  }

  @Bean
  public SecurityWebFilterChain ssoBasedSecurityConfig(ServerHttpSecurity http) {
    return http
        .logout().disable()
        .addFilterAt(this.getSsoExcludedUrlsWebFilter(), SecurityWebFiltersOrder.HTTP_BASIC)
        .exceptionHandling()
        .authenticationEntryPoint((exchange, e) ->
            bmiReactiveSsoExceptionHandler.handleSsoAuthorizationException(exchange, new BmiSsoAuthorizationException(e.getMessage(), HttpStatus.UNAUTHORIZED.value())))
        .accessDeniedHandler((exchange, e) ->
            bmiReactiveSsoExceptionHandler.handleSsoAuthorizationException(exchange, new BmiSsoAuthorizationException(e.getMessage(), HttpStatus.FORBIDDEN.value())))
        .and()
        .formLogin().disable()
        .cors().disable()
        .httpBasic().disable()
        .csrf().disable()
        .authorizeExchange()
        .anyExchange().authenticated()
        .and().build();
  }

  private SsoReactiveExcludedUrlsWebFilter getSsoExcludedUrlsWebFilter() {
    return SsoReactiveExcludedUrlsWebFilter.builder()
        .webFilter(new SsoReactiveAuthenticationWebFilter(bmiSsoTokenProvider,bmiReactiveSsoExceptionHandler, revokedTokensCache, revokedSSNsCache  ))
        .build();
  }
}