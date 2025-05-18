package br.embarquedigital.universidadesapi.services;

import br.embarquedigital.universidadesapi.DTOs.PersonDTO;
import br.embarquedigital.universidadesapi.entities.Person;
import br.embarquedigital.universidadesapi.exceptions.NotFoundException;
import br.embarquedigital.universidadesapi.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
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
        log.info("Buscando lista de pessoas");
        return repository.findAll();
    }

    public Person findOne(Long id) {
        log.info("Buscando pessoa com o id: {}", id);
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Pessoa com o id: " + id));
    }

    public Person create(PersonDTO personDTO) {
        var person = toPerson(personDTO);
        log.info("Criando pessoa com o nome: {}", person.getNome());
        return repository.save(person);
    }

    public Person modify(Long id, PersonDTO personDTO) {

        Optional<Person> existsPerson = repository.findById(id);

        if (existsPerson.isPresent()) {
            log.info("Alterando pessoa com o id: {}", id);
            existsPerson.get().setNome(personDTO.getNome());
            existsPerson.get().setCpf(personDTO.getCpf());
            existsPerson.get().setIdade(personDTO.getIdade());
            return repository.save(existsPerson.get());
        }
        throw  new NotFoundException("A Pessoa " + personDTO.getNome());
    }

    public void remove(Long id) {
        log.info("Removendo pessoa com o id: {}", id);
        repository.deleteById(id);
    }

}
