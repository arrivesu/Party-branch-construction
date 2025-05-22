package site.rainbowx.FinalBackEnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.rainbowx.FinalBackEnd.dto.ActivityJoinDTO;
import site.rainbowx.FinalBackEnd.entity.Activity;
import site.rainbowx.FinalBackEnd.entity.ActivityJoin;
import site.rainbowx.FinalBackEnd.entity.User;
import site.rainbowx.FinalBackEnd.repository.ActivityJoinRepository;
import site.rainbowx.FinalBackEnd.repository.ActivityRepository;
import site.rainbowx.FinalBackEnd.repository.UserRepository;
import site.rainbowx.FinalBackEnd.service.ActivityJoinService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityJoinServiceImpl implements ActivityJoinService {
    @Autowired
    private ActivityJoinRepository activityJoinRepository;
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private UserRepository userRepository;

    private ActivityJoinDTO toDTO(ActivityJoin join) {
        ActivityJoinDTO dto = new ActivityJoinDTO();
        dto.setId(join.getId());
        dto.setActivityId(join.getActivity() != null ? join.getActivity().getId() : null);
        dto.setMemberId(join.getMember() != null ? join.getMember().getId() : null);
        dto.setStatus(join.getStatus());
        return dto;
    }

    private ActivityJoin toEntity(ActivityJoinDTO dto) {
        ActivityJoin join = new ActivityJoin();
        join.setId(dto.getId());
        if (dto.getActivityId() != null) {
            Activity activity = activityRepository.findById(dto.getActivityId()).orElse(null);
            join.setActivity(activity);
        }
        if (dto.getMemberId() != null) {
            User user = userRepository.findById(dto.getMemberId()).orElse(null);
            join.setMember(user);
        }
        join.setStatus(dto.getStatus());
        return join;
    }

    @Override
    public ActivityJoinDTO create(ActivityJoinDTO dto) {
        ActivityJoin join = toEntity(dto);
        return toDTO(activityJoinRepository.save(join));
    }

    @Override
    public ActivityJoinDTO getById(Long id) {
        return activityJoinRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<ActivityJoinDTO> getAll() {
        return activityJoinRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ActivityJoinDTO update(Long id, ActivityJoinDTO dto) {
        ActivityJoin join = activityJoinRepository.findById(id).orElse(null);
        if (join == null) return null;
        if (dto.getActivityId() != null) {
            Activity activity = activityRepository.findById(dto.getActivityId()).orElse(null);
            join.setActivity(activity);
        }
        if (dto.getMemberId() != null) {
            User user = userRepository.findById(dto.getMemberId()).orElse(null);
            join.setMember(user);
        }
        join.setStatus(dto.getStatus());
        return toDTO(activityJoinRepository.save(join));
    }

    @Override
    public void delete(Long id) {
        activityJoinRepository.deleteById(id);
    }
}