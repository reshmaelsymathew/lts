package edu.uow.lts.ridebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uow.lts.ridebooking.entity.EventLogLts;

public interface EventLogRepository extends JpaRepository<EventLogLts, Long> {

}
