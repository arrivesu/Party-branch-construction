package site.rainbowx.FinalBackEnd.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MeetingDTO {
    private Long id;
    private String title;
    private String type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private Long branchId;
    private String content;
}