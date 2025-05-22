package site.rainbowx.FinalBackEnd.service;

import site.rainbowx.FinalBackEnd.dto.ActivityJoinDTO;
import java.util.List;

public interface ActivityJoinService {
    ActivityJoinDTO create(ActivityJoinDTO dto);
    ActivityJoinDTO getById(Long id);
    List<ActivityJoinDTO> getAll();
    ActivityJoinDTO update(Long id, ActivityJoinDTO dto);
    void delete(Long id);
}