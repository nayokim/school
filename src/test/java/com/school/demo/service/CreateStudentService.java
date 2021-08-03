package com.school.demo.service;

import com.school.demo.Model.Student;
import com.school.demo.Service.StudentService;
import com.school.demo.repo.LectureRepository;
import com.school.demo.repo.StudentRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


public class CreateStudentService {

    private StudentRepository studentRepository;
    private StudentService studentService;
    private LectureRepository lectureRepository;

    @BeforeEach
    public void setUp(){
        studentRepository = Mockito.mock(StudentRepository.class);
        lectureRepository = Mockito.mock(LectureRepository.class);
        studentService = new StudentService(studentRepository, lectureRepository);
    }

    @Test
    public void testCreateStudents(){
        Student input = new Student("Nayoung", "Kim", 10);
        Student expected = new Student("Nayoung", "Kim", 10);

        Mockito.when(studentRepository.save(input)).thenReturn(expected);

        Student response = studentService.createStudent(input);

        Mockito.verify(studentRepository).save(input);
        assertEquals(expected, response);
    }
}
