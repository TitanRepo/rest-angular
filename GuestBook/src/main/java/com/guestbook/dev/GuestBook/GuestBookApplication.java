package com.guestbook.dev.GuestBook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
}
