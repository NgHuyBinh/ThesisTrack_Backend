//  package com.luanvan.ThesisTrack_Backend.faculty;

//  import org.springframework.beans.factory.annotation.Autowired;
//  import org.springframework.stereotype.Service;

//  // import com.luanvan.ThesisTrack_Backend.exception.FacultyCodeAlreadyExistsException;
//  @Service
//  public class FacultyService {
//      @Autowired
//      private FacultyRepository facultyRepository;

//      public void addFaculty(Faculty faculty) {
//          // Kiểm tra xem mã khoa đã tồn tại hay chưa
//          if (facultyRepository.existsByCode(faculty.getCode())) {
//          throw new IllegalArgumentException("Faculty with code " + faculty.getCode() +
//          " already exists");
//          }
//          // if (facultyRepository.existsByCode(faculty.getCode())) {
//          //     throw new FacultyCodeAlreadyExistsException("Faculty with code " + faculty.getCode() + " already exists");
//          // }

//          facultyRepository.save(faculty);
//      }
//  }