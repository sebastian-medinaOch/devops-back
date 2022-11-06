package com.smo.persona.application.gateways;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public interface DeletePersonInt {

    HttpStatus deletePerson(String clientNumDoc);

}
