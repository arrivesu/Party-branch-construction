package site.rainbowx.FinalBackEnd.dto;

import lombok.Data;
import site.rainbowx.FinalBackEnd.entity.Role;
import site.rainbowx.FinalBackEnd.util.IdentityType;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class MemberDTO {
    private Long id;
    private Boolean is_deleted;
    private Boolean is_init_password;
    private String username;
    private String avatar;
    private String name;
    private String gender;
    private String ethnicity;
    private LocalDateTime birth_date;
    private String student_number;
    private String class_name;
    private LocalDateTime join_date;
    private String party_positon;
    private String identity_type;
    private String phone;
    private String profile;
    private BranchDTO branch;
    private List<RoleDTO> role;

    public UserDTO toUserDTO(List<Role> cur_roles) {
        UserDTO userDTO = new UserDTO();
        userDTO.setIsDeleted(is_deleted);
        userDTO.setIsInitPassword(is_init_password);
        userDTO.setEmail(username);
        userDTO.setAvatar(avatar);
        userDTO.setFullName(name);
        userDTO.setGender(gender);
        userDTO.setEthnicity(ethnicity);
        userDTO.setBirthDate(birth_date);
        userDTO.setStudentNumber(student_number);
        userDTO.setClassName(class_name);
        userDTO.setJoinDate(join_date);
        userDTO.setPartyPosition(party_positon);
        userDTO.setIdentityType(IdentityType.valueOf(identity_type));
        userDTO.setPhone(phone);
        userDTO.setProfileFile(profile);
        userDTO.setBranchId(branch.getId());

        Set<Long> roleIds = new HashSet<>();
        for (RoleDTO role_dto : role) {
            for(Role role : cur_roles) {
                if (role.getName().equals(role_dto.getRole())) {
                    roleIds.add(role.getId());
                    break;
                }
            }
        }
        userDTO.setRoleIds(roleIds);

        return userDTO;
    }

    public static MemberDTO fromUserDTO(UserDTO userDTO, BranchDTO branch, List<Role> cur_roles) {
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setIs_deleted(userDTO.getIsDeleted());
        memberDTO.setIs_init_password(userDTO.getIsInitPassword());
        memberDTO.setUsername(userDTO.getEmail());
        memberDTO.setAvatar(userDTO.getAvatar());
        memberDTO.setName(userDTO.getFullName());
        memberDTO.setGender(userDTO.getGender());
        memberDTO.setEthnicity(userDTO.getEthnicity());
        memberDTO.setBirth_date(userDTO.getBirthDate());
        memberDTO.setStudent_number(userDTO.getStudentNumber());
        memberDTO.setClass_name(userDTO.getClassName());
        memberDTO.setJoin_date(userDTO.getJoinDate());
        memberDTO.setParty_positon(userDTO.getPartyPosition());
        memberDTO.setIdentity_type(userDTO.getIdentityType().getChineseName());
        memberDTO.setPhone(userDTO.getPhone());
        memberDTO.setProfile(userDTO.getProfileFile());
        memberDTO.setBranch(branch);
        memberDTO.setRole(userDTO.getRoleIds().stream().map((Long id) -> RoleDTO.valueOf(cur_roles.get(Math.toIntExact(id)).getName())).toList());

        return memberDTO;
    }
}
