package com.example.sportevents.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Event name is required")
    private String name;

    @NotBlank(message = "Sport is required")
    private String sport;

    @NotNull(message = "Start time is required")
    @Future(message = "Start time must be in the future")
    private LocalDateTime startTime;

    @NotNull(message = "Status is required")
    @Enumerated(EnumType.STRING)
    private EventStatus status;

    public Event() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSport() { return sport; }
    public LocalDateTime getStartTime() { return startTime; }
    public EventStatus getStatus() { return status; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSport(String sport) { this.sport = sport; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public void setStatus(EventStatus status) { this.status = status; }
}