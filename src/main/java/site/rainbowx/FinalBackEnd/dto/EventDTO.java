package site.rainbowx.FinalBackEnd.dto;

import lombok.Data;
import site.rainbowx.FinalBackEnd.util.Status;
import java.time.LocalDateTime;

@Data
public class EventDTO {
    private Long id;
    private Long userId;
    private LocalDateTime time;
    private String module;
    private Status status;
    private String ip;
    private String target;
    private String content;
}