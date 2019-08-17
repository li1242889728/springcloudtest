package com.lkp.eurekaclient.controller;

import com.lkp.eurekaclient.dao.StudentDao;
import com.lkp.eurekaclient.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @Value("${server.port}")
    private String port;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return studentDao.finAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id){
        return studentDao.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        studentDao.save(student);
    }
    @PutMapping("/update")
    public void update(@RequestBody Student student){
        studentDao.update(student);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        studentDao.deleteById(id);
    }

    @GetMapping("/index")
    public String index(){
        return "当前服务端口:"+this.port;
    }
}
