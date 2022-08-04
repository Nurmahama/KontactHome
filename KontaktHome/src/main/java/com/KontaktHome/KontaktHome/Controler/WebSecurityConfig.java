package com.KontaktHome.KontaktHome.Controler;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Maqa")
                .password("pas")
                .roles("ADMIN")
                .and()
                .withUser("Zaur")
                .password("pas")
                .roles("USER");
    }
      @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/get") .hasRole("ADMIN")
                    .antMatchers("/create") .hasRole("ADMIN")
                    .antMatchers("/ALL") .hasRole("ADMIN")
                    .antMatchers("/update").hasRole("ADMIN")
                    .antMatchers("/delet").hasRole("ADMIN")
                    .antMatchers("/findById{id}").hasAnyRole("USER","ADMIN")
                    .antMatchers("/get").permitAll()
                    .and().formLogin();
        }
    @Bean
    public PasswordEncoder encoder() {
        return NoOpPasswordEncoder.getInstance();
    }


}
