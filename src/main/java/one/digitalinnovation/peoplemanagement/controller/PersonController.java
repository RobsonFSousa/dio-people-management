package one.digitalinnovation.peoplemanagement.controller;


import one.digitalinnovation.peoplemanagement.dto.MessageResponsePersonDTO;
import one.digitalinnovation.peoplemanagement.entity.Person;
import one.digitalinnovation.peoplemanagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping()
    public MessageResponsePersonDTO post(@RequestBody Person person) {
        return personService.save(person);
    }
}
