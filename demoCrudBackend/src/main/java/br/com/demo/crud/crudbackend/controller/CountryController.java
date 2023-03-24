package br.com.demo.crud.crudbackend.controller;

import br.com.demo.crud.crudbackend.domain.dto.CountryDTO;
import br.com.demo.crud.crudbackend.domain.exceptions.BusinessException;
import br.com.demo.crud.crudbackend.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * The class CountryController is a request handler that directs the flow of country entity data.
 * @see org.springframework.web.bind.annotation.RestController
 */
@RestController
@RequestMapping("rs/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    /**
     * HTTP GET request to handle a List of Countries
     * @see br.com.demo.crud.crudbackend.domain.dto.CountryDTO
     * @return a List of CountryDTO
     */
    @GetMapping
    List<CountryDTO> findAll() {

        return countryService.findAll();
    }

    /**
     * HTTP GET request to handle a Country entity
     * @param value country acronym
     * @see br.com.demo.crud.crudbackend.domain.dto.CountryDTO
     * @see br.com.demo.crud.crudbackend.domain.exceptions.BusinessException
     * @throws BusinessException if country acronym does not exist
     * @return country's name
     */
    @GetMapping("{value}")
    CountryDTO findByValue(@PathVariable("value") String value) {

        return countryService.findByValue(value);
    }

}
