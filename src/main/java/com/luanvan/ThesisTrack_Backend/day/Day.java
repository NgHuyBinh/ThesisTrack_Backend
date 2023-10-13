package com.luanvan.ThesisTrack_Backend.day;

import java.util.ArrayList;
import java.util.List;

// import com.luanvan.ThesisTrack_Backend.role.Role;
import com.luanvan.ThesisTrack_Backend.week.Week;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

// bảng thứ trong tuần t2 t3 t4 t5  t6 t7 cn
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Không để trống thứ trong tuần")
    private String day;

    

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "day_week"
        ,joinColumns = @JoinColumn(name = "week_id",referencedColumnName = "id") 
        ,inverseJoinColumns  = @JoinColumn(name = "day_id",referencedColumnName = "id") 
    )
    private List<Week> week = new ArrayList<>();
}
