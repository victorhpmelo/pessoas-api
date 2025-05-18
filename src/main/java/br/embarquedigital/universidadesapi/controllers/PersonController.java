package br.embarquedigital.universidadesapi.controllers;

import br.embarquedigital.universidadesapi.DTOs.PersonDTO;
import br.embarquedigital.universidadesapi.entities.Person;
import br.embarquedigital.universidadesapi.repositories.PersonRepository;
import br.embarquedigital.universidadesapi.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;
    private final PersonRepository repository;
    @GetMapping
    public List<Person> findAll() {
        return service.list();
    }

    @GetMapping("id/{id}")
    public Person findById(@PathVariable Long id) {
        return service.findOne(id);
    }

    @GetMapping("search")
    public Person findByNomeEIdade(@RequestParam String nome, @RequestParam Long idade) {
        return repository.findByNomeContainsAndIdadeGreaterThan(nome, idade);
    }
    @PostMapping
    public Person save(@RequestBody PersonDTO personDto) {
        return service.create(personDto);
    }

    @PutMapping("{id}")
    public Person update(@PathVariable Long id, @RequestBody PersonDTO personDto) {
        return service.modify(id, personDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.remove(id);
    }
}
