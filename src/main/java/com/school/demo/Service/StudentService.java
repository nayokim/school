package com.school.demo.Service;

import com.school.demo.Model.Student;
//import com.school.demo.exceptions.StudentNotFoundException;
import com.school.demo.exceptions.StudentNotFoundException;
import com.school.demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        return this.studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return this.studentRepository.findAll();
    }

    public Student getById(long id){
        Optional<Student> student = studentRepository.findById(id);

        if (!student.isPresent()){
            throw new StudentNotFoundException("there is no student with that id");
        }

        return student.get();
    }

    public Student updateLecture(Student student) throws Exception{
        Student existingLecture = this.studentRepository
                .findById(student.getId())
                .orElseThrow(()-> new Exception("Student with id: " + student.getId() + " does not exist"));
        //loop through all the lectures that the student is enrolled in since the relationship between student and lectures is many to many.
        student.getLectures().forEach(lecture -> {
            if (!existingLecture.getLectures().contains(lecture)) {
                existingLecture.getLectures().add(lecture);
            }
        });
        return this.studentRepository.save(existingLecture);
    }

    public void deleteStudent(Student student) throws Exception{
        Student studentToDelete = studentRepository
                .findById(student.getId())
                .orElseThrow(() -> new Exception ("Student with id " + student.getId() + " does not exist"));
        this.studentRepository.delete(studentToDelete);
    }
}
