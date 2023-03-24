package br.com.demo.crud.crudbackend.domain.dto.person;

import lombok.Getter;
import lombok.Setter;

/**
 * Used to handle person entity data
 */
@Getter
@Setter
public class PersonDTO extends NewPersonDTO {
    Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO person = (PersonDTO) o;
        return id.equals(person.id);
    }


}
