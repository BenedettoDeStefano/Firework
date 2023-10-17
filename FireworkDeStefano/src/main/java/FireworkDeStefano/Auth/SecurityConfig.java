package FireworkDeStefano.Auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(c -> c.disable());

		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


		http.authorizeHttpRequests(auth -> auth.requestMatchers("/auth/**").permitAll());


		http.authorizeHttpRequests(
				authz -> authz
						.requestMatchers(HttpMethod.GET, "/**").permitAll().requestMatchers(HttpMethod.POST, "/**")
						.permitAll().requestMatchers(HttpMethod.PUT, "/**").permitAll()
						.requestMatchers(HttpMethod.DELETE, "/**").permitAll()
						.anyRequest().authenticated());

		return http.build();
	}



}

