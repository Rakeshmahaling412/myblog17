package airbnb16.airbnb16.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
public class SpringSecurityConfig {
    private JWTRequestFilter jwtRequestFilter;

    public SpringSecurityConfig(JWTRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable().cors().disable();
        http.addFilterBefore(jwtRequestFilter, AuthorizationFilter.class);
        http.authorizeHttpRequests()
                .requestMatchers("/api/v1/users/sign-up","/api/v1/users/sign-in").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/properties").permitAll()
                .requestMatchers("/api/v1/countries/addCountry").hasRole("ADMIN")
                .requestMatchers("/api/v1/properties/addProperty").hasRole("ADMIN")
                .requestMatchers("/api/v1/users/profile").hasAnyRole("ADMIN","USER")
                .anyRequest().authenticated();
        return http.build();
    }
}
