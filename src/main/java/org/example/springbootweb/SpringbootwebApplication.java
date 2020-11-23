package org.example.springbootweb;

import org.example.springbootweb.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class SpringbootwebApplication {

	public static void main(String[] args) {
		var applicationContext  = SpringApplication.run(SpringbootwebApplication.class, args);
		/*
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
		*/
	}
	/*
	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	*/

	@Bean
	public WebMvcConfigurer corsConfigurer() {

		return new WebMvcConfigurerAdapter() {
			@Autowired
			PropertyService propertyService;

			/*@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry
						.addResourceHandler("/reportfiles/**").addResourceLocations("file:/Users/lmartinez/git/hcare/hcare_backend_v2_1/reports/out/");
			}
			*/
			@Override
			public void addCorsMappings(CorsRegistry registry) {

				String frontEndUrl = (String) propertyService.getPropertiesMap().get("frontEndUrl");
				registry.addMapping("/api/loadProperties").allowedOrigins(frontEndUrl);
			}
		};
	}
}
