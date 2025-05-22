package site.rainbowx.FinalBackEnd.service;

import site.rainbowx.FinalBackEnd.dto.UserDataDTO;
import java.util.List;

public interface UserDataService {
    UserDataDTO create(UserDataDTO dto);
    UserDataDTO getById(Long id);
    List<UserDataDTO> getAll();
    UserDataDTO update(Long id, UserDataDTO dto);
    void delete(Long id);
}