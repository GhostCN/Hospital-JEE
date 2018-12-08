package org.sid.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConf extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	/*	//http.formLogin().loginPage("/login").defaultSuccessUrl("/medecin/add").permitAll();
			http
		//	.userDetailsService(userDetailsService())
				.authorizeRequests()
				// .antMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()
				//.antMatchers("/medecin/**").access("hasRole('ROLE_MEDECIN')")
				.antMatchers("/admin/**").hasRole("ADMIN")
				//.antMatchers("/secretaire/**").access("hasRole('ROLE_SECRETAIRE')")
				.and()
				.formLogin().
				loginPage("/login").permitAll()
				.defaultSuccessUrl("/medecin/add");
			//	.successHandler(myAuthenticateSuccesHandler());
				
				*/
		
		//http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.csrf().disable();
		http.formLogin()
		.loginPage("/login").permitAll()
		.failureUrl("/login?error")
		.successHandler(myAuthenticateSuccesHandler())
		.and()
		.authorizeRequests()
		.antMatchers("/css/**","/Js/**").permitAll()
		.antMatchers("/admin/**").hasAuthority("ADMIN")
		.antMatchers("/medecin/**").hasAuthority("MEDECIN")
		.antMatchers("/secretaire/**").hasAuthority("SECRETAIRE")
		.anyRequest().authenticated();
		
	}
	@Bean
	public MySimpleUrlAuthenticationSuccessHandler myAuthenticateSuccesHandler() {
		return new MySimpleUrlAuthenticationSuccessHandler();
		
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	/*
	 * @Bean
	 * 
	 * @Override public UserDetailsService userDetailsService() { UserDetails user =
	 * User.withDefaultPasswordEncoder() .username("ghost") .password("passer")
	 * .roles("USER") .build();
	 * 
	 * return new InMemoryUserDetailsManager(user); }
	 */
}
