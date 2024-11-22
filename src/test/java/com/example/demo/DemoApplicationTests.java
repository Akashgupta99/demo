package com.example.demo;

import com.example.demo.dao.FakePersonDataAccessService;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testAddPerson() {
		UUID id = UUID.randomUUID();
		Person person = new Person(id, "Akash Gupta");
		FakePersonDataAccessService personDao = new FakePersonDataAccessService();
		PersonService ps = new PersonService(personDao);
		int res = ps.addPerson(person);
		Assertions.assertEquals(0, res);
	}

}
