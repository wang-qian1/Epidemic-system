package com.sanley.coronavirus.config;/*
Created by shkstart on 2020/3/15.
*/

import com.sanley.coronavirus.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService myUserDetailService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/index").permitAll()
                .antMatchers("/patient/**","/touch/**","/cure/**","/dead/**").hasRole("User")
                .antMatchers("/manager/**").hasRole("Admin");

        //开启自动配置的登录功能
        http.formLogin().loginPage("/login").passwordParameter("password").usernameParameter("username").failureForwardUrl("/login").loginProcessingUrl("/login.do").successForwardUrl("/indexpage");
        //关闭csrf保护功能
        http.csrf().disable();
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login");
        //开启记住我功能
    }
    //定制认证页面
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                //创建内存用户n-user
                .withUser("Sanley")
                //设置密码为123456
     .password( new BCryptPasswordEncoder().encode("123456"))
                //权限是user
                .roles("User","Admin");
        auth.authenticationProvider(authenticationProvider());
    }
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        authenticationProvider.setUserDetailsService(myUserDetailService);
        return  authenticationProvider;

    }
}
