package com.school.demo.Service;


import com.school.demo.Model.Lecture;
import com.school.demo.Model.Student;
import com.school.demo.repo.LectureRepository;
import com.school.demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService {
    private final LectureRepository lectureRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public LectureService(LectureRepository lectureRepository, StudentRepository studentRepository){
        this.lectureRepository = lectureRepository;
        this.studentRepository = studentRepository;
    }

    public Lecture createLecture(Lecture lecture){
        return this.lectureRepository.save(lecture);
    }

    public List<Lecture> getLectures(){
        return this.lectureRepository.findAll();
    }

    public Lecture getLecture(long id){
        return this.lectureRepository.getById(id);
    }

      //add student to a lecture



}
