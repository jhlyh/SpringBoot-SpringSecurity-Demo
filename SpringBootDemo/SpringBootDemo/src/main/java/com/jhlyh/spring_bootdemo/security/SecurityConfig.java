package com.jhlyh.spring_bootdemo.security;

import com.jhlyh.spring_bootdemo.repository.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * @author jhlyh
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{



    DataSource dataSource;
    UserDetailsService userDetailsService;

    @Autowired(required = false)
    public SecurityConfig(DataSource dataSource,UserDetailsService userDetailsService) {
        this.dataSource = dataSource;
        this.userDetailsService = userDetailsService;
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        /*return NoOpPasswordEncoder.getInstance();*/
        return new BCryptPasswordEncoder();
    }

    /*基于内存的用户存储*/
   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("buzz")
                .password(passwordEncoder().encode("123"))
                .authorities("ROLE_USER");
    }*/

    /*基于JDBC的用户存储*/
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username,password,enabled from Users "
                        + "where username = ?"
                )
                .passwordEncoder(passwordEncoder());
    }*/

    /*基于自定义的用户存储*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/taco","/test")
                .hasRole("ADMIN")
                .antMatchers("/","/**").permitAll()

                .and()
                .formLogin()
                .permitAll()
                .defaultSuccessUrl("/taco")

                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/")

                .and()
                .csrf()
                .disable();

    }
}
