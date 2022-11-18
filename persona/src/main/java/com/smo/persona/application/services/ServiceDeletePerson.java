package com.smo.persona.application.services;

import com.smo.persona.application.gateways.DeletePersonInt;
import com.smo.persona.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class ServiceDeletePerson implements DeletePersonInt {

    private final PersonUseCase personUseCase;

    @Override
    public void deletePerson(String clientNumDoc){
       personUseCase.deletePerson(clientNumDoc);
    }
}
