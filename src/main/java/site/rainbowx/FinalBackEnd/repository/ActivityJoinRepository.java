package site.rainbowx.FinalBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.rainbowx.FinalBackEnd.entity.ActivityJoin;

@Repository
public interface ActivityJoinRepository extends JpaRepository<ActivityJoin, Long> {
}
