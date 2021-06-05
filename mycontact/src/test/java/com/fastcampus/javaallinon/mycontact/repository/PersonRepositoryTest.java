package com.fastcampus.javaallinon.mycontact.repository;

import com.fastcampus.javaallinon.mycontact.domain.Person;
import com.fastcampus.javaallinon.mycontact.domain.dto.Birthday;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud(){
        Person person = new Person();
        person.setName("john");
        person.setAge(10);
        person.setBloodType("A");

        personRepository.save(person);

        System.out.println(personRepository.findAll());

        List<Person> people = personRepository.findAll();

        Assertions.assertThat(people.size()).isEqualTo(2);
        Assertions.assertThat(people.get(1).getName()).isEqualTo("john");
        Assertions.assertThat(people.get(1).getAge()).isEqualTo(10);
        Assertions.assertThat(people.get(1).getBloodType()).isEqualTo("A");
    }

   /* @Test
    void hashCodAndEquals(){
        Person person1 = new Person("martin", 10, "A");
        Person person2 = new Person("martin", 10, "A");

        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());

        Map<Person, Integer>map = new HashMap<>();
        map.put(person1, person1.getAge());

        System.out.println(map);
        System.out.println(map.get(person2));
    }
*/

    @Test
    void findByBloodType(){
        givenPerson("martin", 10, "A");
        givenPerson("david", 9, "B");
        givenPerson("dennis", 8, "O");
        givenPerson("sophia", 7, "AB");
        givenPerson("benny", 6, "A");

        List<Person> result = personRepository.findByBloodType("A");

        result.forEach(System.out::println);
    }

    @Test
    void findByBirthdayBetween(){
        /*
        givenPerson("martin", 10, "A", LocalDate.of(1991,8,15));
        givenPerson("david", 9, "B", LocalDate.of(1992,7,10));
        givenPerson("dennis", 8, "O", LocalDate.of(1993,1,5));
        givenPerson("sophia", 7, "AB",LocalDate.of(1994,6,30));
        givenPerson("benny", 6, "A",LocalDate.of(1995,8,30));
        */
        List<Person> result = personRepository.findByMonthOfBirthday(8);

        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result.get(0).getName()).isEqualTo("martin");
        Assertions.assertThat(result.get(1).getName()).isEqualTo("sophia");
    }

    private void givenPerson(String name, int age, String bloodTye){
        personRepository.save(new Person(name, age,bloodTye));
    }

    private void givenPerson(String name, int age, String bloodType, LocalDate birthday){
        Person person = new Person(name, age, bloodType);
        person.setBirthday(new Birthday(birthday));
        personRepository.save(person);
    }
}