package com.luanvan.ThesisTrack_Backend.schedule_teacher;

import java.util.List;
// import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleTeacherRepository extends JpaRepository<ScheduleTeacher, Integer> {
    
    List<ScheduleTeacher> findByTeacher_Id(Integer teacherId);

    List<ScheduleTeacher> findBySubject_Id(Integer subjectId);

    List<ScheduleTeacher> findByWeek_Id(Integer weekId);

    // List<ScheduleTeacher> findByPeriod_Id(Integer periodId);

    // List<ScheduleTeacher> findByRoom_id(Integer roomId);

    // List<ScheduleTeacher> findByTimeSemester_Id(Integer timeSemesterId);
}
