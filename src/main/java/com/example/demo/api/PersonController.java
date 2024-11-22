package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("addPerson")
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        System.out.println(person.getName());
        System.out.println(person.getId());
        int statusOfInsert = personService.addPerson(person);
        String statusInsert = statusOfInsert == 0 ? "Inserted Successfully!!" : "Inserted Unsuccessfully!!";
        HttpStatus resStatus = statusOfInsert == 0 ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<String>(statusInsert, resStatus);
    }

    @GetMapping("allPeople")
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping("person")
    public List<Person> getPerson(@RequestBody Person person) {
        return personService.getPerson(person);
    }
}
