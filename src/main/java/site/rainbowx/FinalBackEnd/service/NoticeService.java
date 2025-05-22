package site.rainbowx.FinalBackEnd.service;

import site.rainbowx.FinalBackEnd.dto.NoticeDTO;
import java.util.List;

public interface NoticeService {
    NoticeDTO create(NoticeDTO dto);
    NoticeDTO getById(Long id);
    List<NoticeDTO> getAll();
    NoticeDTO update(Long id, NoticeDTO dto);
    void delete(Long id);
}