package com.fastcampus.javaallinon.mycontact.controller;

import com.fastcampus.javaallinon.mycontact.exception.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloWorldController {
    @GetMapping(value = "/api/helloWorld")
    public String helloWorld(){
        return "HelloWorld";
    }

    @GetMapping(value = "/api/helloException")
    public String helloException(){
        throw new RuntimeException("hello RuntimeException");
    }

}
