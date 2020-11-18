package com.demo.backend;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	  @Bean
//	  public WebSecurityConfigurerAdapter webSecurityConfig(DataSource dataSource) {
//	      return new WebSecurityConfigurerAdapter() {
//	          @Override
//	          protected void configure(HttpSecurity http) throws Exception {
//	              http.authorizeRequests()
//	              .antMatchers(HttpMethod.POST, "/user").permitAll()
//	  			.antMatchers("/h2-console/**").permitAll()
//	  			.anyRequest().authenticated().and().csrf().ignoringAntMatchers("/user").ignoringAntMatchers("/h2-console/**")//don't apply CSRF protection to /h2-console
//	              .and().headers().frameOptions().sameOrigin();
//	          }
//
//	          @Override
//	          protected void configure(AuthenticationManagerBuilder builder) throws Exception {
//	              builder.jdbcAuthentication()
//	                     .dataSource(dataSource);
//	          }
//	      };
//	  }
}
