package site.rainbowx.FinalBackEnd.entity;

import lombok.*;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "notice")
public class Notice {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

    private LocalDateTime publishDate;

    @ManyToOne
    private User publisher;
}

