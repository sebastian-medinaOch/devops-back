package com.smo.persona.application.gateways;

import com.smo.persona.domain.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface GetPersonsInt {

    ArrayList<Person> getPersons();

}
