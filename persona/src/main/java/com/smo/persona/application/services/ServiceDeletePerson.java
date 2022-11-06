package com.smo.persona.application.services;

import com.smo.persona.application.gateways.DeletePersonInt;
import com.smo.persona.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor

public class ServiceDeletePerson implements DeletePersonInt {

    private final PersonUseCase personUseCase;

    @Override
    public HttpStatus deletePerson(String clientNumDoc){
        return personUseCase.deletePerson(clientNumDoc);
    }
}
