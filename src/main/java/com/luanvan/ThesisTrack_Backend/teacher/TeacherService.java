package com.luanvan.ThesisTrack_Backend.teacher;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherReponsitory;

    public Optional<Teacher> getTeacherByNoTeacher(String noTeacher){
        return teacherReponsitory.findByNumberTeacher(noTeacher);
    }

    public Optional<Teacher> getTeacherById(Integer id) {
        return teacherReponsitory.findById(id);
    }
}
