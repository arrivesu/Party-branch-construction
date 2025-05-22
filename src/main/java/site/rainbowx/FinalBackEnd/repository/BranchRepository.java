package site.rainbowx.FinalBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.rainbowx.FinalBackEnd.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
}
