package cinema.booking.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired 
	private DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.jdbcAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).dataSource(dataSource)
		.usersByUsernameQuery(
				"select email, password, enabled from user where email=?")
		.authoritiesByUsernameQuery(
			"select email, role from user where email=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
        .authorizeRequests()
            .antMatchers(
            		"/", "/home", "/homepage", "/movies", "/comingSoon", "/registration", "/registrationConfirmation/**",
            		"/bootstrap/**", "/css/**", "/images/**", "/activate/**",
            		 "/js/**", "/dist/**", "/album.css",
                     "/img/**",
                     "/webjars/**",
                     "/assets/**"
            		).permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            //.successHandler(successHandler())
            .permitAll()
            .usernameParameter("username").passwordParameter("password")
            .and()
        .logout()
        	.logoutSuccessUrl("/?logout")
            .permitAll()
		.and()
        .rememberMe().key("uniqueAndSecret")
        ;
	}	
	
	@Bean
	public AuthenticationSuccessHandler successHandler() {
	    SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
	    handler.setUseReferer(true);
	    return handler;
	}

}


