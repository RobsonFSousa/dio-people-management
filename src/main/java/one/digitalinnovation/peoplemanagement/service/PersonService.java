package one.digitalinnovation.peoplemanagement.service;

import one.digitalinnovation.peoplemanagement.dto.MessageResponsePersonDTO;
import one.digitalinnovation.peoplemanagement.dto.request.PersonDTO;
import one.digitalinnovation.peoplemanagement.entity.Person;
import one.digitalinnovation.peoplemanagement.mapper.PersonMapper;
import one.digitalinnovation.peoplemanagement.repository.PersonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepositoryImpl peopleRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepositoryImpl peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public MessageResponsePersonDTO save(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person personSaved = peopleRepository.save(personToSave);
        return MessageResponsePersonDTO
                .builder()
                .message("Person saved with id: " + personSaved.getId())
                .build();
    }
}
