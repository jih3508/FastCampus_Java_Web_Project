package com.fastcampus.javaallinon.mycontact.controller;

import com.fastcampus.javaallinon.mycontact.controller.dto.PersonDto;
import com.fastcampus.javaallinon.mycontact.domain.Person;
import com.fastcampus.javaallinon.mycontact.repository.PersonRepository;
import com.fastcampus.javaallinon.mycontact.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/person")
@RestController
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("{id}")
    public Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postPerson(@RequestBody Person person){
        personService.put(person);

        log.info("person -> {}", personRepository.findAll());
    }

    @PutMapping("/{id}")
    public void modifyPerson(@PathVariable Long id,@RequestBody PersonDto personDto){
        personService.modify(id, personDto);

        log.info("person -> {}", personRepository.findAll());
    }

    @PatchMapping("/{id}")
    public void modifyPerson(@PathVariable Long id, String name){
        personService.modify(id, name);

        log.info("person -> {}", personRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.delete(id);

        log.info("person -> {}", personRepository.findAll());
    }


}