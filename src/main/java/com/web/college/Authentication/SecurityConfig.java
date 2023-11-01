package com.web.college.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
//import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
//import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
//import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

@Configuration
public class SecurityConfig {
//    @Bean
//    public AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> apiKeyFilter() {
//        ApiKeyFilter filter = new ApiKeyFilter();
//        filter.setCheckForPrincipalChanges(true);
//        return filter;
//    }
//
//    @Bean
//    public RequestHeaderAuthenticationFilter requestHeaderAuthenticationFilter() {
//        RequestHeaderAuthenticationFilter filter = new RequestHeaderAuthenticationFilter();
//        filter.setPrincipalRequestHeader("X-API-Key");
//        filter.setAuthenticationManager(authenticationManager());
//        return filter;
//    }
//
//    @Bean
//    public PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider() {
//        PreAuthenticatedAuthenticationProvider provider = new PreAuthenticatedAuthenticationProvider();
//        provider.setPreAuthenticatedUserDetailsService(apiKeyFilter());
//        return provider;
//    }
}
