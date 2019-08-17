package com.lkp.eurekaclient.dao.impl;

import com.lkp.eurekaclient.dao.StudentDao;
import com.lkp.eurekaclient.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDaoImpl implements StudentDao {

    private static Map<Long,Student> map;

    static {
        map = new HashMap<>();
        map.put(1L,new Student(1L,"张三",22));
        map.put(2L,new Student(2L,"李四",23));
        map.put(3L,new Student(3L,"王五",24));
    }
    @Override
    public Collection<Student> finAll() {
        return map.values();
    }

    @Override
    public Student findById(Long id) {
        return map.get(id);
    }

    @Override
    public void save(Student student) {
        map.put(student.getId(),student);
    }

    @Override
    public void update(Student student) {
        map.put(student.getId(),student);
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }
}
