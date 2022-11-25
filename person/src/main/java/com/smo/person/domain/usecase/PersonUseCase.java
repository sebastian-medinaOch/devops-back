package com.smo.person.domain.usecase;

import com.smo.person.domain.exception.BussinessException;
import com.smo.person.domain.gateways.PersonRepositoryInt;
import com.smo.person.domain.model.Person;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class PersonUseCase {

    private final PersonRepositoryInt personRepositoryInt;

    public Person createPerson(Person person){
        return personRepositoryInt.savePerson(person);
    }

    public Person getPersonByNumDoc(String clientNumDoc) throws BussinessException {
        return personRepositoryInt.findByClientNumDoc(clientNumDoc);
    }

    public ArrayList<Person> getPersons(){
        return personRepositoryInt.findAll();
    }

    public void deletePerson(Long personId){
        personRepositoryInt.deleteByPersonId(personId);
    }

}
