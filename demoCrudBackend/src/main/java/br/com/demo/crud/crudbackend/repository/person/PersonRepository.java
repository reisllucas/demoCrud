package br.com.demo.crud.crudbackend.repository.person;

import br.com.demo.crud.crudbackend.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends PersonRepositoryCustom, JpaRepository<Person, Long> {


}
