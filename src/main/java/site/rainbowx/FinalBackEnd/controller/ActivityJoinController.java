package site.rainbowx.FinalBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.rainbowx.FinalBackEnd.dto.ActivityJoinDTO;
import site.rainbowx.FinalBackEnd.service.ActivityJoinService;

import java.util.List;

@RestController
@RequestMapping("/activity/join")
public class ActivityJoinController {
    @Autowired
    private ActivityJoinService activityJoinService;

    @PostMapping
    public ActivityJoinDTO create(@RequestBody ActivityJoinDTO dto) {
        return activityJoinService.create(dto);
    }

    @GetMapping("/{id}")
    public ActivityJoinDTO getById(@PathVariable Long id) {
        return activityJoinService.getById(id);
    }

    @GetMapping
    public List<ActivityJoinDTO> getAll() {
        return activityJoinService.getAll();
    }

    @PutMapping("/{id}")
    public ActivityJoinDTO update(@PathVariable Long id, @RequestBody ActivityJoinDTO dto) {
        return activityJoinService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        activityJoinService.delete(id);
    }
}