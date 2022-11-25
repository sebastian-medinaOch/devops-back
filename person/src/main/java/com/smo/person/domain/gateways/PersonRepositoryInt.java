package com.smo.person.domain.gateways;

import com.smo.person.domain.exception.BussinessException;
import com.smo.person.domain.model.Person;

import java.util.ArrayList;

public interface PersonRepositoryInt {

    ArrayList<Person> findAll();
    Person savePerson(Person person);
    Person findByClientNumDoc(String clientNumDoc) throws BussinessException;
    Long deleteByPersonId(Long personId);
}
