package com.sunil.sources.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.sources.entities.Person;
import com.sunil.sources.repositories.PersonRepository;

@Service
public class PersonBusinessService {

	@Autowired
	private PersonRepository prepo;
	
	public Person getPersonById(Integer id) {
		return prepo.findOne(id);
	}
	
}
