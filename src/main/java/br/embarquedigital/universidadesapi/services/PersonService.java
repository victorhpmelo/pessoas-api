package br.embarquedigital.universidadesapi.services;

import br.embarquedigital.universidadesapi.DTOs.PersonDTO;
import br.embarquedigital.universidadesapi.entities.Person;
import br.embarquedigital.universidadesapi.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;


    private Person toPerson(PersonDTO personDTO) {
        Person person = new Person();

        person.setNome(personDTO.getNome());
        person.setCpf(personDTO.getCpf());
        person.setIdade(personDTO.getIdade());

        return person;
    }

    public List<Person> list() {
        return repository.findAll();
    }

    public Person findOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Person create(PersonDTO personDTO) {
        var person = toPerson(personDTO);
        return repository.save(person);
    }

    public Person modify(Long id, PersonDTO personDTO) {

        Optional<Person> existsPerson = repository.findById(id);

        if (existsPerson.isPresent()) {
            existsPerson.get().setNome(personDTO.getNome());
            existsPerson.get().setCpf(personDTO.getCpf());
            existsPerson.get().setIdade(personDTO.getIdade());
            return repository.save(existsPerson.get());
        }
        throw  new RuntimeException("Person not found");
    }

    public void remove (Long id) {
        repository.deleteById(id);
    }

}
