package com.smo.person.application.gateways;

import com.smo.person.domain.exception.BussinessException;
import org.springframework.stereotype.Service;

@Service
public interface DeletePersonInt {

    void deletePerson(String clientNumDoc) throws BussinessException;

}
