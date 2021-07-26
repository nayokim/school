package com.school.demo.Service;

import com.school.demo.Model.Student;
import com.school.demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        return this.studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return this.studentRepository.findAll();
    }
}
