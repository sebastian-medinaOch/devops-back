package com.smo.person.domain.gateways;

import com.smo.person.infrastructure.persistencia.entity.PersonEntity;

import java.util.ArrayList;

public interface PersonRepositoryInt {

    ArrayList<PersonEntity> findAll();
    PersonEntity savePerson(PersonEntity personEntity);
    PersonEntity findByClientNumDoc(String clientNumDoc);
    Long deleteByPersonId(Long personId);
}
