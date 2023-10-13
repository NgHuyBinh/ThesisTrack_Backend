package com.luanvan.ThesisTrack_Backend.week;

import java.time.DayOfWeek;
import java.time.LocalDate;

import com.luanvan.ThesisTrack_Backend.semester.Semester;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Week {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String week;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;



        // Getters and setters

        public Integer getId() {
            return id;
        }
    
        public void setId(Integer id) {
            this.id = id;

        }
    
        public String getWeek() {
            return week;
        }
    
        public void setWeek(String week) {
            this.week = week;
        }
    // ngày bắt đầu và ngày kết thúc để chia tuần cho phù hợp

    // @NotNull(message = "Không được để trống ngày")
    // private LocalDate date;  // Updated variable name to 'date'

    // @NotNull(message = "Không được để trống thứ trong tuần")
    // private DayOfWeek dayOfWeek;

    // // Getters and Setters for 'date' and 'dayOfWeek'
    // public void setDate(LocalDate date) {
    //     this.date = date;
    // }

    // public LocalDate getDate() {
    //     return this.date;
    // }

    // public void setDayOfWeek(DayOfWeek dayOfWeek) {
    //     this.dayOfWeek = dayOfWeek;
    // }

    // public DayOfWeek getDayOfWeek() {
    //     return this.dayOfWeek;
    // }
}
