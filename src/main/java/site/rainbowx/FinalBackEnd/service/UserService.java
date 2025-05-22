package site.rainbowx.FinalBackEnd.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import site.rainbowx.FinalBackEnd.dto.UserDTO;
import site.rainbowx.FinalBackEnd.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDTO create(UserDTO dto);
    UserDTO getById(Long id);
    List<UserDTO> getAll();
    UserDTO update(Long id, UserDTO dto);
    void delete(Long id);
    public User getUserInfo(String username) throws UsernameNotFoundException;
}