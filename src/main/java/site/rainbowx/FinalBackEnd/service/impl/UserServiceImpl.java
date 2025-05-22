package site.rainbowx.FinalBackEnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import site.rainbowx.FinalBackEnd.dto.UserDTO;
import site.rainbowx.FinalBackEnd.entity.Branch;
import site.rainbowx.FinalBackEnd.entity.Role;
import site.rainbowx.FinalBackEnd.entity.User;
import site.rainbowx.FinalBackEnd.repository.BranchRepository;
import site.rainbowx.FinalBackEnd.repository.RoleRepository;
import site.rainbowx.FinalBackEnd.repository.UserRepository;
import site.rainbowx.FinalBackEnd.service.UserService;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private RoleRepository roleRepository;

    private UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setIsDeleted(user.getIsDeleted());
        dto.setEmail(user.getEmail());
        dto.setNickname(user.getNickname());
        dto.setFullName(user.getFullName());
        dto.setPassword(user.getPassword());
        dto.setAvatar(user.getAvatar());
        dto.setGender(user.getGender());
        dto.setEthnicity(user.getEthnicity());
        dto.setBirthDate(user.getBirthDate());
        dto.setStudentNumber(user.getStudentNumber());
        dto.setClassName(user.getClassName());
        dto.setJoinDate(user.getJoinDate());
        dto.setPartyPosition(user.getPartyPosition());
        dto.setIdentityType(user.getIdentityType());
        dto.setPhone(user.getPhone());
        dto.setProfileFile(user.getProfileFile());
        dto.setBranchId(user.getBranch() != null ? user.getBranch().getId() : null);
        dto.setRoleIds(user.getRoles() != null ? user.getRoles().stream().map(Role::getId).collect(Collectors.toSet()) : null);
        dto.setStatus(user.getStatus());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        dto.setLastLoginAt(user.getLastLoginAt());
        return dto;
    }

    private User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setIsDeleted(dto.getIsDeleted());
        user.setEmail(dto.getEmail());
        user.setNickname(dto.getNickname());
        user.setFullName(dto.getFullName());
        user.setPassword(dto.getPassword());
        user.setAvatar(dto.getAvatar());
        user.setGender(dto.getGender());
        user.setEthnicity(dto.getEthnicity());
        user.setBirthDate(dto.getBirthDate());
        user.setStudentNumber(dto.getStudentNumber());
        user.setClassName(dto.getClassName());
        user.setJoinDate(dto.getJoinDate());
        user.setPartyPosition(dto.getPartyPosition());
        user.setIdentityType(dto.getIdentityType());
        user.setPhone(dto.getPhone());
        user.setProfileFile(dto.getProfileFile());
        if (dto.getBranchId() != null) {
            Branch branch = branchRepository.findById(dto.getBranchId()).orElse(null);
            user.setBranch(branch);
        }
        if (dto.getRoleIds() != null) {
            Set<Role> roles = dto.getRoleIds().stream()
                    .map(roleRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toSet());
            user.setRoles(roles);
        }
        user.setStatus(dto.getStatus());
        user.setCreatedAt(dto.getCreatedAt());
        user.setUpdatedAt(dto.getUpdatedAt());
        user.setLastLoginAt(dto.getLastLoginAt());
        return user;
    }

    @Override
    public UserDTO create(UserDTO dto) {
        User user = toEntity(dto);
        return toDTO(userRepository.save(user));
    }

    @Override
    public UserDTO getById(Long id) {
        return userRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO update(Long id, UserDTO dto) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;
        user.setIsDeleted(dto.getIsDeleted());
        user.setNickname(dto.getNickname());
        user.setFullName(dto.getFullName());
        user.setPassword(dto.getPassword());
        user.setAvatar(dto.getAvatar());
        user.setGender(dto.getGender());
        user.setEthnicity(dto.getEthnicity());
        user.setBirthDate(dto.getBirthDate());
        user.setStudentNumber(dto.getStudentNumber());
        user.setClassName(dto.getClassName());
        user.setJoinDate(dto.getJoinDate());
        user.setPartyPosition(dto.getPartyPosition());
        user.setIdentityType(dto.getIdentityType());
        user.setPhone(dto.getPhone());
        user.setProfileFile(dto.getProfileFile());
        if (dto.getBranchId() != null) {
            Branch branch = branchRepository.findById(dto.getBranchId()).orElse(null);
            user.setBranch(branch);
        }
        if (dto.getRoleIds() != null) {
            Set<Role> roles = dto.getRoleIds().stream()
                    .map(roleRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toSet());
            user.setRoles(roles);
        }
        user.setStatus(dto.getStatus());
        user.setUpdatedAt(dto.getUpdatedAt());
        user.setLastLoginAt(dto.getLastLoginAt());
        return toDTO(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserInfo(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
