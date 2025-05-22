package site.rainbowx.FinalBackEnd.entity;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user_data")
public class UserData {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    private String recordTime;

    private Double moralRank;

    private Double academicRank;

    private Double assessmentScore;

    private Double dormScore;

    private Double behaviorScore;

    private Double publicOpinionScore;
}

