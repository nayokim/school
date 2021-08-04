package com.school.demo.service;

import com.school.demo.Model.Student;
import com.school.demo.Service.StudentService;
import com.school.demo.repo.StudentRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;


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
        Student input = new Student(null, "Nayoung", "Kim", 10, null);
        Student expected = new Student(1L, "Nayoung", "Kim", 10, null);


        Mockito.when(studentRepository.save(input)).thenReturn(expected);

        Student response = studentService.createStudent(input);

        Mockito.verify(studentRepository).save(input);
        assertEquals(expected, response);
    }

    @Test
    public void getStudentTest() {

        List<Student> expected = Arrays.asList(
                new Student(null, "Nayoung", "kim", 1, null),
                new Student(null, "Inky", "Cat", 1, null),
                new Student(null, "Chester", "Cat", 1, null)
        );
        Mockito.when(studentRepository.findAll()).thenReturn(expected);

        List<Student> response = studentService.getStudents();

        Mockito.verify(studentRepository).findAll();
        assertEquals(expected, response);
    }
}
