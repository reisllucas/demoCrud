package br.com.demo.crud.crudbackend.service;

import static br.com.demo.crud.crudbackend.testutils.TestPersonUtils.getPersonDTO2;
import static org.assertj.core.api.Assertions.assertThat;

import br.com.demo.crud.crudbackend.domain.dto.CountryDTO;
import br.com.demo.crud.crudbackend.domain.enums.Country;
import br.com.demo.crud.crudbackend.domain.exceptions.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CountryServiceTest {

    private static final String BR = "BR";
    private static final String COUNTRY_EXCEPTION = "XWY";
    @InjectMocks
    CountryService countryService;

    @Test
    void testFindAll() {

        assertThat(countryService.findAll())
                .hasSize(Country.values().length);


    }

    @Test
    void testFindByValue() {

        assertThat(countryService.findByValue(BR).getValue())
                .isEqualTo(Country.BR.name());



    }

    @Test
    void testFindByValueException() {

        BusinessException excep = Assertions.assertThrows(BusinessException.class, () ->
                countryService.findByValue(COUNTRY_EXCEPTION));

        assertThat(excep.getMessage()).isNotEmpty();
    }
}
