package br.com.demo.crud.crudbackend.utils;

import br.com.demo.crud.crudbackend.domain.dto.CountryDTO;
import br.com.demo.crud.crudbackend.domain.enums.Country;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UtilsTest {

    @Test
    void testIsNumeric() {

        assertThat(Utils.isNumeric("adsasdasd"))
                .isFalse();

        assertThat(Utils.isNumeric("111adsasdasd"))
                .isFalse();

        assertThat(Utils.isNumeric("adsasdasd111"))
                .isFalse();

        assertThat(Utils.isNumeric("ads11asd11asd"))
                .isFalse();

        assertThat(Utils.isNumeric("1000"))
                .isTrue();
    }

    @Test
    void testIsCountry() {

        Arrays.asList(Country.values())
                .forEach(
                        country -> assertThat(
                                Utils.isCountry(country.getDescription())
                        ).isPresent()
                );

        Arrays.asList(Country.values())
                .forEach(
                        country -> {

                            CountryDTO dto = new CountryDTO();
                            dto.setValue(country.name());
                            dto.setDescription(country.getDescription());

                            assertThat(dto.getDescription())
                                    .isNotEmpty();

                            assertThat(new CountryDTO(country).getDescription())
                                .isNotEmpty();

                        }


                );

        assertThat(Utils.isCountry("WH"))
                .isNotPresent();
    }

}
