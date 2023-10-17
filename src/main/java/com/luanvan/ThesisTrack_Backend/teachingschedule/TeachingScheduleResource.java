// package com.luanvan.ThesisTrack_Backend.teachingschedule;

// import com.luanvan.ThesisTrack_Backend.subject.Subject;
// import com.luanvan.ThesisTrack_Backend.subject.SubjectService;
// import com.luanvan.ThesisTrack_Backend.teacher.Teacher;
// import com.luanvan.ThesisTrack_Backend.teacher.TeacherService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("api/v1/teaching-schedule")
// public class TeachingScheduleResource {

//     @Autowired
//     private TeachingScheduleService teachingScheduleService;
//     @Autowired
//     private TeacherService teacherService;

//     @Autowired
//     private SubjectService subjectService;

//     @GetMapping("/by-teacher/{teacherId}")
//     public ResponseEntity<?> getByTeacher(@PathVariable Integer teacherId) {
//         Optional<Teacher> optionalTeacher = teacherService.getTeacherById(teacherId);
//         if (optionalTeacher.isPresent()) {
//             Teacher teacher = optionalTeacher.get();
//             List<TeachingSchedule> teachingSchedules = teachingScheduleService.getByTeacher(teacher);
//             return ResponseEntity.ok(teachingSchedules);
//         } else {
//             return ResponseEntity.badRequest().body("Không tìm thấy giảng viên.");
//         }
//     }

//     @GetMapping("/by-subject/{subjectId}")
//     public ResponseEntity<?> getBySubject(@PathVariable Integer subjectId) {
//         Optional<Subject> optionalSubject = subjectService.getSubjectById(subjectId);
//         if (optionalSubject.isPresent()) {
//             Subject subject = optionalSubject.get();
//             List<TeachingSchedule> teachingSchedules = teachingScheduleService.getBySubject(subject);
//             return ResponseEntity.ok(teachingSchedules);
//         } else {
//             return ResponseEntity.badRequest().body("Subject not found for the given ID.");
//         }
//     }

//     @GetMapping
//     public ResponseEntity<List<TeachingSchedule>> getAllTopics() {
//         List<TeachingSchedule> topics = teachingScheduleService.getAllTeachingSchedules();
//         return ResponseEntity.ok(topics);
//     }

// //    @PostMapping("/add")
// //    public ResponseEntity<?> addTeachingSchedule(@RequestBody TeachingRequestDTO teachingRequestDTO) {
// //
// ////        System.out.println(teachingRequestDTO.toString());
// //        TeachingSchedule savedTeachingSchedule = teachingScheduleService.addTeachingSchedule(teachingRequestDTO);
// //
// //        if (savedTeachingSchedule != null) {
// //            return ResponseEntity.ok("Đã thêm lịch thành công.");
// //        } else {
// //            return ResponseEntity.badRequest().body("Không thể thêm lịch được.");
// //        }
// //
// ////        return new ResponseEntity<>(HttpStatus.OK);
// //    }

//     @PutMapping("/update")
//     public ResponseEntity<?> updateTeachingSchedule(@RequestBody TeachingSchedule teachingSchedule) {
//         TeachingSchedule updatedTeachingSchedule = teachingScheduleService.updateTeachingSchedule(teachingSchedule);

//         if (updatedTeachingSchedule != null) {
//             return ResponseEntity.ok("Đã chỉnh sửa lịch thành công.");
//         } else {
//             return ResponseEntity.badRequest().body("Không thể chỉnh sửa lịch được.");
//         }
//     }

//     @DeleteMapping("/delete/{id}")
//     public ResponseEntity<?> deleteTeachingSchedule(@PathVariable Integer id) {
//         try {
//             teachingScheduleService.deleteTeachingSchedule(id);
//             return ResponseEntity.ok("Đã xóa lịch thành công.");
//         } catch (Exception e) {
//             return ResponseEntity.badRequest().body("Không thể xóa  được lịch này. Error: " + e.getMessage());
//         }
//     }
// }
