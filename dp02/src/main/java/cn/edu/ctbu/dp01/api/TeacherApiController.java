package cn.edu.ctbu.dp01.api;

import cn.edu.ctbu.dp01.entity.Teacher;
import cn.edu.ctbu.dp01.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teacher")
public class TeacherApiController {

    @Autowired
    private TeacherService teacherService;
    @GetMapping("/tlist")
    public List<Teacher> findAll(){

        List<Teacher> teachers = teacherService.getAll();
        return teachers;
    }

    @GetMapping("/{id}")
    public Teacher findById(@PathVariable int id){
        Teacher teacher = teacherService.findById(id);
        return teacher;
    }

    @PostMapping("/add")
    public Teacher add( Teacher teacher){
        return teacherService.add(teacher);
    }
    @PutMapping("/update")
    public Teacher update( Teacher teacher){
        return teacherService.update(teacher);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        teacherService.delete(id);
    }
}
