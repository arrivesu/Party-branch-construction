package site.rainbowx.FinalBackEnd.service;

import site.rainbowx.FinalBackEnd.dto.ActivityDTO;
import java.util.List;

public interface ActivityService {
    ActivityDTO create(ActivityDTO dto);
    ActivityDTO getById(Long id);
    List<ActivityDTO> getAll();
    ActivityDTO update(Long id, ActivityDTO dto);
    void delete(Long id);
}