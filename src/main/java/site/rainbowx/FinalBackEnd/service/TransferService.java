package site.rainbowx.FinalBackEnd.service;

import site.rainbowx.FinalBackEnd.dto.TransferDTO;
import java.util.List;

public interface TransferService {
    TransferDTO create(TransferDTO dto);
    TransferDTO getById(Long id);
    List<TransferDTO> getAll();
    TransferDTO update(Long id, TransferDTO dto);
    void delete(Long id);
}