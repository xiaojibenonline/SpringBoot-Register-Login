/**
 *
 */
package online.xiaojiben.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import online.xiaojiben.controller.interceptor.MainInterceptor;;

/**
 * @author: XiaoLi
 * @Create_time: 2019年3月25日 下午1:33:18
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/*
		 * 拦截器按照顺序执行
		 */
		registry.addInterceptor(new MainInterceptor()).addPathPatterns("/main/**");
		
		super.addInterceptors(registry);
	}
	
	@Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		/*
		 * 设置静态资源访问路径
		 */
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
