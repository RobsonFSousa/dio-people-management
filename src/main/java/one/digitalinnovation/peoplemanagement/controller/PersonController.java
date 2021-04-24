package one.digitalinnovation.peoplemanagement.controller;


import lombok.AllArgsConstructor;
import one.digitalinnovation.peoplemanagement.dto.response.MessageResponsePersonDTO;
import one.digitalinnovation.peoplemanagement.dto.request.PersonDTO;
import one.digitalinnovation.peoplemanagement.exception.PersonNotFoundException;
import one.digitalinnovation.peoplemanagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponsePersonDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.save(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponsePersonDTO updateById(@PathVariable Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}
