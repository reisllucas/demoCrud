package br.com.demo.crud.crudbackend.domain.dto.person;

import br.com.demo.crud.crudbackend.domain.enums.Country;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

/**
 * Used to handle new inputs of person entity data
 */
@Getter
@Setter
public class NewPersonDTO {

    String name;
    String phone;
    LocalDate birthDay;
    String zipCode;
    String address;
    String email;
    Country country;
    String city;
    String state;


}
