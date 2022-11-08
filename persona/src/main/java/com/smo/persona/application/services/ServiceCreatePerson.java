package com.smo.persona.application.services;

import com.smo.persona.application.gateways.CreatePersonInt;
import com.smo.persona.application.request.PersonRequest;
import com.smo.persona.domain.model.Person;
import com.smo.persona.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServiceCreatePerson implements CreatePersonInt {

    private final PersonUseCase personUseCase;

    @Override
    public Person createPerson(PersonRequest PersonRequest) {
        return personUseCase.createPerson();
    }
}
