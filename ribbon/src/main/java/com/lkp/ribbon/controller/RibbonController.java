package com.lkp.ribbon.controller;

import com.lkp.ribbon.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate template;

    @RequestMapping("/findAll")
    public Collection<Student> findAll(){
        return template.getForObject("http://provider/student/findAll",Collection.class);
    }

    @RequestMapping("/index")
    public String index(){
        return template.getForObject("http://provider/student/index",String.class);
    }
}
