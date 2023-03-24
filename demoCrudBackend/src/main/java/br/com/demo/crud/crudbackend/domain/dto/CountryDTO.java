package br.com.demo.crud.crudbackend.domain.dto;

import br.com.demo.crud.crudbackend.domain.enums.Country;
import lombok.Getter;
import lombok.Setter;

/**
 * Used to handle country entity data
 */
@Getter
@Setter
public class CountryDTO {

    public CountryDTO() {
    }

    public CountryDTO(Country country) {
        this.value = country.name();
        this.description = country.getDescription();
    }

    private String value;
    private String description;

}
