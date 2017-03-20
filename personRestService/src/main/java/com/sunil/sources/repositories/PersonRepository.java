package com.sunil.sources.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sunil.sources.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}
