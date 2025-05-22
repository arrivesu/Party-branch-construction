package site.rainbowx.FinalBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.rainbowx.FinalBackEnd.dto.MaterialDTO;
import site.rainbowx.FinalBackEnd.service.MaterialService;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @PostMapping
    public MaterialDTO create(@RequestBody MaterialDTO dto) {
        return materialService.create(dto);
    }

    @GetMapping("/{id}")
    public MaterialDTO getById(@PathVariable Long id) {
        return materialService.getById(id);
    }

    @GetMapping
    public List<MaterialDTO> getAll() {
        return materialService.getAll();
    }

    @PutMapping("/{id}")
    public MaterialDTO update(@PathVariable Long id, @RequestBody MaterialDTO dto) {
        return materialService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        materialService.delete(id);
    }
}