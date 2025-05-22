package site.rainbowx.FinalBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.rainbowx.FinalBackEnd.dto.ActivityDTO;
import site.rainbowx.FinalBackEnd.service.ActivityService;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ActivityDTO create(@RequestBody ActivityDTO dto) {
        return activityService.create(dto);
    }

    @GetMapping
    public List<ActivityDTO> getAll() {
        return activityService.getAll();
    }

    @PutMapping("/{id}")
    public ActivityDTO update(@PathVariable Long id, @RequestBody ActivityDTO dto) {
        return activityService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        activityService.delete(id);
    }
}