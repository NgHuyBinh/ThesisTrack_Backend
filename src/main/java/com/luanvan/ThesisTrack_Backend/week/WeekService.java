package com.luanvan.ThesisTrack_Backend.week;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.LocalDate;


import java.util.List;

@Service
public class WeekService {


    @Autowired
    private WeekRepository weekRepository;

    public List<Week> getAllWeeks() {
        return weekRepository.findAll();
    }

    public Week getWeekById(Integer id) {
        return weekRepository.findById(id).orElse(null);
    }

    public Week createWeek(Week week) {
        return weekRepository.save(week);
    }

    public void deleteWeek(Integer id) {
        weekRepository.deleteById(id);
    }


//     @Autowired
//     private WeekRepository weekDayRepository;

//     public void saveWeekDaysForCurrentWeek() {
//         // Logic to calculate and save week days for the current week
//         LocalDate currentDate = LocalDate.now();

//         for (int i = 0; i < 7; i++) {
//             LocalDate day = currentDate.plusDays(i);
//             DayOfWeek dayOfWeek = day.getDayOfWeek();

//             Week weekDay = new Week();
//             weekDay.setDate(day);
//             weekDay.setDayOfWeek(dayOfWeek);

//             weekDayRepository.save(weekDay);
//         }
//     }

//     public List<Week> getAllWeekDays() {
//         return weekDayRepository.findAll();
//     }


}
