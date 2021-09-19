package greta.cda.bakeryproject.configuration;

import greta.cda.bakeryproject.security.filter.JwtAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtAuthorizationFilter jwtAuthorizationFilter;

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.httpBasic()
                .and()
                .formLogin();

        http.authorizeRequests()
                .antMatchers("/sign-up", "/auth").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "product").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "product").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "product").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "person/{id}").hasRole("ADMIN")
                .anyRequest().authenticated();

        // Add JWT token filter
        http.addFilterBefore(
                jwtAuthorizationFilter,
                UsernamePasswordAuthenticationFilter.class
        );
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
