package com.fastcampus.javaallinon.mycontact.service;

import com.fastcampus.javaallinon.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class WorkServiceTest {

    @InjectMocks
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;
}
