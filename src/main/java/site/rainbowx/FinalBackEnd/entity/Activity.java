package site.rainbowx.FinalBackEnd.entity;

import lombok.*;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String type;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String location;

    @Lob
    private String content;

    private String remark;

    @ManyToOne
    private Branch branch;
}

