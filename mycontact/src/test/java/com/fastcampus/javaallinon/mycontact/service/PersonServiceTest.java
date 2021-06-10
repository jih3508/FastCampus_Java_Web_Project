package com.fastcampus.javaallinon.mycontact.service;

import com.fastcampus.javaallinon.mycontact.domain.Block;
import com.fastcampus.javaallinon.mycontact.domain.Person;
import com.fastcampus.javaallinon.mycontact.repository.BlockRepository;
import com.fastcampus.javaallinon.mycontact.repository.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BlockRepository blockRepository;

    /*
    @Test
    void getPeopleExcludeBlocks(){
        givenPeople();

        List<Person> result = personService.getPeopleExcludeBlocks();

        Assertions.assertThat(result.size()).isEqualTo(4);
        Assertions.assertThat(result.get(0).getName()).isEqualTo("martin");
        Assertions.assertThat(result.get(1).getName()).isEqualTo("david");
        Assertions.assertThat(result.get(2).getName()).isEqualTo("benny");
        System.out.println(result);
       result.forEach(System.out::println);
    }*/

    @Test
    void getPeopleByName(){

        List<Person> result = personService.getPeopleByName("martin");

        Assertions.assertThat(result.size()).isEqualTo(1);
        Assertions.assertThat(result.get(0).getName()).isEqualTo("martin");
    }

    /*
    @Test
    void  cascadeTest(){
        givenPeople();

        List<Person> result = personRepository.findAll();

        result.forEach(System.out::println);

        Person person = result.get(3);
        person.getBlock().setStartDate(LocalDate.now());
        person.getBlock().setEndDate(LocalDate.now());

        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);

        personRepository.delete(person);
        personRepository.findAll().forEach(System.out::println);
        blockRepository.findAll().forEach(System.out::println);

        person.setBlock(null);
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
        blockRepository.findAll().forEach(System.out::println);
    }*/

    @Test
    void getPerson(){
        Person person = personService.getPerson(3L);

        Assertions.assertThat(person.getName()).isEqualTo("dennis");
    }

    /*private void givenPeople() {
        givenPerson("martin", 10, "A");
        givenPerson("david", 9, "B");
        givenBlockPerson("denis", 7, "O");
        givenBlockPerson("martin", 11, "AB");
    }*/

   /* private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name, age, bloodType));
    }*/

    /*private void givenBlockPerson(String name, int age, String bloodType){
        Person blockPerson = new Person(name, age, bloodType);
        blockPerson.setBlock(new Block(name));

        personRepository.save(blockPerson);
    }*/

}