package one.digitalinnovation.peoplemanagement.service;

import one.digitalinnovation.peoplemanagement.dto.response.MessageResponsePersonDTO;
import one.digitalinnovation.peoplemanagement.mapper.PersonMapper;
import one.digitalinnovation.peoplemanagement.dto.request.PersonDTO;
import one.digitalinnovation.peoplemanagement.entity.Person;
import one.digitalinnovation.peoplemanagement.repository.PersonRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static one.digitalinnovation.peoplemanagement.utils.PersonUtils.createFakeDTO;
import static one.digitalinnovation.peoplemanagement.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepositoryImpl personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    public void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        lenient().when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponsePersonDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
        MessageResponsePersonDTO successMessage = personService.save(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponsePersonDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponsePersonDTO.builder()
                .message("Person saved with id: " + savedPersonId)
                .build();
    }
}
