package com.sunil.sources.rest.services;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sunil.sources.business.services.PersonBusinessService;
import com.sunil.sources.entities.Person;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonRestService.class)
public class PersonRestServiceTest {
	
	@Autowired
	private MockMvc mmvc;
	
	@MockBean
	private PersonBusinessService pservice;
	
	@Test
	public void testGetPerson() throws Exception {
		Person pob = new Person(1,"CAPTAIN");
		String URL = "http://localhost:8080/plist/{id}.json";
		Integer id = 1;
		
		String jsonContent = "{\"id\":1,\"name\":\"CAPTAIN\"}";
		
		given(pservice.getPersonById(id)).willReturn(pob);
		
		mmvc.perform(get(URL, id).accept(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(content().json(jsonContent));
		
	}

}
