package com.smo.person.infrastructure.rest.controller;

import com.smo.person.application.gateways.GetPersonsInt;
import com.smo.person.domain.answer.AnswerData;
import com.smo.person.domain.answer.DataResponse;
import com.smo.person.domain.exception.BussinessException;
import com.smo.person.domain.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class EndpointGetPersons {

    private final GetPersonsInt getPersonsInt;

    @GetMapping(value = "/getPersons")
    public ResponseEntity<AnswerData> getPersons() throws BussinessException {
        ArrayList<Person> persons = getPersonsInt.getPersons();
        DataResponse dataResponse = DataResponse.builder().message("Sastifactorio").data(Optional.of(persons)).build();
        AnswerData answerData = new AnswerData(HttpStatus.OK, dataResponse);
        return new ResponseEntity<>(answerData, answerData.getStatus());
    }

}
