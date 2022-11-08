package com.smo.persona.domain.usecase;

import com.smo.persona.domain.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

@RequiredArgsConstructor
public class PersonUseCase {

    public Person createPerson(){
        return Person.builder()
                .clientName("Sebastian")
                .clientLastName("Medina")
                .clientYear("21")
                .clientCity("Cali")
                .clientTypeDoc("cc")
                .clientNumDoc("100221")
                .build();
    }

    public Person getPerson(String clientNumDoc){
        return Person.builder()
                .clientName("Sebastian")
                .clientLastName("Medina")
                .clientYear("21")
                .clientCity("Cali")
                .clientTypeDoc("cc")
                .clientNumDoc("100221")
                .build();
    }

    public ArrayList<Person> getPersons(){
        ArrayList<Person> persons = new ArrayList<>();
        Person person1 = Person.builder()
                .clientName("Sebastian")
                .clientLastName("Medina")
                .clientYear("21")
                .clientCity("Cali")
                .clientTypeDoc("cc")
                .clientNumDoc("100221")
                .build();
        Person person2 = Person.builder()
                .clientName("Sebastian2")
                .clientLastName("Medina2")
                .clientYear("23")
                .clientCity("Calic")
                .clientTypeDoc("cc")
                .clientNumDoc("100221")
                .build();
        persons.add(person1);
        persons.add(person2);
        return  persons;
    }

    public HttpStatus deletePerson(String clientNumDoc){
         return  HttpStatus.OK;
    }

}
