package com.smo.persona.application.gateways;

import com.smo.persona.application.request.PersonRequest;
import com.smo.persona.domain.model.Person;
import org.springframework.stereotype.Service;

@Service
public interface CreatePersonInt {

    Person createPerson(PersonRequest personRequest);

}
