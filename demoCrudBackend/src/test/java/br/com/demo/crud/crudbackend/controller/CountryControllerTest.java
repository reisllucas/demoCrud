package br.com.demo.crud.crudbackend.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import br.com.demo.crud.crudbackend.domain.dto.CountryDTO;
import br.com.demo.crud.crudbackend.domain.enums.Country;
import br.com.demo.crud.crudbackend.service.CountryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
class CountryControllerTest {

    private static final String BR = "BR";
    @InjectMocks
    CountryController countryController;

    @Mock
    CountryService countryService;

    @Test
    void testFindAll() {

        when(countryService.findAll()).thenReturn(
                Arrays.asList(Country.values())
                        .stream().map(CountryDTO::new)
                        .toList()
        );

        assertThat(countryController.findAll())
                .hasSize(Country.values().length);

    }

    @Test
    void testFindByValue() {

        when(countryService.findByValue(BR))
                .thenReturn(new CountryDTO(Country.BR));

        assertThat(countryController.findByValue(BR).getValue())
                .isEqualTo(Country.BR.name());
    }

}
