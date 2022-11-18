package com.smo.persona.application.services;

import com.smo.persona.application.gateways.DeletePersonInt;
import com.smo.persona.domain.exception.BussinessException;
import com.smo.persona.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor

public class ServiceDeletePerson implements DeletePersonInt {

    private final PersonUseCase personUseCase;

    @Override
    public void deletePerson(String clientNumDoc) throws BussinessException {
        validateRequest(clientNumDoc);
       personUseCase.deletePerson(clientNumDoc);
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
