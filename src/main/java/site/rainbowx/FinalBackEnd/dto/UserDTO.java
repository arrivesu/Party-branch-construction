package site.rainbowx.FinalBackEnd.dto;

import lombok.Data;
import site.rainbowx.FinalBackEnd.util.IdentityType;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
public class UserDTO {
    private Long id;
    private Boolean isDeleted;
    private Boolean isInitPassword;
    private String email;
    private String nickname;
    private String fullName;
    private String password;
    private String avatar;
    private String gender;
    private String ethnicity;
    private LocalDateTime birthDate;
    private String studentNumber;
    private String className;
    private LocalDateTime joinDate;
    private String partyPosition;
    private IdentityType identityType;
    private String phone;
    private String profileFile;
    private Long branchId;
    private Set<Long> roleIds;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLoginAt;
}