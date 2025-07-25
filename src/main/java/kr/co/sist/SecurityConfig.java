package kr.co.sist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain( HttpSecurity http)throws Exception{
		//필터 체인 설정 : 로그인 창을 제공하지 않도록 설정
		//모든 요청에대한 인증없이 사용가능하도록 설정.
		http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
		//csrf : 접속자의 연결 정보(세션)를 가로채서 접속하는 것 
		.csrf(csrf -> csrf.disable())
		//login box를 사용하지 않을 때
		.formLogin(login -> login.disable());
		
		return http.build();
	}//filterChain
	
}//class
