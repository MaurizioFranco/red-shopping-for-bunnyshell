package com.price.low;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.beans.factory.annotation.Value;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {

//	private static final Logger logger = LoggerFactory.getLogger(ApplicationSecurityConfig.class);
//
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//	      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	      CorsConfiguration config = new CorsConfiguration();
//			config.setAllowedOrigins(Arrays.asList("*"));
//			config.setAllowedMethods(Arrays.asList("*"));
//			config.setAllowedHeaders(Arrays.asList("*"));
//			config.setAllowCredentials(true);
//	      config.applyPermitDefaultValues();
//	      
//	      source.registerCorsConfiguration("/api/v1/**", config);
//	      source.registerCorsConfiguration("/**", config);
////	      source.registerCorsConfiguration("/user", config);
//	      return source;
//	}	
	
	@Value("${FRONTEND_URL:http://localhost}")
    private String frontendUrl;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .cors().configurationSource(corsConfigurationSource());

        return http.build();
    }

    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        //configuration.setAllowedOrigins(List.of(frontendUrl));
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        source.registerCorsConfiguration("/api/v1/**", configuration);

        return source;
    }
	
}






















