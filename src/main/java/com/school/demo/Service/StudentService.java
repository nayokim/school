package com.school.demo.Service;

import com.school.demo.Model.Lecture;
import com.school.demo.Model.Student;
import com.school.demo.repo.LectureRepository;
import com.school.demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, LectureRepository lectureRepository){
        this.studentRepository = studentRepository;
        this.lectureRepository = lectureRepository;
    }

    public Student createStudent(Student student){
        return this.studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return this.studentRepository.findAll();
    }


}
