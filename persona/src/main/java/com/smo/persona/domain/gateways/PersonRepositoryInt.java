package com.smo.persona.domain.gateways;

import com.smo.persona.domain.model.Person;

import java.util.ArrayList;

public interface PersonRepositoryInt {

    ArrayList<Person> findAll();
    Person savePerson(Person person);
    Person findByClientNumDoc(String clientNumDoc);
}
