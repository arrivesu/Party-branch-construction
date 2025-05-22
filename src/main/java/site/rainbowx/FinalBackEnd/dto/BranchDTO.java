package site.rainbowx.FinalBackEnd.dto;

import lombok.Data;

@Data
public class BranchDTO {
    private Long id;
    private String name;
    private String superiorOrg;
}