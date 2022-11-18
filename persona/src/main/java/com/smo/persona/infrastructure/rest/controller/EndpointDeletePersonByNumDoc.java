package com.smo.persona.infrastructure.rest.controller;

import com.smo.persona.application.services.ServiceDeletePerson;
import com.smo.persona.domain.answer.AnswerData;
import com.smo.persona.domain.answer.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping(value = "/person")
@RequiredArgsConstructor
public class EndpointDeletePersonByNumDoc {

    private final ServiceDeletePerson personService;

    @DeleteMapping("/deletePerson")
    public ResponseEntity<AnswerData> deletePerson(@NotNull @RequestParam("clientNumDoc") String clientNumDoc){
        personService.deletePerson(clientNumDoc);
        DataResponse dataResponse = DataResponse.builder().message("Sastifactorio").data(Optional.of("El cliente que " +
                "se eliminó fue con el numero de documento: " +  clientNumDoc)).build();
        AnswerData answerData = new AnswerData(HttpStatus.OK, dataResponse);
        return new ResponseEntity<>(answerData, answerData.getStatus());
    }

}
