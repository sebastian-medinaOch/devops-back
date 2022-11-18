package com.smo.persona.infrastructure.rest.controller;

import com.smo.persona.application.gateways.GetPersonByNumDocInt;
import com.smo.persona.domain.answer.AnswerData;
import com.smo.persona.domain.answer.DataResponse;
import com.smo.persona.domain.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class EndpointGetPersonByNumDoc {

    private final GetPersonByNumDocInt getPersonByNumDocInt;

    @GetMapping(value = "/getPerson")
    public ResponseEntity<AnswerData> getPerson(@NotNull @RequestParam("clientNumDoc") String clientNumDoc){
        Person person = getPersonByNumDocInt.getPersonByNumDoc(clientNumDoc);
        DataResponse dataResponse = DataResponse.builder().message("Sastifactorio").data(Optional.of(person)).build();
        AnswerData answerData = new AnswerData(HttpStatus.OK, dataResponse );
        return new ResponseEntity<>(answerData,answerData.getStatus());
    }

}
