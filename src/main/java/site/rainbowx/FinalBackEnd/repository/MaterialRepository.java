package site.rainbowx.FinalBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.rainbowx.FinalBackEnd.entity.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
}
