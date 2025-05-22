package site.rainbowx.FinalBackEnd.dto;

import lombok.Data;

@Data
public class UserDataDTO {
    private Long id;
    private Long userId;
    private String recordTime;
    private Double moralRank;
    private Double academicRank;
    private Double assessmentScore;
    private Double dormScore;
    private Double behaviorScore;
    private Double publicOpinionScore;
}