package one.digitalinnovation.peoplemanagement.service;

import one.digitalinnovation.peoplemanagement.dto.MessageResponsePersonDTO;
import one.digitalinnovation.peoplemanagement.entity.Person;
import one.digitalinnovation.peoplemanagement.repository.PersonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepositoryImpl peopleRepository;

    public PersonService(PersonRepositoryImpl peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public MessageResponsePersonDTO save(Person person) {
        Person personSaved = peopleRepository.save(person);
        return MessageResponsePersonDTO
                .builder()
                .message("Person saved with id: " + personSaved.getId())
                .build();
    }
}
