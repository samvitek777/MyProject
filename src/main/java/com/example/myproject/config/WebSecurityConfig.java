package com.example.myproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;



    //сonfigure определяет какой URL нужно защищать, а какой не надо (по умолчанию все защищено)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    //antMatchers(“...”).permitAll() данные urls защищать не надо
                    .antMatchers("/resources/**","/", "/registration", "/libs/bootstrap.min.css",
                            "/css/index.css", "/css/register.css", "/img/baraholka.png").permitAll()  //antMatchers(“...”).permitAll() данные urls защищать не надо
                    .anyRequest().authenticated()
                    .and()
                //loginPage(“/login”) определяется страница для совершения логина в приложение, которая доступна всем
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                //logout().permitAll() определяет что разлогиниться могут все
                .logout()
                    .permitAll();
    }

    //Осуществлять вход по специально написанному провайдеру аутентификации


    //добавление пользователя для авторизации -- нихуя не работает
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("User");
    }

    //Шифровальщик паролей
    @Bean
    PasswordEncoder passwordEncoder()
    {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }
}
