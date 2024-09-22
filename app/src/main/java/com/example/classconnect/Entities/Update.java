package com.example.classconnect.Entities;

import java.time.LocalDate;

public class Update {
    private String title;
    private LocalDate date;
    private String details;
    private int updateNumber;

    public Update(String title, LocalDate date, String details, int updateNumber){
        this.title = title;
        this.date = date;
        this.details = details;
        this.updateNumber = updateNumber;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDetails() {
        return details;
    }
}
