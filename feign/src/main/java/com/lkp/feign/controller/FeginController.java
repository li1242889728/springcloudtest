package com.lkp.feign.controller;

import com.lkp.feign.entity.Student;
import com.lkp.feign.fegin.FeginProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/feign")
public class FeginController {

    @Autowired
    private FeginProviderClient feginProviderClient;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return feginProviderClient.findAll();
    }

    @GetMapping("/index")
    public String index(){
        return feginProviderClient.index();
    }
}
