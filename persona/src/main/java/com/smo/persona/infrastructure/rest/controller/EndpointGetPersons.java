package com.smo.persona.infrastructure.rest.controller;

import com.smo.persona.application.gateways.GetPersonsInt;
import com.smo.persona.domain.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class EndpointGetPersons {

    private final GetPersonsInt getPersonsInt;

    @GetMapping(value = "/getPersons")
    public ArrayList<Person> getPersons(){
        return getPersonsInt.getPersons();
    }

}
