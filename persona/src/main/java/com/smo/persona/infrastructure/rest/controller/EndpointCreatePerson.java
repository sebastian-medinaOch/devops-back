package com.smo.persona.infrastructure.rest.controller;

import com.smo.persona.application.gateways.CreatePersonInt;
import com.smo.persona.application.request.PersonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class EndpointCreatePerson {

    private final CreatePersonInt createPersonInt;

    @PostMapping(value = "/createPerson")
    public HttpStatus createPerson(@Valid @RequestBody PersonRequest personRequest){
        return createPersonInt.createPerson(personRequest);
    }

}
