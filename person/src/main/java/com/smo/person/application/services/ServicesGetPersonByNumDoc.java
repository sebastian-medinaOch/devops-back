package com.smo.person.application.services;

import com.smo.person.application.gateways.GetPersonByNumDocInt;
import com.smo.person.application.util.PersonRepositoryBuild;
import com.smo.person.domain.exception.BussinessException;
import com.smo.person.domain.model.Person;
import com.smo.person.domain.usecase.PersonUseCase;
import com.smo.person.infrastructure.persistencia.entity.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class ServicesGetPersonByNumDoc implements GetPersonByNumDocInt {

    private final PersonUseCase personUseCase;
    private final PersonRepositoryBuild personRepositoryBuild;

    @Override
    public Person getPersonByNumDoc(String clientNumDoc) throws BussinessException {
        validateRequest(clientNumDoc);

        PersonEntity personEntity = personUseCase.getPersonByNumDoc(clientNumDoc);

        return  personRepositoryBuild.buildPersonComplete(personEntity);
    }

    private void validateRequest(String clientNumDoc) throws BussinessException {
        if (clientNumDoc.equals("") || clientNumDoc.isBlank()){
            throw new BussinessException(HttpStatus.NOT_ACCEPTABLE, "El numero de documento del cliente no puede ser vacio");
        }
        if (!clientNumDoc.matches("[0-9]+")){
            throw new BussinessException(HttpStatus.NOT_ACCEPTABLE, "El numero de documento del cliente solo puede contener " +
                    "numeros");
        }
    }


}
