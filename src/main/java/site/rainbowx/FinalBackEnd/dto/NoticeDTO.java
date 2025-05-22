package site.rainbowx.FinalBackEnd.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class NoticeDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime publishDate;
    private Long publisherId;
}