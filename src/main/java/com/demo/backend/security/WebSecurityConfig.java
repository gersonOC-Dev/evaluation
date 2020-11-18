package com.demo.backend.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		
			.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/venta/register").authenticated()
			.antMatchers(HttpMethod.POST, "/client/register").authenticated()
			.antMatchers(HttpMethod.POST, "/producto/register").authenticated()
			.antMatchers(HttpMethod.PUT, "/producto/update").authenticated()
			.antMatchers(HttpMethod.DELETE, "/producto/delete").authenticated()
			.antMatchers(HttpMethod.POST, "/user").permitAll()
			.antMatchers("/h2-console/**").permitAll()
			.anyRequest().authenticated().and().csrf()
			.ignoringAntMatchers("/venta/register")
			.ignoringAntMatchers("/client/register")
			.ignoringAntMatchers("/producto/register")
			.ignoringAntMatchers("/producto/update")
			.ignoringAntMatchers("/producto/delete/**")
			.ignoringAntMatchers("/user").ignoringAntMatchers("/h2-console/**")//don't apply CSRF protection to /h2-console
            .and().headers().frameOptions().sameOrigin();
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.jdbcAuthentication()
               .dataSource(dataSource);
    }
	
	
	
}