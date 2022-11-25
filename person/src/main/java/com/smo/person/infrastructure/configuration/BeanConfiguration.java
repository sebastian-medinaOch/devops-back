package com.smo.person.infrastructure.configuration;

import com.smo.person.application.services.ServiceCreatePerson;
import com.smo.person.application.services.ServiceDeletePerson;
import com.smo.person.application.services.ServicesGetPersonByNumDoc;
import com.smo.person.application.services.ServicesGetPersons;
import com.smo.person.domain.gateways.PersonRepositoryInt;
import com.smo.person.domain.usecase.PersonUseCase;
import com.smo.person.domain.util.AnswerUtil;
import com.smo.person.infrastructure.persistencia.util.PersonRepositoryBuild;
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

    @Bean
    public PersonRepositoryBuild personRepositoryBuild(){
        return new PersonRepositoryBuild();
    }


}
