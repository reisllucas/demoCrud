package br.com.demo.crud.crudbackend.controller;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static br.com.demo.crud.crudbackend.testutils.TestPersonUtils.*;

import br.com.demo.crud.crudbackend.domain.dto.person.PersonDTO;
import br.com.demo.crud.crudbackend.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

    private static final String NAME = "Phillips";

    @InjectMocks
    PersonController personController;

    @Mock
    PersonService personService;

    @Test
    void testFindAll() {


        when(personService.findAll(null))
                .thenReturn(getPersonDTOList());

        when(personService.findAll(NAME))
                .thenReturn(getPersonDTOList(NAME));

        assertThat(personController.findAll(null))
                .hasSize(getPersonDTOList().size());

        assertThat(personController.findAll(NAME))
                .hasSize(getPersonDTOList(NAME).size());

    }

    @Test
    void testFindById() {

        when(personService.findById(getPersonDTO1().getId()))
                .thenReturn(getPersonDTO1());

        assertThat(personController.findById(getPersonDTO1().getId()).getId())
                .isEqualTo(getPersonDTO1().getId());

    }

    @Test
    void testInsert(){

        when(personService.insert(getPersonDTO1()))
                .thenReturn(getPersonDTO1());

        assertThat(personController.insert(getPersonDTO1()))
                .isEqualTo(getPersonDTO1());
    }

    @Test
    void testUpdate() {

        when(personService.update(getPersonDTO1().getId(),getPersonDTO1()))
                .thenReturn(getPersonDTO2());

        assertThat(personController.update(getPersonDTO1().getId(),getPersonDTO1()))
                .isNotEqualTo(getPersonDTO1());

    }

    @Test
    void testDelete() {

        List<PersonDTO> personList = Arrays.asList(getPersonDTO1(), getPersonDTO2(), getPersonDTO3());

        doNothing().when(personService).delete(getPersonDTO1().getId());
        personController.delete(getPersonDTO1().getId());

        assertThat(getPersonDTO1())
                .isNotIn(
                        personList
                                .stream()
                                .filter(personDTO -> !personDTO.equals(getPersonDTO1())).toList()
                );

    }

}
