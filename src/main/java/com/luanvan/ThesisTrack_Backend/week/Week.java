package com.luanvan.ThesisTrack_Backend.week;

import java.util.ArrayList;
import java.util.List;

// import org.hibernate.mapping.List;
import com.luanvan.ThesisTrack_Backend.week.Week;
import com.luanvan.ThesisTrack_Backend.day.Day;
import com.luanvan.ThesisTrack_Backend.semester.Semester;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
// bảng tuần có ngày bắt đầu và ngày kết thúc tuần có kết nối với bảng học kỳ

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


    // tạo bảng phụ tuần ngày
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "week_day", 
        joinColumns = @JoinColumn(name = "day_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "week_id", referencedColumnName = "id"))
    private List<Day> week = new ArrayList<>();

}
