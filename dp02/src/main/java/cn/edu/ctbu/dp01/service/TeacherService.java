package cn.edu.ctbu.dp01.service;

import cn.edu.ctbu.dp01.dao.TeacherReporsitory;
import cn.edu.ctbu.dp01.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    public TeacherReporsitory teacherReporsitory;


    public List<Teacher> getAll() {
        return teacherReporsitory.findAll();
    }

    public Teacher findById(int id) {

        return teacherReporsitory.findById(id).get();
    }



    public Teacher add(Teacher teacher) {
        return teacherReporsitory.save(teacher);
    }

    public Teacher update(Teacher teacher) {
        return teacherReporsitory.save(teacher);
    }

    public void delete(Integer id) {
        teacherReporsitory.deleteById(id);
    }
}
