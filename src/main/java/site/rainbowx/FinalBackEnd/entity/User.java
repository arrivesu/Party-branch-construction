package site.rainbowx.FinalBackEnd.entity;

import lombok.*;

import java.util.*;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import site.rainbowx.FinalBackEnd.util.IdentityType;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "is_deleted")    // 是否已经被软删除
    private Boolean isDeleted;

    @Column(name = "is_init_password")    // 是否是首次登陆
    private Boolean isInitPassword;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "nickname", length = 255)
    private String nickname;

    @Column(name = "full_name", length = 255)
    private String fullName;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "gender", length = 10)
    private String gender; // 可改为 enum Gender { 男, 女 }

    @Column(name = "ethnicity")
    private String ethnicity;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "student_number", length = 50)
    private String studentNumber;

    @Column(name = "class_name", length = 100)
    private String className;

    @Column(name = "join_date")
    private LocalDateTime joinDate;

    @Column(name = "party_position")
    private String partyPosition;

    @Enumerated(EnumType.STRING)
    @Column(name = "identity_type")
    private IdentityType identityType;

    @Column(name = "phone", length = 30)
    private String phone;

    @Column(name = "profile_file")
    private String profileFile;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    @Column(name = "last_login_ip", columnDefinition = "varbinary(32)") // 考虑到现在IP占用最大的是ipv6, 占16个字节, 32字节已经足够
    private byte[] lastLoginIp;

    @PrePersist  // 在插入数据前设置创建时间
    protected void onCreate() {
        if (this.isDeleted == null) {
            this.isDeleted = false;
        }
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate  // 在更新数据前设置更新时间
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Spring Security 方法实现
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return !Boolean.TRUE.equals(isDeleted);
    }
}
