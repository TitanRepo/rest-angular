package com.guestbook.dev.GuestBook;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GuestBookRepositoryTest {

    @Autowired

    private TestEntityManager entityManager;

    @Autowired

    private GuestBookRepository guestRepository;

    @Test

    public void testFindByName() {

    	GuestBookEntity gbe = new GuestBookEntity();
    	gbe.setGuestName("Test 3");
        entityManager.persist(gbe);

        Optional<GuestBookEntity> client = guestRepository.findById(gbe.getId());

        assertEquals("Test 3", client.get().getGuestName());

    }
}
