package com.api.springcloud.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter{
	public static final String RESOURCE_ID= "couponservice";
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		System.out.println("inside 1st configure method");
		resources.resourceId(RESOURCE_ID);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		System.out.println("inside 2nd configure method");
		http.authorizeRequests().mvcMatchers(HttpMethod.GET,"/couponapi/coupons/{code:^[A-Z]*$}").hasAnyRole("USER","ADMIN")
		.mvcMatchers(HttpMethod.POST,"/couponapi/coupons").hasRole("ADMIN").anyRequest().denyAll().and().csrf().disable();
	}

}
