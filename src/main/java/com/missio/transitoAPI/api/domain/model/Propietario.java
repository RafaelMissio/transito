package com.missio.transitoAPI.api.domain.model;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Propietario {

    private Long id;
    private String nome;
    private String telefone;
    private String email;


}
