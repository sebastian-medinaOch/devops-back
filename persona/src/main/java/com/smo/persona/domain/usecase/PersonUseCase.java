package com.smo.persona.domain.usecase;

import com.smo.persona.domain.gateways.PersonRepositoryInt;
import com.smo.persona.domain.model.Person;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class PersonUseCase {

    private final PersonRepositoryInt personRepositoryInt;

    public Person createPerson(Person person){
        return personRepositoryInt.savePerson(person);
    }

    public Person getPersonByNumDoc(String clientNumDoc){
        return Person.builder()
                .clientName("Sebastian")
                .clientLastName("Medina")
                .clientYear("21")
                .clientCity("Cali")
                .clientTypeDoc("cc")
                .clientNumDoc("100221")
                .build();
    }

    public ArrayList<Person> getPersons(){
        return personRepositoryInt.findAll();
    }

    public void deletePerson(String clientNumDoc){
    }

}
