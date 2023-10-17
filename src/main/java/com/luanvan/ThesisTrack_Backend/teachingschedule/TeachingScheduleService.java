// package com.luanvan.ThesisTrack_Backend.teachingschedule;

// import java.util.List;
// // import java.util.Optional;

// // import org.hibernate.mapping.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.luanvan.ThesisTrack_Backend.subject.Subject;
// import com.luanvan.ThesisTrack_Backend.teacher.Teacher;

// @Service
// public class TeachingScheduleService {

//     @Autowired
//     private TeachingScheduleRepository teachingScheduleRepository;

//     public List<TeachingSchedule> getByTeacher(Teacher teacher) {
//         return teachingScheduleRepository.findByTeacher(teacher);
//     }

//     public List<TeachingSchedule> getBySubject(Subject subject) {
//         return teachingScheduleRepository.findBySubject(subject);
//     }

//     public List<TeachingSchedule> getAllTeachingSchedules() {
//         return teachingScheduleRepository.findAll();
//     }

// //    public TeachingSchedule addTeachingSchedule(TeachingRequestDTO teachingSchedule) {
// //        // Add custom validation for teachingSchedule if needed
// //        System.out.println(teachingSchedule.toString());
// //        return teachingScheduleRepository.save(teachingSchedule);
// //    }

//     public TeachingSchedule updateTeachingSchedule(TeachingSchedule teachingSchedule) {
//         // Check if the teaching schedule exists
//         if (!teachingScheduleRepository.existsById(teachingSchedule.getId())) {
//             throw new IllegalArgumentException("Không tìm thấy lịch giảng dạy có ID: " + teachingSchedule.getId());
//         }

//         // Update the teaching schedule
//         return teachingScheduleRepository.save(teachingSchedule);
//     }

//     public void deleteTeachingSchedule(Integer id) {
//         // Check if the teaching schedule exists
//         if (!teachingScheduleRepository.existsById(id)) {
//             throw new IllegalArgumentException("Không tìm thấy lịch giảng dạy có  ID: " + id);
//         }

//         // Delete the teaching schedule
//         teachingScheduleRepository.deleteById(id);
//     }

// }