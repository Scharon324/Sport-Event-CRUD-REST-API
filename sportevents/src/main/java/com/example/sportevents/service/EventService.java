package com.example.sportevents.service;

import com.example.sportevents.model.Event;
import com.example.sportevents.model.EventStatus;
import com.example.sportevents.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // CREATE EVENT
    public Event createEvent(Event event) {
        // Default status if not provided
        if (event.getStatus() == null) {
            event.setStatus(EventStatus.INACTIVE);
        }
        return eventRepository.save(event);
    }

    // GET ALL EVENTS WITH OPTIONAL FILTERS
    public List<Event> getEvents(String sport, EventStatus status) {

        if (sport != null && status != null) {
            return eventRepository.findBySportAndStatus(sport, status);
        }

        if (sport != null) {
            return eventRepository.findBySport(sport);
        }

        if (status != null) {
            return eventRepository.findByStatus(status);
        }

        return eventRepository.findAll();
    }

    // GET EVENT BY ID
    public Event getById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    // CHANGE STATUS
    public Event changeStatus(Long id, EventStatus status) {
        Event event = getById(id);
        event.setStatus(status);
        return eventRepository.save(event);
    }

    // UPDATE EVENT
    public Event updateEvent(Long id, Event updatedEvent) {
        Event event = getById(id);

        event.setName(updatedEvent.getName());
        event.setSport(updatedEvent.getSport());
        event.setStartTime(updatedEvent.getStartTime());

        return eventRepository.save(event);
    }

    // DELETE EVENT
    public void deleteEvent(Long id) {
        Event event = getById(id);
        eventRepository.delete(event);
    }
}