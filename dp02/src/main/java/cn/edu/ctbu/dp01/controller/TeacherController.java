package cn.edu.ctbu.dp01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @RequestMapping("/tlist")
    public String getList() {

        return "/teacher/tlist";
    }
}
