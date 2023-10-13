package com.luanvan.ThesisTrack_Backend.week;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/weeks")
public class WeekResource {

    @Autowired
    private WeekService weekService;

    @GetMapping
    public List<Week> getAllWeeks() {
        return weekService.getAllWeeks();
    }

    @GetMapping("/{id}")
    public Week getWeekById(@PathVariable Integer id) {
        return weekService.getWeekById(id);
    }

    @PostMapping
    public Week createWeek(@RequestBody Week week) {
        return weekService.createWeek(week);
    }

    @DeleteMapping("/{id}")
    public void deleteWeek(@PathVariable Integer id) {
        weekService.deleteWeek(id);
    }
}
