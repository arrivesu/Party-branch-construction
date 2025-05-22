package site.rainbowx.FinalBackEnd.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MaterialDTO {
    private Long id;
    private String title;
    private String type;
    private String category;
    private String content;
    private LocalDateTime uploadDate;
    private Long branchId;
}