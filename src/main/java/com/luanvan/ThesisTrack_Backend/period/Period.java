package com.luanvan.ThesisTrack_Backend.period;

// import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.luanvan.ThesisTrack_Backend.day.Day;
import com.luanvan.ThesisTrack_Backend.role.Role;

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
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity

// bảng tiết học 
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Không được bỏ trống tiết học")
    private String period;

    @NotNull(message = "Không được để trống giờ bắt đầu tiết học")
    private String startPeriod;

    @NotNull(message = "Không được bỏ trống giờ kết thúc tiết học")
    private String endPeriod;

    @ManyToOne
    @JoinColumn(name = "day_id")
    private Day day;
}

