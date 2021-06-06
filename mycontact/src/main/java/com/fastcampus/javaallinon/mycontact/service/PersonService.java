package com.fastcampus.javaallinon.mycontact.service;

import com.fastcampus.javaallinon.mycontact.controller.dto.PersonDto;
import com.fastcampus.javaallinon.mycontact.domain.Block;
import com.fastcampus.javaallinon.mycontact.domain.Person;
import com.fastcampus.javaallinon.mycontact.domain.dto.Birthday;
import com.fastcampus.javaallinon.mycontact.repository.BlockRepository;
import com.fastcampus.javaallinon.mycontact.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    public List<Person> getPeopleExcludeBlocks(){
        return  personRepository.findByBlockIsNull();
    }

    public List<Person> getPeopleByName(String name){
        return personRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id){
//        Person person = personRepository.findById(id).get();

        Person person = personRepository.findById(id).orElse(null);

        log.info("person : {}", person);

        return person;
    }

    @Transactional
    public void put(Person person){
        personRepository.save(person);
    }

    public void modify(Long id, PersonDto personDto) {
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("아이디가 존재하지 않습니다."));

        if(!person.getName().equals(person.getName())){
            throw new RuntimeException("이름이 다릅니다.");
        }
//        personAtDb.setName(personDto.getName());
//        personAtDb.setPhoneNumber(personDto.getPhoneNumber());
//        personAtDb.setJob(personDto.getJob());
//        if(personDto.getBirthday() != null){
//            personAtDb.setBirthday(new Birthday(personDto.getBirthday()));
//        }
//        personAtDb.setAddress(personDto.getAddress());
//        personAtDb.setBloodType(personDto.getBloodType());
//        personAtDb.setHobby(personDto.getHobby());
//        personAtDb.setAge(personDto.getAge());

        person.set(personDto);

        personRepository.save(person);
    }

    @Transactional
    public void modify(Long id, String name){
        Person person = personRepository.findById(id).orElseThrow(()->new RuntimeException("아이디가 존재하지 않습니다."));

        person.setName(name);

        personRepository.save(person);
    }

    @Transactional
    public void delete(Long id) {
//        personRepository.deleteById(id);

        Person person = personRepository.findById(id).orElseThrow(()->new RuntimeException("아이디가 존재하지 않습니다."));

        person.setDeleted(true);

        personRepository.save(person);
    }
}
