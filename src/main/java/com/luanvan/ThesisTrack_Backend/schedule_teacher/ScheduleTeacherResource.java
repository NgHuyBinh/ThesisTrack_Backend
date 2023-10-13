package com.luanvan.ThesisTrack_Backend.schedule_teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/schedules")
public class ScheduleTeacherResource {

    @Autowired
    private ScheduleTeacherService scheduleTeacherService;

    @GetMapping
    public List<ScheduleTeacher> getAllSchedules() {
        return scheduleTeacherService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public Optional<ScheduleTeacher> getScheduleById(@PathVariable Integer id) {
        return scheduleTeacherService.getScheduleById(id);
    }

    @PostMapping
    public ResponseEntity<String> createSchedule(@RequestBody ScheduleTeacher scheduleTeacher) {
        String responseMessage = scheduleTeacherService.createSchedule(scheduleTeacher);
        if (responseMessage.equals("Đã thêm lịch giảng dạy thành công")) {
            return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSchedule(@PathVariable Integer id,
            @RequestBody ScheduleTeacher scheduleTeacher) {
        ScheduleTeacher updatedSchedule = scheduleTeacherService.updateSchedule(id, scheduleTeacher);
        if (updatedSchedule != null) {
            return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Lịch không tồn tại hoặc không hợp lệ", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSchedule(@PathVariable Integer id) {
        scheduleTeacherService.deleteSchedule(id);
        return new ResponseEntity<>("Lịch đã được xóa thành công", HttpStatus.OK);
    }

    @GetMapping("/teacher/{teacherId}")
    public List<ScheduleTeacher> getScheduleByTeacher(@PathVariable Integer teacherId) {
        return scheduleTeacherService.getScheduleByTeacher(teacherId);
    }

    @GetMapping("/subject/{subjectId}")
    public List<ScheduleTeacher> getScheduleBySubject(@PathVariable Integer subjectId) {
        return scheduleTeacherService.getScheduleBySubject(subjectId);
    }

    @GetMapping("/week/{weekId}")
    public List<ScheduleTeacher> getScheduleByWeek(@PathVariable Integer weekId) {
        return scheduleTeacherService.getScheduleByWeek(weekId);
    }
}
