package com.smo.person.infrastructure.rest.controller;

import com.smo.person.application.gateways.DeletePersonInt;
import com.smo.person.domain.answer.AnswerData;
import com.smo.person.domain.answer.DataResponse;
import com.smo.person.domain.exception.BussinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/person")
@RequiredArgsConstructor
public class EndpointDeletePersonByNumDoc {

    private final DeletePersonInt deletePersonInt;

    @DeleteMapping("/deletePerson")
    public ResponseEntity<AnswerData> deletePerson(@RequestParam("clientNumDoc") String clientNumDoc) throws BussinessException {
        deletePersonInt.deletePerson(clientNumDoc);
        DataResponse dataResponse = DataResponse.builder().message("Sastifactorio").data(Optional.of("El cliente que " +
                "se eliminó fue con el numero de documento: " +  clientNumDoc)).build();
        AnswerData answerData = new AnswerData(HttpStatus.OK, dataResponse);
        return new ResponseEntity<>(answerData, answerData.getStatus());
    }

}
