package com.school.demo.service;

import com.school.demo.Model.Lecture;
import com.school.demo.Model.Student;
import com.school.demo.Model.Teacher;
import com.school.demo.Service.StudentService;
import com.school.demo.repo.StudentRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    private StudentRepository studentRepository;
    private StudentService studentService;


    @BeforeEach
    public void setUp() {
        studentRepository = Mockito.mock(StudentRepository.class);
        studentService = new StudentService(studentRepository);

    }

    @Test
    public void createStudentTest() {

        Lecture lecture = new Lecture(null, "Biology", "10:00", 10, null, null);
        Set<Lecture> lectures = new HashSet<>();
        lectures.add(lecture);

        Student input = new Student(null, "Nayoung", "Kim", 10, lectures);
        Student expected = new Student(1L, "Nayoung", "Kim", 10, lectures);

        Mockito.when(studentRepository.save(input)).thenReturn(expected);

        Student response = studentService.createStudent(input);

        Mockito.verify(studentRepository).save(input);
        assertEquals(expected, response);
    }

    @Test
    public void getStudentTest() {
        Lecture lecture = new Lecture(null, "Biology", "10:00", 10, null, null);
        Set<Lecture> lectures = new HashSet<>();
        lectures.add(lecture);
        List<Student> expected = Arrays.asList(
                new Student(null, "Nayoung", "kim", 1, lectures),
                new Student(null, "Inky", "Cat", 1, lectures),
                new Student(null, "Chester", "Cat", 1, lectures)
        );
        Mockito.when(studentRepository.findAll()).thenReturn(expected);

        List<Student> response = studentService.getStudents();

        Mockito.verify(studentRepository).findAll();
        assertEquals(expected, response);
    }

    @Test
    public void deleteStudentTest(){
        long id = 1L;
        studentService.deleteStudent(id);
        Mockito.verify(studentRepository).deleteById(id);
    }
}
