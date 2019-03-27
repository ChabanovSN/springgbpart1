package ru.chabanov.spring.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private void configAuthenticaton(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select login, password, true  from company_app where login=?")
		.authoritiesByUsernameQuery("select a.login, r.name  from role r JOIN company_app "
				+ "a ON r.id=a.role_id WHERE a.login=?");

	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
	
      http.authorizeRequests().antMatchers(HttpMethod.GET,"/articles/*/edit").hasAuthority("admin")
      .antMatchers(HttpMethod.GET,"/articles/add").hasAnyAuthority("admin","user")
      .and().formLogin().loginPage("/login").loginProcessingUrl("/login")
      .usernameParameter("login").passwordParameter("password").failureUrl("/loginfailed")
      .and().logout().logoutSuccessUrl("/");
		
	}

}
