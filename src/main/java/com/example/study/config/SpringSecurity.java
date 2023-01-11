package com.example.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()        //cors방지
                .csrf().disable()        //csrf방지
                .formLogin().disable()    //기본 로그인 페이지 없애기
                .headers().frameOptions().disable();
    }

    @Bean
    @SuppressWarnings("deprecation ")
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }
}