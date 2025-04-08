package br.embarquedigital.universidadesapi.controllers;

import br.embarquedigital.universidadesapi.DTOs.PersonDTO;
import br.embarquedigital.universidadesapi.entities.Person;
import br.embarquedigital.universidadesapi.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository repository;

    private PersonDTO toDTO(Person person) {
        PersonDTO dto = new PersonDTO();

        dto.setNome(person.getNome());
        dto.setCpf(person.getCpf());
        dto.setIdade(person.getIdade());

        return dto;
    }

    private Person toPerson(PersonDTO personDTO) {
        Person person = new Person();

            person.setNome(personDTO.getNome());
            person.setCpf(personDTO.getCpf());
            person.setIdade(personDTO.getIdade());

            return person;
    }
    @GetMapping("{id}")
    public Person findById(@PathVariable Long id) {
        var person = repository.findById(id).orElse(null);
        return person;
    }

    @PostMapping
    public Person save(@RequestBody PersonDTO personDto) {
       var person = toPerson(personDto);
       return repository.save(person);
    }
}
