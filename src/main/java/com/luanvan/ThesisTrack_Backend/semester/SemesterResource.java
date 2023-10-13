// package com.luanvan.ThesisTrack_Backend.semester;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("api/v1/semesters")
// public class SemesterResource {

//     @Autowired
//     private SemesterService semesterService;

//     @PostMapping
//     public ResponseEntity<Semester> createSemester(@RequestBody Semester semester) {
//         Semester createdSemester = semesterService.createSemester(semester);
//         return ResponseEntity.status(HttpStatus.CREATED).body(createdSemester);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Semester> getSemesterById(@PathVariable Long id) {
//         Semester semester = semesterService.getSemesterById(id);
//         if (semester != null) {
//             return ResponseEntity.status(HttpStatus.OK).body(semester);
//         } else {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//         }
//     }

//     @GetMapping("/academicYear/{academicYear}")
//     public ResponseEntity<Semester> getSemesterByAcademicYear(@PathVariable String academicYear) {
//         Semester semester = semesterService.getSemesterByAcademicYear(academicYear);
//         if (semester != null) {
//             return ResponseEntity.status(HttpStatus.OK).body(semester);
//         } else {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//         }
//     }
// }
