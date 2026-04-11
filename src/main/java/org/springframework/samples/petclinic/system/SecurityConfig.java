//Done
package org.springframework.samples.petclinic.system;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * File này là cấu hình Spring Security trong project Spring Boot (PetClinic).
 * Nó quyết định ai được truy cập vào URL nào và cách bảo vệ ứng dụng.
 * Spring thường có file này và nó được để trong folder system của package
 */
@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
			.headers(headers -> headers.frameOptions(frame -> frame.disable()))
			.authorizeHttpRequests(auth -> auth.requestMatchers("/h2-console/**").permitAll().anyRequest().permitAll());

		return http.build();
	}

}
