package com.lkp.resttemplate.controller;

import com.lkp.resttemplate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class restController {

    @Autowired
    private RestTemplate template;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return template.getForEntity("http://localhost:8010/student/findAll",Collection.class).getBody();
    }

    @GetMapping("/findAll2")
    public Collection<Student> findAll2(){
        return template.getForObject("http://localhost:8010/student/findAll",Collection.class);
    }

    @GetMapping("findById/{id}")
    public Student findById(@PathVariable("id") long id){
        return template.getForEntity("http://localhost:8010/student/findById/{id}",Student.class,id).getBody();
    }

    @GetMapping("findById2/{id}")
    public Student findById2(@PathVariable("id") long id){
        return template.getForObject("http://localhost:8010/student/findById/{id}",Student.class,id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        template.postForEntity("http://localhost:8010/student/save",student,null).getBody();
    }

    @PostMapping("/save2")
    public void save2(@RequestBody Student student) {
        template.postForObject("http://localhost:8010/student/save",student,null);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        template.put("http://localhost:8010/student/update",student);
    }

    @DeleteMapping("deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        template.delete("http://localhost:8010/student/deleteById/{id}",id);
    }
}
