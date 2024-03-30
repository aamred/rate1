package com.rate.Am.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.rate.Am.services.RaterDetailsService;

/**
 * @author Anton Muzhytskyi
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration  {

	private final RaterDetailsService raterDetailService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public SecurityConfiguration(RaterDetailsService raterDetailService) {
		//super();
		this.raterDetailService = raterDetailService;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.requestMatchers("/admin").hasRole("ADMIN")    //  was  antMatchers
		.requestMatchers("/auth/login", "/auth/registration", "/error").permitAll()      //na eti adressa puskaem vseh
		.requestMatchers("/api/request").hasRole("USER")                // na vse ostalnie stranici vedud k avtorizacii
		.anyRequest().hasAnyRole("USER", "ADMIN")
		//.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/auth/login")
		.loginProcessingUrl("/process_login")        //poluchaem dannie kotorie prihodyat na address   process_login
		.defaultSuccessUrl("/api/check", true)           // ukazivaem kuda perenapravlyaem posle udachnogo logina
		.failureUrl("/auth/login?error")              // kuda napravit v sluchae oshibki logina
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/auth/login");

		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
	}
 
    
}
