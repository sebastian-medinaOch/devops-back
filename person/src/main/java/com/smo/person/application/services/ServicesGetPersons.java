package com.smo.person.application.services;

import com.smo.person.application.gateways.GetPersonsInt;
import com.smo.person.application.util.PersonRepositoryBuild;
import com.smo.person.domain.exception.BussinessException;
import com.smo.person.domain.model.Person;
import com.smo.person.domain.usecase.PersonUseCase;
import com.smo.person.infrastructure.persistencia.entity.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

@RequiredArgsConstructor
public class ServicesGetPersons implements GetPersonsInt {

    private final PersonUseCase personUseCase;
    private final PersonRepositoryBuild personRepositoryBuild;

    @Override
    public ArrayList<Person> getPersons() throws BussinessException {
        ArrayList<PersonEntity> personEntity = personUseCase.getPersons();
        validatePersons(personEntity);
        return personRepositoryBuild.buildAllPersons(personEntity);
    }

    private void validatePersons(ArrayList<PersonEntity> personEntity) throws BussinessException {
        if (personEntity.size() == 0){
            throw new BussinessException(HttpStatus.NOT_FOUND, "No se encontraron registros de las personas en el " +
                    "sistema");
        }
    }

}
