package com.fastcampus.javaallinon.mycontact.Work;

import com.fastcampus.javaallinon.mycontact.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class WorkController {

    @Autowired
    private WorkService workService;

    @GetMapping(value = "/birthday-friends")
    public List <Person> findBirthdayFriends(){
        return workService.findBirthdayFriends();
    }



}
