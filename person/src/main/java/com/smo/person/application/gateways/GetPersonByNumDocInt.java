package com.smo.person.application.gateways;

import com.smo.person.domain.exception.BussinessException;
import com.smo.person.domain.model.Person;
import org.springframework.stereotype.Service;


@Service
public interface GetPersonByNumDocInt {

    Person getPersonByNumDoc(String clientNumDoc) throws BussinessException;

}
