package site.rainbowx.FinalBackEnd.entity;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "activity_join")
public class ActivityJoin {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Activity activity;

    @ManyToOne
    private User member;

    private String status;
}
