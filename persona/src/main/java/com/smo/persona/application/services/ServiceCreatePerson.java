package com.smo.persona.application.services;

import com.smo.persona.application.gateways.CreatePersonInt;
import com.smo.persona.application.request.PersonRequest;
import com.smo.persona.domain.exception.BussinessException;
import com.smo.persona.domain.model.Person;
import com.smo.persona.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Objects;

@RequiredArgsConstructor
public class ServiceCreatePerson implements CreatePersonInt {

    private final PersonUseCase personUseCase;

    @Override
    public Person createPerson(PersonRequest personRequest) throws BussinessException {
        //validateRequest(personRequest);
        return personUseCase.createPerson();
    }

    private void validateRequest(PersonRequest personRequest) throws BussinessException{
        if (Objects.equals(personRequest.getClientCity(), "Cali")){
            throw new BussinessException(HttpStatus.BAD_REQUEST, "test BussinessException");
        }
    }
}
