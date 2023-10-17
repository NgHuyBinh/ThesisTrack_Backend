// package com.luanvan.ThesisTrack_Backend.teachingschedule;

// import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.luanvan.ThesisTrack_Backend.subject.Subject;
// import com.luanvan.ThesisTrack_Backend.teacher.Teacher;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// // import jakarta.validation.constraints.NotNull;
// // import jakarta.persistence.OneToMany;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Entity

// public class TeachingSchedule {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer id;

//     // kết nối bảng giảng viên
//     @ManyToOne
//     @JoinColumn(name = "teacher_id")
//     // @JsonIgnore 
//     private Teacher teacher;

//     // kết nối bảng môn học
//     @ManyToOne
//     @JoinColumn(name = "subject_id")
//     private Subject subject;

// }
