package com.smo.persona.application.gateways;

import com.smo.persona.application.request.PersonRequest;
import com.smo.persona.domain.exception.BussinessException;
import org.springframework.stereotype.Service;

@Service
public interface CreatePersonInt {

    void createPerson(PersonRequest personRequest) throws BussinessException;

}
