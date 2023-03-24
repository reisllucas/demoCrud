package br.com.demo.crud.crudbackend.repository.person;

import br.com.demo.crud.crudbackend.domain.model.Person;

import java.util.List;

public interface PersonRepositoryCustom {
    List<Person> findAll(String search);
}
