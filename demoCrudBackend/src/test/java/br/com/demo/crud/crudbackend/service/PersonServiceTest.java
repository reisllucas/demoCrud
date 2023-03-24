package br.com.demo.crud.crudbackend.service;

import static org.mockito.Mockito.*;
import static br.com.demo.crud.crudbackend.testutils.TestPersonUtils.*;

import br.com.demo.crud.crudbackend.domain.exceptions.BusinessException;
import br.com.demo.crud.crudbackend.domain.model.Person;
import br.com.demo.crud.crudbackend.mapper.PersonMapper;
import br.com.demo.crud.crudbackend.repository.person.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    private static final String NAME = "Phillips";

    @InjectMocks
    PersonService personService;

    @Mock
    PersonMapper personMapper;

    @Mock
    PersonRepository personRepository;

    @Test
    void testFindAll() {

        when(personRepository.findAll(""))
                .thenReturn(getPersonList());

        when(personRepository.findAll(NAME))
                .thenReturn(getPersonList(NAME));

        assertThat(personService.findAll(""))
                .hasSize(getPersonList().size());

        assertThat(personService.findAll(NAME))
                .hasSize(getPersonList(NAME).size());

    }

    @Test
    void testInsert(){

        when(personMapper.convertNewToModel(getPersonDTO1()))
                .thenReturn(getPerson1());

        when(personRepository.save(getPerson1()))
                .thenReturn(getPerson1());

        when(personMapper.converToDto(getPerson1()))
                .thenReturn(getPersonDTO1());

        assertThat(personService.insert(getPersonDTO1()))
                .isEqualTo(getPersonDTO1());
    }

    @Test
    void testUpdate() {

        when(personRepository.findById(getPersonDTO1().getId()))
                .thenReturn(Optional.of(getPerson1()));

        when(personMapper.convertToModel(getPerson1(), getPersonDTO1()))
                .thenReturn(getPerson1());

        when(personRepository.save(getPerson1()))
                .thenReturn(getPerson2());

        when(personMapper.converToDto(getPerson2()))
                .thenReturn(getPersonDTO2());

        assertThat(personService.update(getPersonDTO1().getId(), getPersonDTO1()))
                .isNotEqualTo(getPersonDTO1());
    }

    @Test
    void testUpdateException() {

        when(personRepository.findById(getPersonDTO1().getId()))
                .thenReturn(Optional.empty());

        BusinessException excep = Assertions.assertThrows(BusinessException.class, () ->
                personService.update(getPersonDTO1().getId(), getPersonDTO1()));

        assertThat(excep.getMessage()).isNotEmpty();
    }

    @Test
    void testDelete() {
        List<Person> personList = Arrays.asList(getPerson1(), getPerson2(), getPerson3());

        doNothing().when(personRepository).deleteById(getPersonDTO1().getId());
        personService.delete(getPersonDTO1().getId());

        assertThat(getPerson1())
                .isNotIn(
                        personList
                                .stream()
                                .filter(person -> !person.equals(getPerson1())).toList()
                );
    }


}
