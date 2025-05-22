package site.rainbowx.FinalBackEnd.entity;

import lombok.*;

import jakarta.persistence.*;
import site.rainbowx.FinalBackEnd.util.TransferStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transfer_data")
public class Transfer {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Branch targetOrganization;

    private String reason;

    private LocalDateTime applyDate;

    @Enumerated(EnumType.STRING)
    private TransferStatus status;
}
