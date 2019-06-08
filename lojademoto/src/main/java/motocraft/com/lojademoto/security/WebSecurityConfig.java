package motocraft.com.lojademoto.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.
                 authorizeRequests()
                    .antMatchers("/carrinho/finalizar").hasAnyRole("PM_USUARIO")
                    .anyRequest()
                    .authenticated()
                  .and()
                    .formLogin()
                        .loginPage("/entrar")
                        .permitAll();
    }
}
