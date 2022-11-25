package com.smo.person.application.util;

import com.smo.person.application.request.PersonRequest;
import com.smo.person.domain.exception.BussinessException;
import com.smo.person.domain.model.Person;
import com.smo.person.infrastructure.persistencia.entity.PersonEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

public class PersonRepositoryBuild {

    public Person buildPersonComplete(PersonEntity personEntity) throws BussinessException {
        validatePersonEntity(personEntity);
        return buildPerson(personEntity);
    }

    private Person buildPerson(PersonEntity personEntity) {
        return Person.builder().personId(personEntity.getPersonId())
                .clientName(personEntity.getClientName())
                .clientLastName(personEntity.getClientLastName())
                .clientYear(personEntity.getClientYear())
                .clientCity(personEntity.getClientCity())
                .clientTypeDoc(personEntity.getClientTypeDoc())
                .clientNumDoc(personEntity.getClientNumDoc())
                .build();
    }

    private void validatePersonEntity(PersonEntity personEntity) throws BussinessException {
        if (personEntity == null){
            throw new BussinessException(HttpStatus.BAD_REQUEST, "La persona que desea consultar no existe en el sistema");
        }
    }

    public ArrayList<Person> buildAllPersons(ArrayList<PersonEntity> personEntities){
        ArrayList<Person> personArrayList = new ArrayList<>();
        for (PersonEntity personEntity : personEntities) {
            Person person = buildPerson(personEntity);
            personArrayList.add(person);
        }
        return personArrayList;
    }

    public PersonEntity buildPersonEntity(PersonRequest personRequest){
        PersonEntity personBuild = new PersonEntity();
        personBuild.setClientName(personRequest.getClientName());
        personBuild.setClientLastName(personRequest.getClientLastName());
        personBuild.setClientYear(personRequest.getClientYear());
        personBuild.setClientCity(personRequest.getClientCity());
        personBuild.setClientTypeDoc(personRequest.getClientTypeDoc());
        personBuild.setClientNumDoc(personRequest.getClientNumDoc());

        return personBuild;
    }

}
