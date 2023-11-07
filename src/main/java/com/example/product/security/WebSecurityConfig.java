package com.example.product.security;

import com.example.product.filter.CustomAuthorizationFilter;
import com.example.product.filter.CustomAuthenicationFilter;
//import com.example.product.models.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.*;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@CrossOrigin
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig<CustomAuthenticationFilter> extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    AppConfig appConfig = new AppConfig();

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenicationFilter customAuthenticationFilter = new CustomAuthenicationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/users/login");
        http.csrf().disable();
        http.cors();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
//        http.authorizeRequests().antMatchers( "/users/login").permitAll().anyRequest().authenticated();
//        http.exceptionHandling().authenticationEntryPoint((
//                (request, response, authException) -> {
//                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
//                }
//                ));
        http.authorizeRequests().antMatchers( "/certificate/**").hasAnyAuthority("admin","user");
        http.authorizeRequests().antMatchers("/product/**").permitAll();
        http.authorizeRequests().antMatchers("/product/{id}").permitAll();
//
//
//
        http.authorizeRequests().antMatchers( POST,"/users/login").permitAll();
        http.authorizeRequests().antMatchers(GET, "/users").permitAll();
        http.authorizeRequests().antMatchers(POST, "/users").hasAnyAuthority("admin");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(appConfig.passwordEncoder());
    }


}

