package site.rainbowx.FinalBackEnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.rainbowx.FinalBackEnd.dto.UserDataDTO;
import site.rainbowx.FinalBackEnd.entity.User;
import site.rainbowx.FinalBackEnd.entity.UserData;
import site.rainbowx.FinalBackEnd.repository.UserDataRepository;
import site.rainbowx.FinalBackEnd.repository.UserRepository;
import site.rainbowx.FinalBackEnd.service.UserDataService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDataServiceImpl implements UserDataService {
    @Autowired
    private UserDataRepository userDataRepository;
    @Autowired
    private UserRepository userRepository;

    private UserDataDTO toDTO(UserData userData) {
        UserDataDTO dto = new UserDataDTO();
        dto.setId(userData.getId());
        dto.setUserId(userData.getUser() != null ? userData.getUser().getId() : null);
        dto.setRecordTime(userData.getRecordTime());
        dto.setMoralRank(userData.getMoralRank());
        dto.setAcademicRank(userData.getAcademicRank());
        dto.setAssessmentScore(userData.getAssessmentScore());
        dto.setDormScore(userData.getDormScore());
        dto.setBehaviorScore(userData.getBehaviorScore());
        dto.setPublicOpinionScore(userData.getPublicOpinionScore());
        return dto;
    }

    private UserData toEntity(UserDataDTO dto) {
        UserData userData = new UserData();
        userData.setId(dto.getId());
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId()).orElse(null);
            userData.setUser(user);
        }
        userData.setRecordTime(dto.getRecordTime());
        userData.setMoralRank(dto.getMoralRank());
        userData.setAcademicRank(dto.getAcademicRank());
        userData.setAssessmentScore(dto.getAssessmentScore());
        userData.setDormScore(dto.getDormScore());
        userData.setBehaviorScore(dto.getBehaviorScore());
        userData.setPublicOpinionScore(dto.getPublicOpinionScore());
        return userData;
    }

    @Override
    public UserDataDTO create(UserDataDTO dto) {
        UserData userData = toEntity(dto);
        return toDTO(userDataRepository.save(userData));
    }

    @Override
    public UserDataDTO getById(Long id) {
        return userDataRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<UserDataDTO> getAll() {
        return userDataRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDataDTO update(Long id, UserDataDTO dto) {
        UserData userData = userDataRepository.findById(id).orElse(null);
        if (userData == null) return null;
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId()).orElse(null);
            userData.setUser(user);
        }
        userData.setRecordTime(dto.getRecordTime());
        userData.setMoralRank(dto.getMoralRank());
        userData.setAcademicRank(dto.getAcademicRank());
        userData.setAssessmentScore(dto.getAssessmentScore());
        userData.setDormScore(dto.getDormScore());
        userData.setBehaviorScore(dto.getBehaviorScore());
        userData.setPublicOpinionScore(dto.getPublicOpinionScore());
        return toDTO(userDataRepository.save(userData));
    }

    @Override
    public void delete(Long id) {
        userDataRepository.deleteById(id);
    }
}