package edu.uow.lts.ridebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uow.lts.ridebooking.entity.EventLog;

public interface EventLogRepository extends JpaRepository<EventLog, Long> {

}
