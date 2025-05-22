package site.rainbowx.FinalBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.rainbowx.FinalBackEnd.dto.BranchDTO;
import site.rainbowx.FinalBackEnd.service.BranchService;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {
    @Autowired
    private BranchService branchService;

    @PostMapping
    public BranchDTO create(@RequestBody BranchDTO dto) {
        return branchService.create(dto);
    }

    @GetMapping("/{id}")
    public BranchDTO getById(@PathVariable Long id) {
        return branchService.getById(id);
    }

    @GetMapping
    public List<BranchDTO> getAll() {
        return branchService.getAll();
    }

    @PutMapping("/{id}")
    public BranchDTO update(@PathVariable Long id, @RequestBody BranchDTO dto) {
        return branchService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        branchService.delete(id);
    }
}