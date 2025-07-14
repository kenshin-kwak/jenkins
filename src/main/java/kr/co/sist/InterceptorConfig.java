package kr.co.sist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.sist.interceptor.UserInterceptor;

@Configuration
//1. WebMvcConfigurer를 구현
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Value("${myapp.user.addPath}")
	List<String> addUserPathList;
	
	@Value("${myapp.user.excludePath}")
	List<String> exculueUserPathList;
	
	//2. 제작한 Interceptor를 의존성 주입
	@Autowired
	private UserInterceptor ui;	

	/**
	 *3.제작된 interceptor가 동작할 URI를 설정하여 등록
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		//UserInterceptor 등록.		
		registry.addInterceptor(ui).addPathPatterns(addUserPathList).
		excludePathPatterns(exculueUserPathList);
		
		
	}//addInterceptors
	
	

}//class
