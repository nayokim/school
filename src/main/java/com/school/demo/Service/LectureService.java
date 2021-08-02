package com.school.demo.Service;


import com.school.demo.Model.Lecture;
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

    public Lecture updateTeacher(Lecture lecture) throws Exception{
        Lecture existingTeacher = this.lectureRepository
                .findById(lecture.getId())
                .orElseThrow(()-> new Exception ("lecture with id " + lecture.getId() + " does not exist"));

        // since in this program, there will only be one teacher per lecture, the relationship is one to many
        existingTeacher.setTeacher(lecture.getTeacher());
        return this.lectureRepository.save(existingTeacher);

    }









}
