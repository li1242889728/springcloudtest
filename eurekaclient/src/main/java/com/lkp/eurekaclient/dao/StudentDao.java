package com.lkp.eurekaclient.dao;

import com.lkp.eurekaclient.entity.Student;

import java.util.Collection;

public interface StudentDao {
    Collection<Student> finAll();
    Student findById(Long id);
    void save(Student student);
    void update(Student student);
    void deleteById(Long id);
}
