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

		http.authorizeHttpRequests().antMatchers("/**", "/login", "/signUp", "/overlapChk")
				 .permitAll().anyRequest().authenticated().and()
			.formLogin()
				 .loginPage("/login")
				 .loginProcessingUrl("/successLogin")
				.defaultSuccessUrl("/") // 로그인 성공 시 이동할 페이지
				.failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
             .logout()
                .logoutUrl("/logout")
        		.logoutSuccessUrl("/login?logout=true")
        		.invalidateHttpSession(true) 
        		.clearAuthentication(true)
        		.permitAll();
		return http.build();
	}
}
