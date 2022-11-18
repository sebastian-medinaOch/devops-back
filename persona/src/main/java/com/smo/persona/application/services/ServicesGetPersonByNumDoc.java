package com.smo.persona.application.services;

import com.smo.persona.application.gateways.GetPersonByNumDocInt;
import com.smo.persona.domain.model.Person;
import com.smo.persona.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServicesGetPersonByNumDoc implements GetPersonByNumDocInt {

    private final PersonUseCase personUseCase;

    @Override
    public Person getPersonByNumDoc(String clientNumDoc){
        return personUseCase.getPersonByNumDoc(clientNumDoc);
    }


}
