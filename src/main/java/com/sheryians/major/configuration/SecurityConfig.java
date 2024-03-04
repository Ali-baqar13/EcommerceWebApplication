package com.sheryians.major.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sheryians.major.repository.RoleRepostory;
import com.sheryians.major.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
	@Autowired
	private GoogleOAuth2SuccessHandler googleOAuth2SucessHnadler;
	@Autowired
	CustomUserDetailService customUserDetailService;
	@Autowired
	RoleRepostory Rolerepo;

	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http
				.authorizeHttpRequests(authz -> authz.requestMatchers("/", "/home", "/shop/**", "/register").permitAll()
						.requestMatchers("/admin/**").hasRole("ADMIN").anyRequest()

						.authenticated())

				.formLogin(form -> form.loginPage("/login").permitAll().failureUrl("/login?error=true")
						.defaultSuccessUrl("/home").usernameParameter("email").passwordParameter("password")

				).oauth2Login(oauth2 -> oauth2.loginPage("/login").successHandler(googleOAuth2SucessHnadler)
				// .successHandler(googleOAuth2SuccessHandler)
				)
				.logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.logoutSuccessUrl("/login").invalidateHttpSession(true).deleteCookies("JSESSIONID"))
				.exceptionHandling(
						expect -> expect.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")))

				.csrf(csrf -> csrf.disable()).build();
		// http.headers(head -> head.frameOptions(frame -> frame.disable()));
		// return http.build();

	}

	@Bean
	PasswordEncoder passwordEncoder() {

		return PasswordEncoderFactories.createDelegatingPasswordEncoder();

	}

	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(customUserDetailService);

		return provider;

	}

	protected WebSecurityCustomizer configuer() {
		return (web) -> web.ignoring().requestMatchers("/resources/**", "/static/**", "/images", "/productImages/**",
				"/css/**", "/js/**");
	}

}
