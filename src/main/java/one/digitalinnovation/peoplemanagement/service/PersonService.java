package one.digitalinnovation.peoplemanagement.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.peoplemanagement.dto.MessageResponsePersonDTO;
import one.digitalinnovation.peoplemanagement.dto.request.PersonDTO;
import one.digitalinnovation.peoplemanagement.entity.Person;
import one.digitalinnovation.peoplemanagement.exception.PersonNotFoundException;
import one.digitalinnovation.peoplemanagement.mapper.PersonMapper;
import one.digitalinnovation.peoplemanagement.repository.PersonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepositoryImpl peopleRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponsePersonDTO save(PersonDTO personDTO) {
        return savePerson(personDTO, "Person saved with id: ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = peopleRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personExists(id);
        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        Person person = personExists(id);
        peopleRepository.deleteById(id);
    }

    public MessageResponsePersonDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        personExists(id);
        return savePerson(personDTO, "Person updated with id: ");
    }

    private MessageResponsePersonDTO savePerson(PersonDTO personDTO, String message) {
        Person personToSave = personMapper.toModel(personDTO);
        Person personSaved = peopleRepository.save(personToSave);
        return MessageResponsePersonDTO
                .builder()
                .message("Person saved with id: " + personSaved.getId())
                .build();
    }

    private Person personExists(Long id) throws PersonNotFoundException {
        return peopleRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
