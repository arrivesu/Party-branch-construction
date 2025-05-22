package site.rainbowx.FinalBackEnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.rainbowx.FinalBackEnd.dto.BranchDTO;
import site.rainbowx.FinalBackEnd.entity.Branch;
import site.rainbowx.FinalBackEnd.repository.BranchRepository;
import site.rainbowx.FinalBackEnd.service.BranchService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchRepository branchRepository;

    private BranchDTO toDTO(Branch branch) {
        BranchDTO dto = new BranchDTO();
        dto.setId(branch.getId());
        dto.setName(branch.getName());
        dto.setSuperiorOrg(branch.getSuperiorOrg());
        return dto;
    }

    private Branch toEntity(BranchDTO dto) {
        Branch branch = new Branch();
        branch.setId(dto.getId());
        branch.setName(dto.getName());
        branch.setSuperiorOrg(dto.getSuperiorOrg());
        return branch;
    }

    @Override
    public BranchDTO create(BranchDTO dto) {
        Branch branch = toEntity(dto);
        return toDTO(branchRepository.save(branch));
    }

    @Override
    public BranchDTO getById(Long id) {
        return branchRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<BranchDTO> getAll() {
        return branchRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public BranchDTO update(Long id, BranchDTO dto) {
        Branch branch = branchRepository.findById(id).orElse(null);
        if (branch == null) return null;
        branch.setName(dto.getName());
        branch.setSuperiorOrg(dto.getSuperiorOrg());
        return toDTO(branchRepository.save(branch));
    }

    @Override
    public void delete(Long id) {
        branchRepository.deleteById(id);
    }
}