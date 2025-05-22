package site.rainbowx.FinalBackEnd.service;

import site.rainbowx.FinalBackEnd.dto.BranchDTO;
import java.util.List;

public interface BranchService {
    BranchDTO create(BranchDTO dto);
    BranchDTO getById(Long id);
    List<BranchDTO> getAll();
    BranchDTO update(Long id, BranchDTO dto);
    void delete(Long id);
}