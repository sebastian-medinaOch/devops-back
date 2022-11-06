package com.smo.persona.application.services;

import com.smo.persona.application.gateways.GetPersonInt;
import com.smo.persona.domain.model.Person;
import com.smo.persona.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServicesGetPerson implements GetPersonInt {

    private final PersonUseCase personUseCase;

    @Override
    public Person getPerson(String clientNumDoc){
        return personUseCase.getPerson(clientNumDoc);
    }


}
