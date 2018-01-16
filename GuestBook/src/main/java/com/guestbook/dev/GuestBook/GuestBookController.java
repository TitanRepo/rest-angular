package com.guestbook.dev.GuestBook;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestBookController {

	private GuestBookRepository repository;

	public GuestBookController(GuestBookRepository repository) {
		super();
		this.repository = repository;
	}
	
	@GetMapping("/getGuests")
	@CrossOrigin(origins="**")
	public Collection<GuestBookEntity> getGuestList() {
		return (Collection<GuestBookEntity>) repository.findAll();
	}
}
