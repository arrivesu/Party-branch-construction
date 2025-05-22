package site.rainbowx.FinalBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.rainbowx.FinalBackEnd.dto.EventDTO;
import site.rainbowx.FinalBackEnd.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public List<EventDTO> getAll() {
        return eventService.getAll();
    }

    @PostMapping
    public EventDTO create(@RequestBody EventDTO dto) {
        return eventService.create(dto);
    }

    @PutMapping("/{id}")
    public EventDTO update(@PathVariable Long id, @RequestBody EventDTO dto) {
        return eventService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventService.delete(id);
    }

    @GetMapping("/{id}")
    public EventDTO getById(@PathVariable Long id) {
        return eventService.getById(id);
    }
}