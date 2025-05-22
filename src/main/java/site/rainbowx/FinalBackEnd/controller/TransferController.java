package site.rainbowx.FinalBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.rainbowx.FinalBackEnd.dto.TransferDTO;
import site.rainbowx.FinalBackEnd.service.TransferService;

import java.util.List;

@RestController
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    private TransferService transferService;

    @PostMapping
    public TransferDTO create(@RequestBody TransferDTO dto) {
        return transferService.create(dto);
    }

    @GetMapping("/{id}")
    public TransferDTO getById(@PathVariable Long id) {
        return transferService.getById(id);
    }

    @GetMapping
    public List<TransferDTO> getAll() {
        return transferService.getAll();
    }

    @PutMapping("/{id}")
    public TransferDTO update(@PathVariable Long id, @RequestBody TransferDTO dto) {
        return transferService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        transferService.delete(id);
    }
}