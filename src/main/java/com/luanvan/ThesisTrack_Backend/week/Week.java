package com.luanvan.ThesisTrack_Backend.week;

import com.luanvan.ThesisTrack_Backend.semester.Semester;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
// bảng tuần  có ngày bắt đầu và ngày kết thúc tuần có kết nối với bảng học kỳ

public class Week {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String startWeek;

    private String endWeek;

    // kết nối bảng học kỳ
    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;

}
