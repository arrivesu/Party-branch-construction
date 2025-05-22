package site.rainbowx.FinalBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.rainbowx.FinalBackEnd.dto.UserDataDTO;
import site.rainbowx.FinalBackEnd.service.UserDataService;

import java.util.List;

@RestController
@RequestMapping("/user/data")
public class UserDataController {
    @Autowired
    private UserDataService userDataService;

    @PostMapping
    public UserDataDTO create(@RequestBody UserDataDTO dto) {
        return userDataService.create(dto);
    }

    @GetMapping("/{id}")
    public UserDataDTO getById(@PathVariable Long id) {
        return userDataService.getById(id);
    }

    @GetMapping
    public List<UserDataDTO> getAll() {
        return userDataService.getAll();
    }

    @PutMapping("/{id}")
    public UserDataDTO update(@PathVariable Long id, @RequestBody UserDataDTO dto) {
        return userDataService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userDataService.delete(id);
    }
}