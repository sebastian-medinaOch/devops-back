package com.smo.person.infrastructure.persistencia.repository;

import com.smo.person.domain.gateways.PersonRepositoryInt;
import com.smo.person.domain.model.Person;
import com.smo.person.infrastructure.persistencia.dao.gateways.PersonDaoInt;
import com.smo.person.infrastructure.persistencia.entity.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@RequiredArgsConstructor
public class PersonRepository implements PersonRepositoryInt {

    private final PersonDaoInt personDaoInt;

    @Override
    public ArrayList<Person> findAll() {
        ArrayList<Person> personArrayList = new ArrayList<>();
        for (PersonEntity personEntity : personDaoInt.findAll()) {
            Person person =
                    Person.builder().personId(personEntity.getPersonId())
                            .clientName(personEntity.getClientName())
                            .clientLastName(personEntity.getClientLastName())
                            .clientYear(personEntity.getClientYear())
                            .clientCity(personEntity.getClientCity())
                            .clientTypeDoc(personEntity.getClientTypeDoc())
                            .clientNumDoc(personEntity.getClientNumDoc())
                            .build();
            personArrayList.add(person);
        }
        return personArrayList;
    }

    @Override
    public Person savePerson(Person person) {

        PersonEntity personBuild = new PersonEntity();
        personBuild.setClientName(person.getClientName());
        personBuild.setClientLastName(person.getClientLastName());
        personBuild.setClientYear(person.getClientYear());
        personBuild.setClientCity(person.getClientCity());
        personBuild.setClientTypeDoc(person.getClientTypeDoc());
        personBuild.setClientNumDoc(person.getClientNumDoc());

        personDaoInt.save(personBuild);
        return person;
    }

    @Override
    public Person findByClientNumDoc(String clientNumDoc) {
        PersonEntity personEntity = personDaoInt.findByClientNumDoc(clientNumDoc);
        return Person.builder().personId(personEntity.getPersonId())
                .clientName(personEntity.getClientName())
                .clientLastName(personEntity.getClientLastName())
                .clientYear(personEntity.getClientYear())
                .clientCity(personEntity.getClientCity())
                .clientTypeDoc(personEntity.getClientTypeDoc())
                .clientNumDoc(personEntity.getClientNumDoc())
                .build();
    }
}
