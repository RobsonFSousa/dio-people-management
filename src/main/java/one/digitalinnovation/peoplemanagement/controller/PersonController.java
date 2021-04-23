package one.digitalinnovation.peoplemanagement.controller;


import one.digitalinnovation.peoplemanagement.dto.MessageResponsePersonDTO;
import one.digitalinnovation.peoplemanagement.dto.request.PersonDTO;
import one.digitalinnovation.peoplemanagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping()
    public MessageResponsePersonDTO post(@RequestBody @Valid PersonDTO personDTO) {
        return personService.save(personDTO);
    }
}
