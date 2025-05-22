package site.rainbowx.FinalBackEnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.rainbowx.FinalBackEnd.dto.NoticeDTO;
import site.rainbowx.FinalBackEnd.entity.Notice;
import site.rainbowx.FinalBackEnd.entity.User;
import site.rainbowx.FinalBackEnd.repository.NoticeRepository;
import site.rainbowx.FinalBackEnd.repository.UserRepository;
import site.rainbowx.FinalBackEnd.service.NoticeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;
    @Autowired
    private UserRepository userRepository;

    private NoticeDTO toDTO(Notice notice) {
        NoticeDTO dto = new NoticeDTO();
        dto.setId(notice.getId());
        dto.setTitle(notice.getTitle());
        dto.setContent(notice.getContent());
        dto.setPublishDate(notice.getPublishDate());
        dto.setPublisherId(notice.getPublisher() != null ? notice.getPublisher().getId() : null);
        return dto;
    }

    private Notice toEntity(NoticeDTO dto) {
        Notice notice = new Notice();
        notice.setId(dto.getId());
        notice.setTitle(dto.getTitle());
        notice.setContent(dto.getContent());
        notice.setPublishDate(dto.getPublishDate());
        if (dto.getPublisherId() != null) {
            User publisher = userRepository.findById(dto.getPublisherId()).orElse(null);
            notice.setPublisher(publisher);
        }
        return notice;
    }

    @Override
    public NoticeDTO create(NoticeDTO dto) {
        Notice notice = toEntity(dto);
        return toDTO(noticeRepository.save(notice));
    }

    @Override
    public NoticeDTO getById(Long id) {
        return noticeRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<NoticeDTO> getAll() {
        return noticeRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public NoticeDTO update(Long id, NoticeDTO dto) {
        Notice notice = noticeRepository.findById(id).orElse(null);
        if (notice == null) return null;
        notice.setTitle(dto.getTitle());
        notice.setContent(dto.getContent());
        notice.setPublishDate(dto.getPublishDate());
        if (dto.getPublisherId() != null) {
            User publisher = userRepository.findById(dto.getPublisherId()).orElse(null);
            notice.setPublisher(publisher);
        }
        return toDTO(noticeRepository.save(notice));
    }

    @Override
    public void delete(Long id) {
        noticeRepository.deleteById(id);
    }
}