package com.smo.person.application.services;

import com.smo.person.application.gateways.GetPersonsInt;
import com.smo.person.domain.model.Person;
import com.smo.person.domain.usecase.PersonUseCase;
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
