package com.school.demo.Controller;

import com.school.demo.Model.Student;
import com.school.demo.Service.StudentService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable long id){
        return this.studentService.getById(id);
    }

    @PutMapping("/{studentId}/update-lecture")
    public Student updateLecture(@PathVariable Long studentId, @RequestBody Student student) throws Exception {
        return this.studentService.updateLecture(student);
    }


    @DeleteMapping("/{studentId}/delete-student")
    public String deleteStudent(@PathVariable Long studentId, @RequestBody Student student) throws Exception {
        this.studentService.deleteStudent(student);
        return "Student has been removed from the system";
    }
}
