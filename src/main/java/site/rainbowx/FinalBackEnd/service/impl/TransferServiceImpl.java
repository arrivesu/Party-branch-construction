package site.rainbowx.FinalBackEnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.rainbowx.FinalBackEnd.dto.TransferDTO;
import site.rainbowx.FinalBackEnd.entity.Branch;
import site.rainbowx.FinalBackEnd.entity.Transfer;
import site.rainbowx.FinalBackEnd.entity.User;
import site.rainbowx.FinalBackEnd.repository.BranchRepository;
import site.rainbowx.FinalBackEnd.repository.TransferRepository;
import site.rainbowx.FinalBackEnd.repository.UserRepository;
import site.rainbowx.FinalBackEnd.service.TransferService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BranchRepository branchRepository;

    private TransferDTO toDTO(Transfer transfer) {
        TransferDTO dto = new TransferDTO();
        dto.setId(transfer.getId());
        dto.setUserId(transfer.getUser() != null ? transfer.getUser().getId() : null);
        dto.setTargetOrganizationId(transfer.getTargetOrganization() != null ? transfer.getTargetOrganization().getId() : null);
        dto.setReason(transfer.getReason());
        dto.setApplyDate(transfer.getApplyDate());
        dto.setStatus(transfer.getStatus());
        return dto;
    }

    private Transfer toEntity(TransferDTO dto) {
        Transfer transfer = new Transfer();
        transfer.setId(dto.getId());
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId()).orElse(null);
            transfer.setUser(user);
        }
        if (dto.getTargetOrganizationId() != null) {
            Branch branch = branchRepository.findById(dto.getTargetOrganizationId()).orElse(null);
            transfer.setTargetOrganization(branch);
        }
        transfer.setReason(dto.getReason());
        transfer.setApplyDate(dto.getApplyDate());
        transfer.setStatus(dto.getStatus());
        return transfer;
    }

    @Override
    public TransferDTO create(TransferDTO dto) {
        Transfer transfer = toEntity(dto);
        return toDTO(transferRepository.save(transfer));
    }

    @Override
    public TransferDTO getById(Long id) {
        return transferRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<TransferDTO> getAll() {
        return transferRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public TransferDTO update(Long id, TransferDTO dto) {
        Transfer transfer = transferRepository.findById(id).orElse(null);
        if (transfer == null) return null;
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId()).orElse(null);
            transfer.setUser(user);
        }
        if (dto.getTargetOrganizationId() != null) {
            Branch branch = branchRepository.findById(dto.getTargetOrganizationId()).orElse(null);
            transfer.setTargetOrganization(branch);
        }
        transfer.setReason(dto.getReason());
        transfer.setApplyDate(dto.getApplyDate());
        transfer.setStatus(dto.getStatus());
        return toDTO(transferRepository.save(transfer));
    }

    @Override
    public void delete(Long id) {
        transferRepository.deleteById(id);
    }
}