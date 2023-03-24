package br.com.demo.crud.crudbackend.controller;

import br.com.demo.crud.crudbackend.domain.dto.person.NewPersonDTO;
import br.com.demo.crud.crudbackend.domain.dto.person.PersonDTO;
import br.com.demo.crud.crudbackend.domain.exceptions.BusinessException;
import br.com.demo.crud.crudbackend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * The class CountryController is a request handler that directs the flow of person entity data.
 * @see org.springframework.web.bind.annotation.RestController
 */
@RestController
@RequestMapping("rs/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    /**
     * HTTP GET request to handle a List of persons
     * @param search search parameter
     * @see br.com.demo.crud.crudbackend.domain.dto.person.PersonDTO
     * @return a List of PersonDTO
     */
    @GetMapping
    List<PersonDTO> findAll(@RequestParam(required = false) String search) {

        return personService.findAll(search);
    }

    /**
     * HTTP POST request to handle new inputs of person entity data
     * @param personDTO input data
     * @see br.com.demo.crud.crudbackend.domain.dto.person.NewPersonDTO
     * @return new identifier for the entity
     */
    @PostMapping
    PersonDTO insert(@RequestBody NewPersonDTO personDTO) {

        return personService.insert(personDTO);
    }

    /**
     * HTTP PUT request to handle the replacement of resources at the known url of person entity data
     * @param id identifies the data that will be replaced
     * @param personDTO input data
     * @see br.com.demo.crud.crudbackend.domain.dto.person.PersonDTO
     * @see br.com.demo.crud.crudbackend.domain.exceptions.BusinessException
     * @throws BusinessException if the person does not exist
     * @return new identifier for the entity
     */
    @PutMapping("{id}")
    PersonDTO update(@PathVariable("id") Long id, @RequestBody PersonDTO personDTO) {

        return personService.update(id, personDTO);
    }

    /**
     * HTTP DELETE request to delete data of person entity data
     * @param id identifies the data that will be deleted
     */
    @DeleteMapping("{id}")
    void delete(@PathVariable("id") Long id) {

        personService.delete(id);
    }


}
