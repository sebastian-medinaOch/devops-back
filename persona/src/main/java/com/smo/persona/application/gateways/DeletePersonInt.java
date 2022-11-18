package com.smo.persona.application.gateways;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public interface DeletePersonInt {

    void deletePerson(String clientNumDoc);

}
