package site.rainbowx.FinalBackEnd.entity;

import lombok.*;

import jakarta.persistence.*;
import site.rainbowx.FinalBackEnd.util.Status;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    private LocalDateTime time;

    private String module;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String ip;

    private String target;

    @Lob
    private String content;
}
