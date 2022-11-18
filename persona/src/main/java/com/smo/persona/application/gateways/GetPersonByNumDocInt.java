package com.smo.persona.application.gateways;

import com.smo.persona.domain.model.Person;
import org.springframework.stereotype.Service;


@Service
public interface GetPersonByNumDocInt {

    Person getPersonByNumDoc(String clientNumDoc);

}
