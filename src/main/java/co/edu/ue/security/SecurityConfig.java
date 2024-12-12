package co.edu.ue.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	
	@Bean  //ME PERMITE VOLVERLO O INYECTARLO COMO UN OBJETO
	public InMemoryUserDetailsManager usermanager() {
		List<UserDetails> users = List.of(
				User
				.withUsername("client")
				.password("{noop}1234")
				.roles("USERS")
			    .build(),
			    User
			    .withUsername("admin")
			    .password("{noop}1234")
			    .roles("ADMINS")
			    .build()
			    );
				
		return new InMemoryUserDetailsManager(users);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
	    http.csrf(cus->cus.disable())
	    .authorizeHttpRequests(aut->
	        aut.requestMatchers(HttpMethod.POST,"/usuarios").hasAnyRole("ADMINS")
	        .requestMatchers(HttpMethod.GET,"/usuarios").authenticated()
	        .requestMatchers(HttpMethod.GET,"/usuarios/{id}").authenticated()
	        .requestMatchers(HttpMethod.GET,"/usuarios/email/{email}").authenticated()
	        .requestMatchers(HttpMethod.PUT,"/usuarios").authenticated()
	        .requestMatchers(HttpMethod.DELETE,"/usuarios/{id}").hasAnyRole("ADMINS")
	        .requestMatchers(HttpMethod.POST,"/perfiles").authenticated()
            .requestMatchers(HttpMethod.GET,"/perfiles").authenticated()
            .requestMatchers(HttpMethod.GET,"/perfiles/{id}").authenticated()
            .requestMatchers(HttpMethod.PUT,"/perfiles").authenticated()
            .requestMatchers(HttpMethod.DELETE,"/perfiles/{id}").hasAnyRole("ADMINS")
	    )
	    .httpBasic(Customizer.withDefaults());
	    return http.build();
	}


}