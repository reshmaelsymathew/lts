package edu.uow.lts.ridebooking.service;

import java.util.List;

import edu.uow.lts.ridebooking.dto.ActionTypeCountDTO;
import edu.uow.lts.ridebooking.dto.ActionTypeEventDateDTO;


public interface EventLogLtsService {
	public List<ActionTypeCountDTO> getCountByActionType();
	
	public List<ActionTypeEventDateDTO> getCountByActionTypeAndEventDate();
	


}
