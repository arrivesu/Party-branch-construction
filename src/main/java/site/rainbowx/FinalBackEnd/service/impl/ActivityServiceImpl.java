package site.rainbowx.FinalBackEnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.rainbowx.FinalBackEnd.dto.ActivityDTO;
import site.rainbowx.FinalBackEnd.entity.Activity;
import site.rainbowx.FinalBackEnd.entity.Branch;
import site.rainbowx.FinalBackEnd.repository.ActivityRepository;
import site.rainbowx.FinalBackEnd.repository.BranchRepository;
import site.rainbowx.FinalBackEnd.service.ActivityService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private BranchRepository branchRepository;

    private ActivityDTO toDTO(Activity activity) {
        ActivityDTO dto = new ActivityDTO();
        dto.setId(activity.getId());
        dto.setName(activity.getName());
        dto.setType(activity.getType());
        dto.setStartTime(activity.getStartTime());
        dto.setEndTime(activity.getEndTime());
        dto.setLocation(activity.getLocation());
        dto.setContent(activity.getContent());
        dto.setRemark(activity.getRemark());
        dto.setBranchId(activity.getBranch() != null ? activity.getBranch().getId() : null);
        return dto;
    }

    private Activity toEntity(ActivityDTO dto) {
        Activity activity = new Activity();
        activity.setId(dto.getId());
        activity.setName(dto.getName());
        activity.setType(dto.getType());
        activity.setStartTime(dto.getStartTime());
        activity.setEndTime(dto.getEndTime());
        activity.setLocation(dto.getLocation());
        activity.setContent(dto.getContent());
        activity.setRemark(dto.getRemark());
        if (dto.getBranchId() != null) {
            Branch branch = branchRepository.findById(dto.getBranchId()).orElse(null);
            activity.setBranch(branch);
        }
        return activity;
    }

    @Override
    public ActivityDTO create(ActivityDTO dto) {
        Activity activity = toEntity(dto);
        return toDTO(activityRepository.save(activity));
    }

    @Override
    public ActivityDTO getById(Long id) {
        return activityRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<ActivityDTO> getAll() {
        return activityRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ActivityDTO update(Long id, ActivityDTO dto) {
        Activity activity = activityRepository.findById(id).orElse(null);
        if (activity == null) return null;
        activity.setName(dto.getName());
        activity.setType(dto.getType());
        activity.setStartTime(dto.getStartTime());
        activity.setEndTime(dto.getEndTime());
        activity.setLocation(dto.getLocation());
        activity.setContent(dto.getContent());
        activity.setRemark(dto.getRemark());
        if (dto.getBranchId() != null) {
            Branch branch = branchRepository.findById(dto.getBranchId()).orElse(null);
            activity.setBranch(branch);
        }
        return toDTO(activityRepository.save(activity));
    }

    @Override
    public void delete(Long id) {
        activityRepository.deleteById(id);
    }
}