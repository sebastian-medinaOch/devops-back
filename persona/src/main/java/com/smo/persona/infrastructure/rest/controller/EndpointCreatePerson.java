package com.smo.persona.infrastructure.rest.controller;

import com.smo.persona.application.gateways.CreatePersonInt;
import com.smo.persona.application.request.PersonRequest;
import com.smo.persona.domain.answer.AnswerData;
import com.smo.persona.domain.answer.DataResponse;
import com.smo.persona.domain.exception.BussinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class EndpointCreatePerson {

    private final CreatePersonInt createPersonInt;

    @PostMapping(value = "/createPerson")
    public ResponseEntity<AnswerData> createPerson(@Valid @RequestBody PersonRequest personRequest) throws BussinessException {
        createPersonInt.createPerson(personRequest);
        DataResponse dataResponse =
                DataResponse.builder().message("Sastifactorio").data(Optional.of("Usuario creado sastifactoriamente")).build();
        AnswerData answerData = new AnswerData(HttpStatus.OK, dataResponse );
        return new ResponseEntity<>(answerData, answerData.getStatus());
    }

}
