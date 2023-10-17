package com.luanvan.ThesisTrack_Backend.teacher;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// import com.luanvan.ThesisTrack_Backend.teacher.TeacherResponseDTO;

@RestController
@RequestMapping("api/v1/teacher")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:4401"})
public class TeacherResource {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<TeacherResponseDTO> getTeacherByNoTeacher(@RequestParam("numberTeacher") String numberTeacher){
        Optional<Teacher> teacher = teacherService.getTeacherByNoTeacher(numberTeacher);

        if(teacher.isPresent()){
            TeacherResponseDTO teacherResponseDTO = new TeacherResponseDTO(
            teacher.get().getId(),
            teacher.get().getNumberTeacher(),
            teacher.get().getName(),
            teacher.get().getAddress(),
            teacher.get().getEmail(),
            teacher.get().getPhone(),
            teacher.get().getMajor(),
            teacher.get().getBirthday(),
            teacher.get().getGender()
            );
            return ResponseEntity.status(HttpStatus.OK).body(teacherResponseDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Integer id) {
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        return teacher.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


}
