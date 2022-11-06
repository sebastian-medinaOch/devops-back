package com.smo.persona.application.gateways;

import com.smo.persona.application.request.PersonRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public interface CreatePersonInt {

    HttpStatus createPerson(PersonRequest personRequest);

}
