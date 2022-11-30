package com.smo.person.application.services;

import com.smo.person.application.gateways.DeletePersonInt;
import com.smo.person.application.request.PersonRequest;
import com.smo.person.domain.exception.BussinessException;
import com.smo.person.domain.usecase.PersonUseCase;
import com.smo.person.infrastructure.persistencia.entity.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor

public class ServiceDeletePerson implements DeletePersonInt {

    private final PersonUseCase personUseCase;

    @Override
    public void deletePerson(String clientNumDoc) throws BussinessException {
        validateRequest(clientNumDoc);
        PersonEntity personEntity = validatePerson(clientNumDoc);
        personUseCase.deletePerson(personEntity.getPersonId());
    }

    private PersonEntity validatePerson(String clienNumDoc) throws BussinessException {
        PersonEntity personRepository = personUseCase.getPersonByNumDoc(clienNumDoc);
        if (personRepository == null) {
            throw new BussinessException(HttpStatus.NOT_FOUND, "La persona que quieres eliminar, no existe " +
                    "en la base de datos");
        }
        return personRepository;
    }

    private void validateRequest(String clientNumDoc) throws BussinessException {
        if (clientNumDoc.equals("") || clientNumDoc.isBlank()){
            throw new BussinessException(HttpStatus.OK, "El numero de documento del cliente no puede ser vacio");
        }
        if (!clientNumDoc.matches("[0-9]+")){
            throw new BussinessException(HttpStatus.OK, "El numero de documento del cliente solo puede contener " +
                    "numeros");
        }
    }
}
