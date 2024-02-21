package ua.com.securityApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ua.com.securityApp.services.PersonDetailsService;

/**
 * @author Anton Muzhytskyi
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfiguration {    //was configurer
	
	private final PersonDetailsService personDetailsService;
	private final JWTFilter jwtFilter;
		
	@Autowired
	public SecurityConfig(PersonDetailsService personDetailsService, JWTFilter jwtFilter ) {
		this.personDetailsService = personDetailsService;
		this.jwtFilter = jwtFilter;
	}
	
	//@Override
	//@SuppressWarnings({ "deprecation", "removal" })
	protected void configure(HttpSecurity http) throws Exception{
		http
			
			.csrf().disable()
			.authorizeRequests()      // podklyuchaem autorizaciyu na vse zaprosi k prilozheniyu
			.requestMatchers("/admin").hasRole("ADMIN")    //  was  antMatchers
			.requestMatchers("/auth/login", "/auth/registration", "/error").permitAll()      //na eti adressa puskaem vseh
			//.anyRequest().authenticated()                    // na vse ostalnie stranici vedud k avtorizacii
			.anyRequest().hasAnyRole("USER", "ADMIN")
			.and()
			.formLogin().loginPage("/auth/login")
			.loginProcessingUrl("/process_login")        //poluchaem dannie kotorie prihodyat na address   process_login
			.defaultSuccessUrl("/hello", true)           // ukazivaem kuda perenapravlyaem posle udachnogo logina
			.failureUrl("/auth/login?error")              // kuda napravit v sluchae oshibki logina
			.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/auth/login")
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS); 
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
		
	
	//@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(personDetailsService)
		.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	//@Override
	public AuthenticationManager authenticationManagerBean()  throws Exception{
		return super.authenticationManagerBean();
	}
}
