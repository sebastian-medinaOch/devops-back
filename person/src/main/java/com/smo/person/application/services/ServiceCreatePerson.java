package com.smo.person.application.services;

import com.smo.person.application.gateways.CreatePersonInt;
import com.smo.person.application.request.PersonRequest;
import com.smo.person.domain.exception.BussinessException;
import com.smo.person.domain.model.Person;
import com.smo.person.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class ServiceCreatePerson implements CreatePersonInt {

    private final PersonUseCase personUseCase;

    @Override
    public Person createPerson(PersonRequest personRequest) throws BussinessException {
        validateRequest(personRequest);
        validatePerson(personRequest);

        Person person = Person.builder()
                .clientName(personRequest.getClientName())
                .clientLastName(personRequest.getClientLastName())
                .clientYear(personRequest.getClientYear())
                .clientCity(personRequest.getClientCity())
                .clientTypeDoc(personRequest.getClientTypeDoc())
                .clientNumDoc(personRequest.getClientNumDoc())
                .build();
        return personUseCase.createPerson(person);
    }

    private void validatePerson(PersonRequest person) throws BussinessException {
        Person personRepository = personUseCase.getPersonByNumDoc(person.getClientNumDoc());
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
