package site.rainbowx.FinalBackEnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.rainbowx.FinalBackEnd.dto.MaterialDTO;
import site.rainbowx.FinalBackEnd.entity.Branch;
import site.rainbowx.FinalBackEnd.entity.Material;
import site.rainbowx.FinalBackEnd.repository.BranchRepository;
import site.rainbowx.FinalBackEnd.repository.MaterialRepository;
import site.rainbowx.FinalBackEnd.service.MaterialService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private BranchRepository branchRepository;

    private MaterialDTO toDTO(Material material) {
        MaterialDTO dto = new MaterialDTO();
        dto.setId(material.getId());
        dto.setTitle(material.getTitle());
        dto.setType(material.getType());
        dto.setCategory(material.getCategory());
        dto.setContent(material.getContent());
        dto.setUploadDate(material.getUploadDate());
        dto.setBranchId(material.getBranch() != null ? material.getBranch().getId() : null);
        return dto;
    }

    private Material toEntity(MaterialDTO dto) {
        Material material = new Material();
        material.setId(dto.getId());
        material.setTitle(dto.getTitle());
        material.setType(dto.getType());
        material.setCategory(dto.getCategory());
        material.setContent(dto.getContent());
        material.setUploadDate(dto.getUploadDate());
        if (dto.getBranchId() != null) {
            Branch branch = branchRepository.findById(dto.getBranchId()).orElse(null);
            material.setBranch(branch);
        }
        return material;
    }

    @Override
    public MaterialDTO create(MaterialDTO dto) {
        Material material = toEntity(dto);
        return toDTO(materialRepository.save(material));
    }

    @Override
    public MaterialDTO getById(Long id) {
        return materialRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<MaterialDTO> getAll() {
        return materialRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public MaterialDTO update(Long id, MaterialDTO dto) {
        Material material = materialRepository.findById(id).orElse(null);
        if (material == null) return null;
        material.setTitle(dto.getTitle());
        material.setType(dto.getType());
        material.setCategory(dto.getCategory());
        material.setContent(dto.getContent());
        material.setUploadDate(dto.getUploadDate());
        if (dto.getBranchId() != null) {
            Branch branch = branchRepository.findById(dto.getBranchId()).orElse(null);
            material.setBranch(branch);
        }
        return toDTO(materialRepository.save(material));
    }

    @Override
    public void delete(Long id) {
        materialRepository.deleteById(id);
    }
}