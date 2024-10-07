package edu.uow.lts.ridebooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.uow.lts.ridebooking.entity.EventLogLts;

public interface EventLogRepository extends JpaRepository<EventLogLts, Long> {
	
	@Query("SELECT COUNT(e) AS count, e.actionType, e.eventDate FROM EventLogLts e GROUP BY e.actionType, e.eventDate")
	List<Object[]> getCountByActionTypeAndEventDate();

	@Query("SELECT COUNT(e) AS count, e.actionType FROM EventLogLts e GROUP BY e.actionType")
	List<Object[]> getCountByActionType();

}
