package mz.co.ldevz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import mz.co.ldevz.entity.UsuarioPerfil;
import mz.co.ldevz.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// field injection for user service
	@Autowired
	private UserService userService;

	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	private static final String CLIENTE = UsuarioPerfil.CLIENTE.getDesc();
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		
		web.ignoring()
		.antMatchers("/css/***")
		.antMatchers("/image/***")
		.antMatchers("/js/***")
		.antMatchers("webfonts/***");
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
		.antMatchers("/css/***","/image/***","/js/***","webfonts/***").permitAll()
		.antMatchers("/login").permitAll()
		//.antMatchers("/", "/", "/your-reservations").hasAnyRole("EMPLOYEE")
		.antMatchers("/index").permitAll()
		.antMatchers("/bilhetes/salvar").hasAuthority(CLIENTE)
		
		//.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/process-login")
			.successHandler(customAuthenticationSuccessHandler)
			.permitAll()
		.and()
		.logout()
			.logoutUrl("/login")
			.permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/403");
	}

	// beans
	
	// bcrypt bean definition
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// authenticationProvider bean definition
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService); 
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
}
