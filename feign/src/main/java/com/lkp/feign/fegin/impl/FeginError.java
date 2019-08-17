package com.lkp.feign.fegin.impl;

import com.lkp.feign.entity.Student;
import com.lkp.feign.fegin.FeginProviderClient;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class FeginError implements FeginProviderClient {
    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务器正在维护。。";
    }
}
