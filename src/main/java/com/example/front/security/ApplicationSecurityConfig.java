package com.example.front.security;

import com.example.front.Auth.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import java.util.concurrent.TimeUnit;
import static com.example.front.security.UserRole.*;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) // dzięki temu działają adnotacje nad endpointami
class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;
    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
                                     ApplicationUserService applicationUserService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests() // deklarujemy że zadania muszą byc autoryzowane
                    .antMatchers("/", "/index","/user**", "/account**",
                            "/shopping/**","/productDetail/**","/Img/Obrazy/**",
                            "/returnToShopping","adaptation**") // część naszej białej listy
                    .permitAll()// kolejna część białej listy
        //"/shopping/** to poprawić bo będzie dostęp
                .antMatchers("/shopping/addToCart", "/basket")
                    .hasAnyRole(CLIENT.name(), ADMIN.name())
                .antMatchers("/admin")
                    .hasRole(ADMIN.name())
                .and()
                .formLogin()
                    .loginPage("/user/validateUser")
                    .permitAll()
                    .defaultSuccessUrl("/", true)
                    .passwordParameter("password")
                    .usernameParameter("username")// 21jeśli chcemy użyć innej nazwy niz pliku html
                    .successHandler(addLogParameter())
                .and()
                    .rememberMe() // domyślnie działa przez 30 minut braku aktywności
                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                    .key("trudnykluczszyfrujacy") // klucz do szyfrowania przez MD5 dla zawartości, czyli 'username', 'expirationDate'
                    .rememberMeParameter("remember-me")
                .and()
                    .logout()
                    .logoutUrl("/user/logOut")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID", "remember-me")
                    .logoutSuccessUrl("/login")
                .and()
                    .exceptionHandling()
                    .accessDeniedHandler(accessDeniedHandler());
    }

    private AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> {
                response.sendRedirect("/index");
        };
    }


    @Bean
    public AuthenticationSuccessHandler addLogParameter() {
        return new SuccessHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(applicationUserService)
                .passwordEncoder(passwordEncoder);
    }
}
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder);
//        provider.setUserDetailsService(applicationUserService);
//        return provider;
//    }


