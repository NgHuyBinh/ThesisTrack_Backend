package com.luanvan.ThesisTrack_Backend.schedule_teacher;

import java.util.ArrayList;
import java.util.List;

import com.luanvan.ThesisTrack_Backend.period.Period;
import com.luanvan.ThesisTrack_Backend.room.Room;
import com.luanvan.ThesisTrack_Backend.subject.Subject;
import com.luanvan.ThesisTrack_Backend.teacher.Teacher;
import com.luanvan.ThesisTrack_Backend.timesemester.TimeSemester;
import com.luanvan.ThesisTrack_Backend.week.Week;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data; 
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schdule_teacher")
public class ScheduleTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // giảng viên
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    // học phần
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    // tuần học
    @ManyToOne
    @JoinColumn(name = "week_id")
    private Week week;

    // tiết học
    @ManyToOne(optional = true)
    @JoinColumn(name = "period_id")
    private Period period;

    // phòng
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    // thời gian
    @ManyToOne
    @JoinColumn(name = "timesemester_id")
    private TimeSemester timeSemester;





    // // kết nối bảng week tạo ra bảng phụ cho thuộc tính nhiều nhiều
    // // kết nối bảng tuần
    // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // @JoinTable(name = "schedule_week", joinColumns = @JoinColumn(name =
    // "schedule_id", referencedColumnName = "id"), inverseJoinColumns =
    // @JoinColumn(name = "week_id", referencedColumnName = "id"))
    // private List<ScheduleTeacher> ScheduleTeacher_week = new ArrayList<>();

    // // kết nối bảng period và tạo bảng phụ
    // // kết nối bảng tiết học
    // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // @JoinTable(name = "schedule_period", joinColumns = @JoinColumn(
    // name = "schedule_id", referencedColumnName = "id")
    // , inverseJoinColumns = @JoinColumn(name = "period_id", referencedColumnName =
    // "id"))
    // private List<ScheduleTeacher> ScheduleTeacher_period = new ArrayList<>();

    // // kết nối với bảng phòng

    // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // @JoinTable(name = "schedule_room", joinColumns = @JoinColumn(
    // name = "schedule_id", referencedColumnName = "id")
    // , inverseJoinColumns = @JoinColumn(name = "room_id", referencedColumnName =
    // "id"))
    // private List<ScheduleTeacher> ScheduleTeacher_room = new ArrayList<>();

    // private Integer status;
}
