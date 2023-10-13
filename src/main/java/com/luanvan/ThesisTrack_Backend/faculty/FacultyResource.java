//  package com.luanvan.ThesisTrack_Backend.faculty;

//  import org.springframework.beans.factory.annotation.Autowired;
//  import org.springframework.http.HttpStatus;
//  import org.springframework.http.ResponseEntity;
//  import org.springframework.web.bind.annotation.*;

//  @RestController
//  @RequestMapping("api/v1/faculties")
//  public class FacultyResource {

//      @Autowired
//      private FacultyService facultyService;

//      @PostMapping
//      public ResponseEntity<String> addFaculty(@RequestBody Faculty faculty) {
//          facultyService.addFaculty(faculty);
//          return ResponseEntity.status(HttpStatus.CREATED).body("Faculty added successfully");
//      }
//  }

