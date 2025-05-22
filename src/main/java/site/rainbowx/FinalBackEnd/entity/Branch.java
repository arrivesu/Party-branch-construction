package site.rainbowx.FinalBackEnd.entity;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String superiorOrg;
}
