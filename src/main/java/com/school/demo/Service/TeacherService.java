package com.school.demo.Service;

import com.school.demo.Model.Teacher;
import com.school.demo.repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public Teacher createTeacher(Teacher teacher){
        return this.teacherRepository.save(teacher);
    }

    public List<Teacher> getTeachers(){
        return this.teacherRepository.findAll();
    }
}
