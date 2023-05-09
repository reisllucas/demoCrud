package br.com.demo.crud.crudbackend.service;

import br.com.demo.crud.crudbackend.domain.dto.person.NewPersonDTO;
import br.com.demo.crud.crudbackend.domain.dto.person.PersonDTO;
import br.com.demo.crud.crudbackend.domain.exceptions.BusinessException;
import br.com.demo.crud.crudbackend.domain.model.Person;
import br.com.demo.crud.crudbackend.mapper.PersonMapper;
import br.com.demo.crud.crudbackend.repository.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The class PersonService directs the flow of person entity data.
 * @see br.com.demo.crud.crudbackend.domain.model.Person
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    /**
     * Handle a List of persons
     * @param search search parameter
     * @see br.com.demo.crud.crudbackend.domain.dto.person.PersonDTO
     * @throws BusinessException if the person does not exist
     * @return a List of PersonDTO
     */
    public List<PersonDTO> findAll(String search) {

        return personRepository.findAll(search)
                .stream().map(person ->  personMapper.converToDto(person))
                .toList();

    }

    /**
     * Handle a person by his id
     * @param id parameter
     * @see br.com.demo.crud.crudbackend.domain.dto.person.PersonDTO
     * @return a PersonDTO by id
     */
    public PersonDTO findById(Long id) {

        Optional<Person> person = personRepository.findById(id);

        if (person.isPresent()) {
            return personMapper.converToDto(person.get());
        }

        throw new BusinessException("Person not found");

    }

    /**
     * Handle new inputs of person entity data
     * @param newPersonDTO input data
     * @see br.com.demo.crud.crudbackend.domain.dto.person.NewPersonDTO
     * @see br.com.demo.crud.crudbackend.domain.model.Person
     * @return new identifier for the entity
     */
    public PersonDTO insert(NewPersonDTO newPersonDTO) {

        return personMapper.converToDto(
                personRepository.save(personMapper.convertNewToModel(newPersonDTO))
        );

    }

    /**
     * Handle the replacement of resources of person entity data
     * @param id identifies the data that will be replaced
     * @param personDTO input data
     * @see br.com.demo.crud.crudbackend.domain.model.Person
     * @throws BusinessException if the person does not exist
     * @return new identifier for the entity
     */
    public PersonDTO update(Long id, PersonDTO personDTO) {

        Optional<Person> person = personRepository.findById(id);

        if (person.isPresent()) {
            return personMapper.converToDto(
                    personRepository.save(personMapper.convertToModel(person.get(), personDTO))
            );
        }

        throw new BusinessException("Person not found");

    }

    /**
     * Delete data of person entity data
     * @param id identifies the data that will be deleted
     */
    public void delete(Long id) {

        personRepository.deleteById(id);

    }



}
