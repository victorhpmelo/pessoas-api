package br.embarquedigital.universidadesapi.repositories;

import br.embarquedigital.universidadesapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByNomeContainsAndIdadeGreaterThan(String nome, Long idade);

}
