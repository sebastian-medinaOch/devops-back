package com.smo.persona.infrastructure.configuration;

import com.smo.persona.application.services.ServiceCreatePerson;
import com.smo.persona.application.services.ServiceDeletePerson;
import com.smo.persona.application.services.ServicesGetPersonByNumDoc;
import com.smo.persona.application.services.ServicesGetPersons;
import com.smo.persona.domain.gateways.PersonRepositoryInt;
import com.smo.persona.domain.usecase.PersonUseCase;
import com.smo.persona.domain.util.AnswerUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {

    @Bean
    public ServiceCreatePerson serviceCreatePerson(PersonUseCase personUseCase){
        return new ServiceCreatePerson(personUseCase);
    }

    @Bean
    public ServicesGetPersonByNumDoc servicesGetPerson(PersonUseCase personUseCase){
        return new ServicesGetPersonByNumDoc(personUseCase);
    }

    @Bean
    public ServicesGetPersons servicesGetPersons(PersonUseCase personUseCase){
        return new ServicesGetPersons(personUseCase);
    }

    @Bean
    public ServiceDeletePerson serviceDeletePerson(PersonUseCase personUseCase){
        return new ServiceDeletePerson(personUseCase);
    }

    @Bean
    public PersonUseCase personUseCase(PersonRepositoryInt personRepositoryInt){
        return new PersonUseCase(personRepositoryInt);
    }

    @Bean
    public AnswerUtil answerUtil(){
        return new AnswerUtil();
    }



}
