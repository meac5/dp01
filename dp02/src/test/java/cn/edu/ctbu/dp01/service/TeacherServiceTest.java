package cn.edu.ctbu.dp01.service;

import cn.edu.ctbu.dp01.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherServiceTest {
//    @Autowired
//    private TeacherService teacherService;
//
//    @Test
//    void findById() {
//        Teacher teacher1 = teacherService.findById(1);
//        Teacher teacher2 = teacherService.findById(2);
//        Teacher teacher3 = teacherService.findById(3);
//        Teacher teacher4 = teacherService.findById(4);
//
//        assertNotNull(teacher1);
//        assertNotNull(teacher2);
//        assertNotNull(teacher3);
//        assertNotNull(teacher4);
//    }
//    @Test
//    void findByNum() {
//        List<Teacher> teacher1 = teacherService.findByNum("20200101");
//        List<Teacher> teacher2 = teacherService.findByNum("20200102");
//
//        assertNotNull(teacher1);
//        assertNotNull(teacher2);
//    }
//
//    @Test
//    void insert() {
//        Teacher teacher = new Teacher();
//        teacher.setName("陈五");
//        teacher.setSex(1);
//        teacher.setAge(30);
//        teacher.setNum("20220103");
//        teacher.setPassword("963");
//        teacherService.insert(teacher);
//        assertNotNull(teacher.getId());
//    }
//    @Test
//    void update() {
//        Teacher teacher= teacherService.findById(1);
//        teacher.setName("王一柱");
//        teacher.setPassword("111");
//
//        teacherService.update(teacher);
//        assertEquals(teacher.getName(),"王一柱");
//        assertEquals(teacher.getPassword(),"111");
//    }
//
//    @Test
//    void delete() {
//        teacherService.delete(3);
//        Teacher teacher= teacherService.findById(3);
//        assertNull(teacher);
//    }
//    @Test
//    void findMaxNumber() {
//        Teacher teacher1 = teacherService.findById(1);
//        Teacher teacher2 = teacherService.findById(2);
//        Teacher teacher4 = teacherService.findById(4);
//        Teacher teacher6 = teacherService.findById(6);
//        List<Teacher> teachers = List.of(teacher1, teacher2, teacher4, teacher6);
//        Teacher maxNumTeacher = teacherService.findMaxNum(teachers);
//
//        assertNotNull(maxNumTeacher);
//    }
}