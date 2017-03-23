package com.sunil.sources.business.services;

import static org.mockito.BDDMockito.given;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sunil.sources.entities.Person;
import com.sunil.sources.repositories.PersonRepository;

@WebMvcTest(PersonBusinessService.class)
@RunWith(SpringRunner.class)
public class PersonBusinessServiceTest {
	
	@MockBean
	private PersonRepository prepo;
	
	@Autowired
	private PersonBusinessService pservice;
	
	@Test
	public void testGetPersonById() {
		Person expected = new Person(1,"TESTER");
		Integer id = 1;
		given(prepo.findOne(id)).willReturn(expected);
		
		Person actual = pservice.getPersonById(id);
		Assert.assertEquals(expected, actual);
	}

}
