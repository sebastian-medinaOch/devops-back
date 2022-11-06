package com.smo.persona.application.services;

import com.smo.persona.application.gateways.GetPersonsInt;
import com.smo.persona.domain.model.Person;
import com.smo.persona.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class ServicesGetPersons implements GetPersonsInt {

    private final PersonUseCase personUseCase;

    @Override
    public ArrayList<Person> getPersons(){
        return personUseCase.getPersons();
    }

}
