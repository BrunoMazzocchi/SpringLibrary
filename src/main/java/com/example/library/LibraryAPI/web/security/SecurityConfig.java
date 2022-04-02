package com.example.library.LibraryAPI.web.security;

import com.example.library.LibraryAPI.domain.service.*;
import com.example.library.LibraryAPI.web.security.filter.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.http.*;
import org.springframework.security.web.authentication.*;
import org.springframework.stereotype.*;


@Component
@EnableAutoConfiguration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LibraryUserDetailService libraryUserDetailService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth)  throws  Exception{
        auth.userDetailsService(libraryUserDetailService);
    }

    @Autowired
    private JwtFilterRequest jwtFilterRequest;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .anyRequest().authenticated().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); //nuestra app no tiene sesion

        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);

        http.antMatcher("/v2/api-docs/**");
        http.antMatcher("/swagger.json");
        http.antMatcher("/swagger-resources/**");
        http.antMatcher("/webjars/**");
    }

    @Override
    @Bean //Lo utilice y sepa que lo usamos como gestor de autenticacion
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
