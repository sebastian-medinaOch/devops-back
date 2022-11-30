package com.smo.person.application.services;

import com.smo.person.application.gateways.CreatePersonInt;
import com.smo.person.application.request.PersonRequest;
import com.smo.person.application.util.PersonRepositoryBuild;
import com.smo.person.domain.exception.BussinessException;
import com.smo.person.domain.model.Person;
import com.smo.person.domain.usecase.PersonUseCase;
import com.smo.person.infrastructure.persistencia.entity.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class ServiceCreatePerson implements CreatePersonInt {

    private final PersonUseCase personUseCase;
    private final PersonRepositoryBuild personRepositoryBuild;

    @Override
    public Person createPerson(PersonRequest personRequest) throws BussinessException {
        validateRequest(personRequest);
        validatePerson(personRequest);

        PersonEntity personEntity = personRepositoryBuild.buildPersonEntity(personRequest);
        PersonEntity personEntityCreate = personUseCase.createPerson(personEntity);

        return personRepositoryBuild.buildPersonComplete(personEntityCreate);
    }

    private void validatePerson(PersonRequest person) throws BussinessException {
        PersonEntity personRepository = personUseCase.getPersonByNumDoc(person.getClientNumDoc());
        if (personRepository != null) {
            throw new BussinessException(HttpStatus.METHOD_NOT_ALLOWED, "La persona que quieres registrar, ya esta " +
                    "registrada en el sistema");
        }
    }

    private void validateRequest(PersonRequest personRequest) throws BussinessException {
        if (Integer.parseInt(personRequest.getClientYear()) < 5) {
            throw new BussinessException(HttpStatus.BAD_REQUEST, "No se pueden registrar personas menores a 5 años");
        }
    }
}
