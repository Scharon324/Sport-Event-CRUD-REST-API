package com.example.sportevents.controller;

import com.example.sportevents.model.Event;
import com.example.sportevents.model.EventStatus;
import com.example.sportevents.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // CREATE EVENT
    @PostMapping
    public Event createEvent(@Valid @RequestBody Event event) {
        return eventService.createEvent(event);

    //@PostMapping
    //public ResponseEntity<Event> createEvent(@Valid @RequestBody Event event) {
    //    return ResponseEntity.ok(eventService.createEvent(event));
    }

    // GET ALL EVENTS (with filters)
    @GetMapping
    public ResponseEntity<List<Event>> getEvents(
            @RequestParam(required = false) String sport,
            @RequestParam(required = false) EventStatus status) {
        return ResponseEntity.ok(eventService.getEvents(sport, status));
    }

    // GET EVENT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getById(id));
    }

    // CHANGE EVENT STATUS
    @PatchMapping("/{id}/status")
    public ResponseEntity<Event> changeStatus(
            @PathVariable Long id,
            @RequestParam EventStatus status) {
        return ResponseEntity.ok(eventService.changeStatus(id, status));
    }

    // UPDATE EVENT
    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @Valid @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    
    //@PutMapping("/{id}")
    //public ResponseEntity<Event> updateEvent(
    //        @PathVariable Long id,
    //        @Valid @RequestBody Event event) {
    //    return ResponseEntity.ok(eventService.updateEvent(id, event));
    }

    // DELETE EVENT
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok("Event deleted successfully");
    }
}