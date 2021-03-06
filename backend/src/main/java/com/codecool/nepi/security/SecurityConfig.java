package com.codecool.nepi.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenServices jwtTokenServices;

    @Autowired
    public SecurityConfig(JwtTokenServices jwtTokenServices){
        this.jwtTokenServices = jwtTokenServices;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests() // restrict access based on endpoint config below
                .antMatchers(POST, "/").permitAll()
                .antMatchers(GET,"/").permitAll()
                .antMatchers(GET,"/get-user-details").hasAnyRole("ADMIN","OVERSEER","OPERATOR","OWNER","RENTER")
                .antMatchers(POST, "/tickets/new").hasAnyRole("OWNER", "RENTER")
                .antMatchers(GET, "/tickets/show").hasAnyRole("OWNER", "RENTER", "OPERATOR")
                .antMatchers(GET, "/tickets/resolve-ticket").hasAnyRole("OPERATOR", "ADMIN", "OVERSEER")
                .antMatchers(POST, "/tickets/resolve-ticket").hasAnyRole("OPERATOR", "ADMIN", "OVERSEER")
                .antMatchers(POST,"/registration/owners","/registration/tenants","/registration/utilities").permitAll()
                .antMatchers(GET,"/registration/check-enrolledPropertyIds", "/registration/check-companyAllocatedIds").permitAll()
                .antMatchers(POST, "/registration/owner/**").hasRole("OWNER")
                .antMatchers(GET,"/tickets/all","/tickets/type","/tickets/operators/all").hasAnyRole("OVERSEER", "ADMIN")
                .antMatchers(POST,"/tickets/assign-operator").hasRole("OVERSEER")
//                .antMatchers(GET, "/TEST-DASHBOARD").hasRole("ADMIN")
                .antMatchers(GET,"/**").hasRole("ADMIN")
                .antMatchers(POST,"/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JwtTokenFilter(jwtTokenServices), UsernamePasswordAuthenticationFilter.class);
    }
}
