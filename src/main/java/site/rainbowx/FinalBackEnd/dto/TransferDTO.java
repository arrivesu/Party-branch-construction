package site.rainbowx.FinalBackEnd.dto;

import lombok.Data;
import site.rainbowx.FinalBackEnd.util.TransferStatus;
import java.time.LocalDateTime;

@Data
public class TransferDTO {
    private Long id;
    private Long userId;
    private Long targetOrganizationId;
    private String reason;
    private LocalDateTime applyDate;
    private TransferStatus status;
}