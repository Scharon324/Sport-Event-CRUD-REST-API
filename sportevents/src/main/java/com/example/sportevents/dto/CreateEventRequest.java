package com.example.sportevents.dto;
import java.time.LocalDateTime;

public class CreateEventRequest {
    private String name;
    private String sport;
    private LocalDateTime startTime;

    public String getName() { return name; }
    public String getSport() { return sport; }
    public LocalDateTime getStartTime() { return startTime; }
}
