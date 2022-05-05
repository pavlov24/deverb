package pavlov24.deverb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // @formatter:off
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests((authorize) ->
                        authorize
                                .antMatchers("/**").permitAll());

    }
    // @formatter:on

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder(16);
    }
}