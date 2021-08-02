package com.school.demo.Controller;

import com.school.demo.Model.Lecture;
import com.school.demo.Service.LectureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/lecture")
public class LectureController {

    private final LectureService lectureService;

    public LectureController(LectureService lectureService){
        this.lectureService = lectureService;
    }

    @PostMapping
    public Lecture createLecture(@RequestBody Lecture lecture){
        return this.lectureService.createLecture(lecture);
    }

    @GetMapping
    public List<Lecture> getLecture(){
        return this.lectureService.getLectures();
    }

    @PutMapping("/{teacherId}/update-teacher")
    public Lecture updateTeacher(@PathVariable Long teacherId, @RequestBody Lecture lecture) throws Exception {
        return this.lectureService.updateTeacher(lecture);
    }

}
