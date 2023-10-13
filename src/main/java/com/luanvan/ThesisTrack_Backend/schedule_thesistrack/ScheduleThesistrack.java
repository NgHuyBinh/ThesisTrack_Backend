// package com.luanvan.ThesisTrack_Backend.schedule_thesistrack;

// import java.util.ArrayList;
// import java.util.List;

// import com.luanvan.ThesisTrack_Backend.schedule_teacher.ScheduleTeacher;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.ManyToMany;
// // import jakarta.validation.constraints.NotNull;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Entity
// public class ScheduleThesistrack {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer id;

    
//     // // kết nối bảng week tạo ra bảng phụ cho thuộc tính nhiều nhiều
//     // // kết nối  bảng tuần
//     // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//     // @JoinTable(name = "schedule_week", joinColumns = @JoinColumn(name = "schedule_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "week_id", referencedColumnName = "id"))
//     // private List<ScheduleTeacher> ScheduleTeacher_week = new ArrayList<>();

//     // // kết nối bảng period và tạo bảng phụ  
//     // // kết nối bảng tiết học
//     // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//     // @JoinTable(name = "schedule_period", joinColumns = @JoinColumn(
//     //     name = "schedule_id", referencedColumnName = "id")
//     //     , inverseJoinColumns = @JoinColumn(name = "period_id", referencedColumnName = "id"))
//     // private List<ScheduleTeacher> ScheduleTeacher_period = new ArrayList<>();


//     // // kết nối với bảng phòng 
    
//     // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//     // @JoinTable(name = "schedule_room", joinColumns = @JoinColumn(
//      //     name = "schedule_id", referencedColumnName = "id")
//     //     , inverseJoinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"))
//     // private List<ScheduleTeacher> ScheduleTeacher_room = new ArrayList<>();


//     // private Integer status;

// }
