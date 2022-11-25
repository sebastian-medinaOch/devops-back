package com.smo.person.infrastructure.persistencia.util;

import com.smo.person.domain.exception.BussinessException;
import com.smo.person.domain.model.Person;
import com.smo.person.infrastructure.persistencia.entity.PersonEntity;
import org.springframework.http.HttpStatus;

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

}
