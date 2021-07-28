package com.school.demo.Controller;

import com.school.demo.Model.Teacher;
import com.school.demo.Service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @PostMapping
    public Teacher createEmployee(@RequestBody Teacher teacher){
        return this.teacherService.createTeacher(teacher);
    }

    @GetMapping
    public List<Teacher> getEmployees(){
        return this.teacherService.getTeachers();
    }

}
