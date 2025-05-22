package site.rainbowx.FinalBackEnd.service;

import site.rainbowx.FinalBackEnd.dto.MaterialDTO;
import java.util.List;

public interface MaterialService {
    MaterialDTO create(MaterialDTO dto);
    MaterialDTO getById(Long id);
    List<MaterialDTO> getAll();
    MaterialDTO update(Long id, MaterialDTO dto);
    void delete(Long id);
}