package com.luanvan.ThesisTrack_Backend.schedule_teacher;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.hibernate.mapping.List;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleTeacherService {

    @Autowired
    private ScheduleTeacherRepository scheduleTeacherRepository;

    public List<ScheduleTeacher> getAllSchedules() {
        return scheduleTeacherRepository.findAll();
    }

    public Optional<ScheduleTeacher> getScheduleById(Integer id) {
        return scheduleTeacherRepository.findById(id);
    }
    
    
    public String createSchedule(ScheduleTeacher scheduleTeacher) {
        if (scheduleTeacher.getId() == null || !scheduleTeacherRepository.existsById(scheduleTeacher.getId())) {
            scheduleTeacherRepository.save(scheduleTeacher);
            return "Đã thêm lịch giảng dạy thành công";
        }
        return "Lịch đã tồn tại hoặc không hợp lệ";
    }

    public ScheduleTeacher updateSchedule(Integer id, ScheduleTeacher scheduleTeacher) {
        Optional<ScheduleTeacher> existingScheduleOptional = scheduleTeacherRepository.findById(id);

        if (existingScheduleOptional.isPresent()) {
            ScheduleTeacher existingSchedule = existingScheduleOptional.get();
            // Cập nhật thông tin từ scheduleTeacher vào existingSchedule
            existingSchedule.setTeacher(scheduleTeacher.getTeacher());
            existingSchedule.setSubject(scheduleTeacher.getSubject());
            existingSchedule.setWeek(scheduleTeacher.getWeek());
            existingSchedule.setPeriod(scheduleTeacher.getPeriod());
            existingSchedule.setRoom(scheduleTeacher.getRoom());
            existingSchedule.setTimeSemester(scheduleTeacher.getTimeSemester());

            return scheduleTeacherRepository.save(existingSchedule);
        }
        return null;
    }

    public void deleteSchedule(Integer id) {
        scheduleTeacherRepository.deleteById(id);
    }

    public List<ScheduleTeacher> getScheduleByTeacher(Integer teacherId) {
        return scheduleTeacherRepository.findByTeacher_Id(teacherId);
    }

    public List<ScheduleTeacher> getScheduleBySubject(Integer subjectId) {
        return scheduleTeacherRepository.findBySubject_Id(subjectId);
    }

    public List<ScheduleTeacher> getScheduleByWeek(Integer weekId) {
        return scheduleTeacherRepository.findByWeek_Id(weekId);
    }
}
