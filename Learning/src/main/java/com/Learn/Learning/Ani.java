package com.Learn.Learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ani{

    @Autowired
    private Dog dog;

    @GetMapping("/ok")
    public String ok(){
        return dog.fun();
    }
}
