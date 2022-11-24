package com.smo.person.application.services;

import com.smo.person.application.gateways.DeletePersonInt;
import com.smo.person.domain.exception.BussinessException;
import com.smo.person.domain.model.Person;
import com.smo.person.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor

public class ServiceDeletePerson implements DeletePersonInt {

    private final PersonUseCase personUseCase;

    @Override
    public void deletePerson(String clientNumDoc) throws BussinessException {
        validateRequest(clientNumDoc);
        Person person = personUseCase.getPersonByNumDoc(clientNumDoc);
        personUseCase.deletePerson(person.getPersonId());
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
