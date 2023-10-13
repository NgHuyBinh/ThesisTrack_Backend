package com.luanvan.ThesisTrack_Backend.registertopic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/registertopic")
public class RegisiterResource {
    @Autowired
    private RegisterService registerService;

    @PostMapping()
    public ResponseEntity<?> registerTopic(@Valid @RequestBody RegisterTopic registerTopic) {
        registerService.registerTopic(registerTopic);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}