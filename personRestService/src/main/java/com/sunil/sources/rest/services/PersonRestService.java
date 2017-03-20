package com.sunil.sources.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunil.sources.business.services.PersonBusinessService;
import com.sunil.sources.entities.Person;

@RestController
public class PersonRestService {
	
	@Autowired
	private PersonBusinessService pservice;
	
	@RequestMapping(value="/plist/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Person getPerson(@PathVariable Integer id) {
		return pservice.getPersonById(id);
	}
}
