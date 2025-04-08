package br.embarquedigital.universidadesapi.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class PersonDTO {

   private String nome;

    private String cpf;

    private Long idade;
}
