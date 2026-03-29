package com.example.sportevents.repository;

import com.example.sportevents.model.Event;
import com.example.sportevents.model.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    // FILTER BY SPORT
    List<Event> findBySport(String sport);

    // FILTER BY STATUS
    List<Event> findByStatus(EventStatus status);

    // FILTER BY SPORT + STATUS
    List<Event> findBySportAndStatus(String sport, EventStatus status);
}