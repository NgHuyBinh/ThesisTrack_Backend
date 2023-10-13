package com.luanvan.ThesisTrack_Backend.teachingschedule;

import com.luanvan.ThesisTrack_Backend.subject.Subject;
import com.luanvan.ThesisTrack_Backend.subject.SubjectService;
import com.luanvan.ThesisTrack_Backend.teacher.Teacher;
import com.luanvan.ThesisTrack_Backend.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/teaching-schedule")
public class TeachingScheduleResource {

    @Autowired
    private TeachingScheduleService teachingScheduleService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/by-teacher/{teacherId}")
    public ResponseEntity<?> getByTeacher(@PathVariable Integer teacherId) {
        Optional<Teacher> optionalTeacher = teacherService.getTeacherById(teacherId);
        if (optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            List<TeachingSchedule> teachingSchedules = teachingScheduleService.getByTeacher(teacher);
            return ResponseEntity.ok(teachingSchedules);
        } else {
            return ResponseEntity.badRequest().body("Không tìm thấy giảng viên.");
        }
    }

    @GetMapping("/by-subject/{subjectId}")
    public ResponseEntity<?> getBySubject(@PathVariable Integer subjectId) {
        Optional<Subject> optionalSubject = subjectService.getSubjectById(subjectId);
        if (optionalSubject.isPresent()) {
            Subject subject = optionalSubject.get();
            List<TeachingSchedule> teachingSchedules = teachingScheduleService.getBySubject(subject);
            return ResponseEntity.ok(teachingSchedules);
        } else {
            return ResponseEntity.badRequest().body("Subject not found for the given ID.");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeachingSchedule(@RequestBody TeachingSchedule teachingSchedule) {
        TeachingSchedule savedTeachingSchedule = teachingScheduleService.addTeachingSchedule(teachingSchedule);

        if (savedTeachingSchedule != null) {
            return ResponseEntity.ok("Teaching schedule added successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to add teaching schedule.");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTeachingSchedule(@RequestBody TeachingSchedule teachingSchedule) {
        TeachingSchedule updatedTeachingSchedule = teachingScheduleService.updateTeachingSchedule(teachingSchedule);

        if (updatedTeachingSchedule != null) {
            return ResponseEntity.ok("Teaching schedule updated successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to update teaching schedule.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeachingSchedule(@PathVariable Integer id) {
        try {
            teachingScheduleService.deleteTeachingSchedule(id);
            return ResponseEntity.ok("Teaching schedule deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to delete teaching schedule. Error: " + e.getMessage());
        }
    }
}
