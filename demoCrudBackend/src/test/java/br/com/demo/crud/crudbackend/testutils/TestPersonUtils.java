package br.com.demo.crud.crudbackend.testutils;

import br.com.demo.crud.crudbackend.domain.dto.person.PersonDTO;
import br.com.demo.crud.crudbackend.domain.enums.Country;
import br.com.demo.crud.crudbackend.domain.model.Person;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class TestPersonUtils {

    private static PersonDTO PERSON_DTO1;
    private static PersonDTO PERSON_DTO2;
    private static PersonDTO PERSON_DTO3;

    private static Person PERSON_1;
    private static Person PERSON_2;
    private static Person PERSON_3;

    static {

        PERSON_DTO1 = createPersonDTO1();
        PERSON_DTO2 = createPersonDTO2();
        PERSON_DTO3 = createPersonDTO3();

        PERSON_1 = createPerson1();
        PERSON_2 = createPerson2();
        PERSON_3 = createPerson3();

    }

    public static PersonDTO getPersonDTO1() {
        return PERSON_DTO1;
    }

    public static PersonDTO getPersonDTO2() {
        return PERSON_DTO2;
    }

    public static PersonDTO getPersonDTO3() {
        return PERSON_DTO3;
    }

    public static Person getPerson1() {
        return PERSON_1;
    }

    public static Person getPerson2() {
        return PERSON_2;
    }

    public static Person getPerson3() {
        return PERSON_3;
    }

    public static List<PersonDTO> getPersonDTOList() {

        return Arrays.asList(PERSON_DTO1, PERSON_DTO2, PERSON_DTO3);
    }

    public static List<PersonDTO> getPersonDTOList(String name) {

        if (name == null || name.isEmpty()) return getPersonDTOList();

        return  getPersonDTOList()
                .stream().filter(
                        personDTO -> personDTO.getName().toUpperCase().indexOf(name) != -1
                )
                .toList();
    }

    private static PersonDTO createPersonDTO1() {

        PersonDTO person = new PersonDTO();

        person.setId(1L);
        person.setName("Andrew Phillips");
        person.setEmail("andrew.phillips@hotmail.com");
        person.setPhone("818-123-3578");
        person.setZipCode("91436");
        person.setAddress("6542316 Ventura Blvd, Encino");
        person.setCity("Los Angeles");
        person.setCountry(Country.US);
        person.setState("CA");
        person.setBirthDay(LocalDate.of(1970, Month.AUGUST, 15));

        return person;

    }

    private static PersonDTO createPersonDTO2() {

        PersonDTO person = new PersonDTO();

        person.setId(2L);
        person.setName("George Willians");
        person.setEmail("george.willians@yahoo.com");
        person.setPhone("818-777-2578");
        person.setZipCode("91436");
        person.setAddress("6542316 Ventura Blvd, Encino");
        person.setCity("Los Angeles");
        person.setCountry(Country.US);
        person.setState("CA");
        person.setBirthDay(LocalDate.of(1970, Month.AUGUST, 15));

        return person;

    }

    private static PersonDTO createPersonDTO3() {

        PersonDTO person = new PersonDTO();

        person.setId(3L);
        person.setName("Susan Brawn");
        person.setEmail("susan.brawn@gmail.com");
        person.setPhone("818-568-1234");
        person.setZipCode("91356");
        person.setAddress("2337 1st Ave, Manhattan, East Harlem");
        person.setCity("NYC");
        person.setCountry(Country.US);
        person.setState("Manhattan");
        person.setBirthDay(LocalDate.of(2002, Month.JANUARY, 8));

        return person;

    }

    public static List<Person> getPersonList() {

        return Arrays.asList(PERSON_1, PERSON_2, PERSON_3);
    }

    public static List<Person> getPersonList(String name) {

        if (name == null || name.isEmpty()) return getPersonList();

        return  getPersonList()
                .stream().filter(
                        person -> person.getName().toUpperCase().indexOf(name) != -1
                )
                .toList();
    }

    private static Person createPerson1() {

        Person person = new Person();

        person.setId(1L);
        person.setName("Andrew Phillips");
        person.setEmail("andrew.phillips@hotmail.com");
        person.setPhone("818-123-3578");
        person.setZipCode("91436");
        person.setAddress("6542316 Ventura Blvd, Encino");
        person.setCity("Los Angeles");
        person.setCountry(Country.US);
        person.setState("CA");
        person.setBirthDay(LocalDate.of(1970, Month.AUGUST, 15));

        return person;

    }

    private static Person createPerson2() {

        Person person = new Person();

        person.setId(2L);
        person.setName("George Willians");
        person.setEmail("george.willians@yahoo.com");
        person.setPhone("818-777-2578");
        person.setZipCode("91436");
        person.setAddress("6542316 Ventura Blvd, Encino");
        person.setCity("Los Angeles");
        person.setCountry(Country.US);
        person.setState("CA");
        person.setBirthDay(LocalDate.of(1970, Month.AUGUST, 15));

        return person;

    }

    private static Person createPerson3() {

        Person person = new Person();

        person.setId(3L);
        person.setName("Susan Brawn");
        person.setEmail("susan.brawn@gmail.com");
        person.setPhone("818-568-1234");
        person.setZipCode("91356");
        person.setAddress("2337 1st Ave, Manhattan, East Harlem");
        person.setCity("NYC");
        person.setCountry(Country.US);
        person.setState("Manhattan");
        person.setBirthDay(LocalDate.of(2002, Month.JANUARY, 8));

        return person;

    }

}
