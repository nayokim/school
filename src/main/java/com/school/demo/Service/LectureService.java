package com.school.demo.Service;


import com.school.demo.Model.Lecture;
import com.school.demo.repo.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService {
    private final LectureRepository lectureRepository;

    @Autowired
    public LectureService(LectureRepository lectureRepository){
        this.lectureRepository = lectureRepository;
    }

    public Lecture createLecture(Lecture lecture){
        return this.lectureRepository.save(lecture);
    }

    public List<Lecture> getLectures(){
        return this.lectureRepository.findAll();
    }
}
