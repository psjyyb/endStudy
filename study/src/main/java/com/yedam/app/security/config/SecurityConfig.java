package com.yedam.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.headers().frameOptions().disable();

		http.authorizeHttpRequests().antMatchers("/**", "/login", "/signUp", "/overlapChk").permitAll().and()
				.formLogin().loginPage("/login") // 로그인 페이지 경로
				.defaultSuccessUrl("/") // 로그인 성공 시 이동할 페이지
				.and().logout().permitAll(); // 로그아웃 허용
		return http.build();
	}
}
