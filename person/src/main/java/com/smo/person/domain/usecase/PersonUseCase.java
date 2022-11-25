package com.smo.person.domain.usecase;

import com.smo.person.domain.exception.BussinessException;
import com.smo.person.domain.gateways.PersonRepositoryInt;
import com.smo.person.domain.model.Person;
import com.smo.person.infrastructure.persistencia.entity.PersonEntity;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class PersonUseCase {

    private final PersonRepositoryInt personRepositoryInt;

    public PersonEntity createPerson(PersonEntity personEntity){
        return personRepositoryInt.savePerson(personEntity);
    }

    public PersonEntity getPersonByNumDoc(String clientNumDoc){
        return personRepositoryInt.findByClientNumDoc(clientNumDoc);
    }

    public ArrayList<PersonEntity> getPersons(){
        return personRepositoryInt.findAll();
    }

    public void deletePerson(Long personId){
        personRepositoryInt.deleteByPersonId(personId);
    }

}
