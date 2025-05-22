package site.rainbowx.FinalBackEnd.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ActivityDTO {
    private Long id;
    private String name;
    private String type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private String content;
    private String remark;
    private Long branchId;
}