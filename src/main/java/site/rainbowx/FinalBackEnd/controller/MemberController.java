package site.rainbowx.FinalBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.rainbowx.FinalBackEnd.dto.MemberDTO;
import site.rainbowx.FinalBackEnd.dto.UserDTO;
import site.rainbowx.FinalBackEnd.entity.Role;
import site.rainbowx.FinalBackEnd.repository.RoleRepository;
import site.rainbowx.FinalBackEnd.service.BranchService;
import site.rainbowx.FinalBackEnd.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BranchService branchService;

    @PostMapping
    public MemberDTO create(@RequestBody MemberDTO dto) {
        List<Role> roles = roleRepository.findAll();
        return MemberDTO.fromUserDTO(userService.create(dto.toUserDTO(roles)), dto.getBranch(), roles);
    }

    @GetMapping
    public List<MemberDTO> getAll() {
        List<MemberDTO> res = new ArrayList<>();
        List<UserDTO> users = userService.getAll();
        List<Role> roles = roleRepository.findAll();

        for(UserDTO user : users) {
            res.add(MemberDTO.fromUserDTO(user, branchService.getById(user.getBranchId()), roles));
        }

        return res;
    }

    @PutMapping("/{id}")
    public MemberDTO update(@PathVariable Long id, @RequestBody MemberDTO dto) {
        List<Role> roles = roleRepository.findAll();
        return MemberDTO.fromUserDTO(userService.update(id, dto.toUserDTO(roles)), dto.getBranch(), roles);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
