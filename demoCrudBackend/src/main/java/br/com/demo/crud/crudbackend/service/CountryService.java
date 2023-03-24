package br.com.demo.crud.crudbackend.service;

import br.com.demo.crud.crudbackend.domain.dto.CountryDTO;
import br.com.demo.crud.crudbackend.domain.enums.Country;
import br.com.demo.crud.crudbackend.domain.exceptions.BusinessException;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * The class CountryService directs the flow of country entity data.
 * @see br.com.demo.crud.crudbackend.domain.enums.Country
 */
@Service
public class CountryService {

    /**
     * handle a List of Countries
     * @see br.com.demo.crud.crudbackend.domain.dto.CountryDTO
     * @return a List of CountryDTO
     */
    public List<CountryDTO> findAll() {

        return Arrays.asList(Country.values())
                .stream()
                .map((CountryDTO::new))
                .toList();

    }

    /**
     * HTTP GET request to handle a Country entity
     * @param value country acronym
     * @see br.com.demo.crud.crudbackend.domain.dto.CountryDTO
     * @see br.com.demo.crud.crudbackend.domain.exceptions.BusinessException
     * @throws BusinessException if country acronym does not exist
     * @return country's name
     */
    public CountryDTO findByValue(String value) {

         Optional<Country> country = Arrays.asList(Country.values())
                .stream()
                 .filter(count -> count.name().equalsIgnoreCase(value))
                 .findFirst();

         if (country.isPresent()) {

             return new CountryDTO(country.get());
         }
         throw new BusinessException("Country not found");

    }
}
