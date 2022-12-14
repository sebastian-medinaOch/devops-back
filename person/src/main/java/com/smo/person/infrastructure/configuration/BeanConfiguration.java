package com.smo.person.infrastructure.configuration;

import com.smo.person.application.services.ServiceCreatePerson;
import com.smo.person.application.services.ServiceDeletePerson;
import com.smo.person.application.services.ServicesGetPersonByNumDoc;
import com.smo.person.application.services.ServicesGetPersons;
import com.smo.person.application.util.PersonRepositoryBuild;
import com.smo.person.domain.gateways.PersonRepositoryInt;
import com.smo.person.domain.usecase.PersonUseCase;
import com.smo.person.domain.util.AnswerUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {

    @Bean
    public ServiceCreatePerson serviceCreatePerson(PersonUseCase personUseCase, PersonRepositoryBuild personRepositoryBuild){
        return new ServiceCreatePerson(personUseCase, personRepositoryBuild);
    }

    @Bean
    public ServicesGetPersonByNumDoc servicesGetPerson(PersonUseCase personUseCase,
                                                       PersonRepositoryBuild personRepositoryBuild){
        return new ServicesGetPersonByNumDoc(personUseCase, personRepositoryBuild);
    }

    @Bean
    public ServicesGetPersons servicesGetPersons(PersonUseCase personUseCase, PersonRepositoryBuild personRepositoryBuild){
        return new ServicesGetPersons(personUseCase, personRepositoryBuild);
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
