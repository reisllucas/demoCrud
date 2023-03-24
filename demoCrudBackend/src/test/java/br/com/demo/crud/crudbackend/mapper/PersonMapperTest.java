package br.com.demo.crud.crudbackend.mapper;

import static org.assertj.core.api.Assertions.*;
import static br.com.demo.crud.crudbackend.testutils.TestPersonUtils.*;

import br.com.demo.crud.crudbackend.domain.exceptions.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonMapperTest {

    @InjectMocks
    PersonMapper personMapper;

    @Test
    void testConvertToModel() {

        assertThat(personMapper.convertToModel(getPerson1(),getPersonDTO2()))
                .isEqualTo(getPerson2());

    }

    @Test()
    void testConvertToModelException() {

        BusinessException excep = Assertions.assertThrows(BusinessException.class, () ->
                personMapper.convertToModel(null,getPersonDTO2()));

        assertThat(excep.getMessage()).isNotEmpty();

    }

    @Test
    void testConvertNewToModel() {

        assertThat(personMapper.convertNewToModel(getPersonDTO2()).getAddress())
                .isEqualTo(getPerson2().getAddress());

    }

    @Test
    void converToDto() {

        assertThat(personMapper.converToDto(getPerson2()))
                .isEqualTo(getPersonDTO2());

    }


}
