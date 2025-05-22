package site.rainbowx.FinalBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.rainbowx.FinalBackEnd.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}