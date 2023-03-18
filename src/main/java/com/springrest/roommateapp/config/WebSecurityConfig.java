package com.springrest.roommateapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.springrest.roommateapp.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	    return new MySimpleUrlAuthenticationSuccessHandler();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http
			.authorizeHttpRequests((auth) -> auth
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.requestMatchers("/user/**").hasRole("USER")
					.requestMatchers("/**").permitAll()
					.anyRequest().authenticated()
				)
				.userDetailsService(userDetailsService)
				.formLogin((formLogin) -> formLogin
						.usernameParameter("email")
						.loginPage("/api/login")
						.successHandler(myAuthenticationSuccessHandler())
						.failureUrl("/api/login?error=true")
						)
				.logout((logout)->logout
						.logoutUrl("/api/logout")
						.logoutSuccessUrl("/api/login?logout=true")
						.invalidateHttpSession(true)
						.deleteCookies("JSESSIONID")
					)
				.headers()
				.defaultsDisabled()
				.cacheControl();
			return http.build();
	}
	
	  @Bean
	  public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	    	//return new BCryptPasswordEncoder(10);
	}
	
}
