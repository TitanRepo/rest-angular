package com.guestbook.dev.GuestBook;

import java.util.Collections;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class GuestBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestBookApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(GuestBookRepository repository) {
		return args -> {
			Stream.of(new GuestBookStream("Test",new Date(),"Test"), new GuestBookStream("Test 2",new Date(),"Test 2")).forEach(guestStream -> {
			GuestBookEntity gbe = new GuestBookEntity();
			gbe.setGuestName(guestStream.getGuestName());
			gbe.setComment(guestStream.getComment());
			//gbe.setCreatedDate(guestStream.getCreatedDate());
			repository.save(gbe);
		});
			repository.findAll().forEach(ent -> System.out.println(ent.getGuestName() + "--" + ent.getId()));
		};
	}
	
	@Bean
	public FilterRegistrationBean simpleCorsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
	    config.setAllowedMethods(Collections.singletonList("*"));
	    config.setAllowedHeaders(Collections.singletonList("*"));
	    source.registerCorsConfiguration("/**", config);
	    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	    return bean;
	}
}
