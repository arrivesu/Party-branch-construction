package site.rainbowx.FinalBackEnd.dto;

import lombok.Data;

@Data
public class ActivityJoinDTO {
    private Long id;
    private Long activityId;
    private Long memberId;
    private String status;
}