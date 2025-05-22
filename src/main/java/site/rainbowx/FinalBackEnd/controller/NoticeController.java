package site.rainbowx.FinalBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.rainbowx.FinalBackEnd.dto.NoticeDTO;
import site.rainbowx.FinalBackEnd.service.NoticeService;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @PostMapping
    public NoticeDTO create(@RequestBody NoticeDTO dto) {
        return noticeService.create(dto);
    }

    @GetMapping("/{id}")
    public NoticeDTO getById(@PathVariable Long id) {
        return noticeService.getById(id);
    }

    @GetMapping
    public List<NoticeDTO> getAll() {
        return noticeService.getAll();
    }

    @PutMapping("/{id}")
    public NoticeDTO update(@PathVariable Long id, @RequestBody NoticeDTO dto) {
        return noticeService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        noticeService.delete(id);
    }
}