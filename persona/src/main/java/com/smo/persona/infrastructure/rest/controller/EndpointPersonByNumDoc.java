package com.smo.persona.infrastructure.rest.controller;

import com.smo.persona.application.gateways.GetPersonInt;
import com.smo.persona.domain.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class EndpointPersonByNumDoc {

    private final GetPersonInt getPersonInt;

    @GetMapping(value = "/getPerson")
    public Person getPerson(@NotNull @RequestParam("clientNumDoc") String clientNumDoc){
        return getPersonInt.getPerson(clientNumDoc);
    }

}
