package com.smo.persona.infrastructure.rest.controller;

import com.smo.persona.application.services.ServiceDeletePerson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/person")
@RequiredArgsConstructor
public class EndpointDeletePersonByNumDoc {

    private final ServiceDeletePerson personService;

    @DeleteMapping("/deletePerson")
    public HttpStatus deletePerson(@NotNull @RequestParam("clientNumDoc") String clientNumDoc){
        return personService.deletePerson(clientNumDoc);
    }

}
