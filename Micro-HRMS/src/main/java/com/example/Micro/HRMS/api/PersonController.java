package com.example.Micro.HRMS.api;

import com.example.Micro.HRMS.model.Person;
import com.example.Micro.HRMS.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "{id}")
    public Person getAPerson(@PathVariable("id") UUID id) {
        return personService.getAPerson(id)
                .orElse(null);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "{id}")
    public boolean updatePerson(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person person){
        return personService.updatePerson(id, person);
    }
}
