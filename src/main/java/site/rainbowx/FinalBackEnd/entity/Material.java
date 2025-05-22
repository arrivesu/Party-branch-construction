package site.rainbowx.FinalBackEnd.entity;

import lombok.*;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String type;

    private String category;

    @Lob
    private String content;

    private LocalDateTime uploadDate;

    @ManyToOne
    private Branch branch;
}

