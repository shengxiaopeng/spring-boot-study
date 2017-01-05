package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * ${DESCRIPTION}
 *
 * @author sxp
 * @create 2016/12/31.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 覆盖默认安全配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

     /*   http.authorizeRequests()
                .antMatchers("/hello1").permitAll()
                .antMatchers("/hello").denyAll();*/

    }


}
