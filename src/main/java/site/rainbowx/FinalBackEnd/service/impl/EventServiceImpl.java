package site.rainbowx.FinalBackEnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.rainbowx.FinalBackEnd.dto.EventDTO;
import site.rainbowx.FinalBackEnd.entity.Event;
import site.rainbowx.FinalBackEnd.entity.User;
import site.rainbowx.FinalBackEnd.repository.EventRepository;
import site.rainbowx.FinalBackEnd.repository.UserRepository;
import site.rainbowx.FinalBackEnd.service.EventService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;

    private EventDTO toDTO(Event event) {
        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setUserId(event.getUser() != null ? event.getUser().getId() : null);
        dto.setTime(event.getTime());
        dto.setModule(event.getModule());
        dto.setStatus(event.getStatus());
        dto.setIp(event.getIp());
        dto.setTarget(event.getTarget());
        dto.setContent(event.getContent());
        return dto;
    }

    private Event toEntity(EventDTO dto) {
        Event event = new Event();
        event.setId(dto.getId());
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId()).orElse(null);
            event.setUser(user);
        }
        event.setTime(dto.getTime());
        event.setModule(dto.getModule());
        event.setStatus(dto.getStatus());
        event.setIp(dto.getIp());
        event.setTarget(dto.getTarget());
        event.setContent(dto.getContent());
        return event;
    }

    @Override
    public EventDTO create(EventDTO dto) {
        Event event = toEntity(dto);
        return toDTO(eventRepository.save(event));
    }

    @Override
    public EventDTO getById(Long id) {
        return eventRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<EventDTO> getAll() {
        return eventRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public EventDTO update(Long id, EventDTO dto) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event == null) return null;
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId()).orElse(null);
            event.setUser(user);
        }
        event.setTime(dto.getTime());
        event.setModule(dto.getModule());
        event.setStatus(dto.getStatus());
        event.setIp(dto.getIp());
        event.setTarget(dto.getTarget());
        event.setContent(dto.getContent());
        return toDTO(eventRepository.save(event));
    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}