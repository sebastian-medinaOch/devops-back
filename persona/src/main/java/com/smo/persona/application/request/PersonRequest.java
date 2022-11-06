package com.smo.persona.application.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PersonRequest {

    @NotBlank(message = "El nombre del cliente no puede estar vacio")
    private String clientName;
    @NotBlank(message = "El apellido del cliente no puede estar vacio")
    private String clientLastName;
    @NotBlank(message = "Los años del cliente no puede estar vacio")
    private String clientYear;
    @NotBlank(message = "La ciudad del cliente no puede estar vacia")
    private String clientCity;
    @NotBlank(message = "El tipo de documento del cliente no puede estar vacio")
    private String clientTypeDoc;
    @NotBlank(message = "El numero de documento del cliente no puede estar vacio")
    private String clientNumDoc;

}
