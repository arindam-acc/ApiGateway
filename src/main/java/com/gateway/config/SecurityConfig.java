package com.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig  {

	@Bean
	SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
		return httpSecurity
		        .authorizeExchange(exchanges -> exchanges
		            .anyExchange().authenticated()
		        )
		        .oauth2Client()
		        .and()
		        .oauth2ResourceServer(oauth2 -> oauth2
		            .jwt()
		        )
		        .build();
	}
}
