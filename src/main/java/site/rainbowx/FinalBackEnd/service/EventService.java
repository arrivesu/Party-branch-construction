package site.rainbowx.FinalBackEnd.service;

import site.rainbowx.FinalBackEnd.dto.EventDTO;
import java.util.List;

public interface EventService {
    EventDTO create(EventDTO dto);
    EventDTO getById(Long id);
    List<EventDTO> getAll();
    EventDTO update(Long id, EventDTO dto);
    void delete(Long id);
}