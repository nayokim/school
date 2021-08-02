package com.school.demo.Controller;

import com.school.demo.Model.Student;
import com.school.demo.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student createStudent){
        return this.studentService.createStudent(createStudent);
    }

    @GetMapping
    public List<Student> getStudents(){
        return this.studentService.getStudents();
    }

    @PutMapping("/{studentId}/update-student")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody Student student) throws Exception {
        return this.studentService.updateLecture(student);
    }
}
