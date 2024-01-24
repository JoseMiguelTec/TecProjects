package es.tecdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("es.tecdata")
public class JavaConfig {

	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setViewClass(JstlView.class);
		view.setPrefix("/WEB-INF/JSP/");
		view.setSuffix(".jsp");
		return view;
	}

	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		return new BeanNameViewResolver();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
