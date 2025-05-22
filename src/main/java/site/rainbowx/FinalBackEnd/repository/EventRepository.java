package site.rainbowx.FinalBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.rainbowx.FinalBackEnd.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
