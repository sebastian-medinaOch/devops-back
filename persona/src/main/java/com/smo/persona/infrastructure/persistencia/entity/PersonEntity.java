package com.smo.persona.infrastructure.persistencia.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TBL_SMO_PERSON")
@NoArgsConstructor
public class PersonEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;
    @Column(name = "CLIENT_NAME")
    private String clientName;
    @Column(name = "CLIENT_LAST_NAME")
    private String clientLastName;
    @Column(name = "CLIENT_YEAR")
    private String clientYear;
    @Column(name = "CLIENT_CITY")
    private String clientCity;
    @Column(name = "CLIENT_TYPE_DOC")
    private String clientTypeDoc;
    @Column(name = "CLIENT_NUM_DOC")
    private String clientNumDoc;

}
