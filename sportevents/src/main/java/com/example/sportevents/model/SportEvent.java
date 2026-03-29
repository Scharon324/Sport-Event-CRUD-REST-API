package com.example.sportevents.model;
import java.time.LocalDateTime;

public class SportEvent {

    private Long id;
    private String name;
    private String sport;
    private EventStatus status;
    private LocalDateTime startTime;

    public SportEvent(Long id, String name, String sport, LocalDateTime startTime) {
        this.id = id;
        this.name = name;
        this.sport = sport;
        this.startTime = startTime;
        this.status = EventStatus.INACTIVE;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public String getSport() { return sport; }
    public EventStatus getStatus() { return status; }
    public void setStatus(EventStatus status) { this.status = status; }
    public LocalDateTime getStartTime() { return startTime; }
}
