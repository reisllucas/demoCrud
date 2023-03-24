package br.com.demo.crud.crudbackend.mapper;

import br.com.demo.crud.crudbackend.domain.dto.person.NewPersonDTO;
import br.com.demo.crud.crudbackend.domain.dto.person.PersonDTO;
import br.com.demo.crud.crudbackend.domain.exceptions.BusinessException;
import br.com.demo.crud.crudbackend.domain.model.Person;
import org.springframework.stereotype.Component;

/**
 * The class PersonMapper directs the flow of person entity data.
 * @see br.com.demo.crud.crudbackend.domain.model.Person
 */
@Component
public class PersonMapper {


    /**
     * Convert a PersonDTO to Person entity
     * @param person the entity
     * @param personDTO the replacement data
     * @see br.com.demo.crud.crudbackend.domain.exceptions.BusinessException
     * @see br.com.demo.crud.crudbackend.domain.model.Person
     * @see br.com.demo.crud.crudbackend.domain.dto.person.PersonDTO
     * @throws BusinessException if the person does not exist
     * @return a Person entity data
     */
    public Person convertToModel(Person person, PersonDTO personDTO) {

        if (person == null) throw new BusinessException("Person not found");

        person.setId(personDTO.getId());
        person.setName(personDTO.getName());
        person.setPhone(personDTO.getPhone());
        person.setBirthDay(personDTO.getBirthDay());
        person.setZipCode(personDTO.getZipCode());
        person.setAddress(personDTO.getAddress());
        person.setEmail(personDTO.getEmail());
        person.setCountry(personDTO.getCountry());
        person.setCity(personDTO.getCity());
        person.setState(personDTO.getState());

        return person;

    }

    /**
     * Convert a NewPersonDTO to Person entity
     * @param personDTO input data
     * @see br.com.demo.crud.crudbackend.domain.dto.person.NewPersonDTO
     * @see br.com.demo.crud.crudbackend.domain.model.Person
     * @return a Person entity data
     */
    public Person convertNewToModel( NewPersonDTO personDTO) {

        Person person = new Person();

        person.setName(personDTO.getName());
        person.setPhone(personDTO.getPhone());
        person.setBirthDay(personDTO.getBirthDay());
        person.setZipCode(personDTO.getZipCode());
        person.setAddress(personDTO.getAddress());
        person.setEmail(personDTO.getEmail());
        person.setCountry(personDTO.getCountry());
        person.setCity(personDTO.getCity());
        person.setState(personDTO.getState());

        return person;

    }

    /**
     * Convert a Person to PersonDTO entity
     * @param person input data
     * @see br.com.demo.crud.crudbackend.domain.model.Person
     * @see br.com.demo.crud.crudbackend.domain.dto.person.PersonDTO
     * @return PersonDTO data
     */
    public PersonDTO converToDto(Person person) {

        if (person == null) return null;

        PersonDTO dto = new PersonDTO();

        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setPhone(person.getPhone());
        dto.setBirthDay(person.getBirthDay());
        dto.setZipCode(person.getZipCode());
        dto.setAddress(person.getAddress());
        dto.setEmail(person.getEmail());
        dto.setCountry(person.getCountry());
        dto.setCity(person.getCity());
        dto.setState(person.getState());

        return dto;

    }
}
