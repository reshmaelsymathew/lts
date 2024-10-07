package edu.uow.lts.ridebooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uow.lts.ridebooking.dto.ActionTypeCountDTO;
import edu.uow.lts.ridebooking.dto.ActionTypeEventDateDTO;
import edu.uow.lts.ridebooking.service.EventLogLtsService;


@RestController
@RequestMapping("/api/eventloglts")
public class EventLogLtsController {
	
	@Autowired
	private EventLogLtsService eventLogApService;
	
	@GetMapping("/countByActionType") // Added endpoint for clarity
    public List<ActionTypeCountDTO> getCountByActionType() {
        return eventLogApService.getCountByActionType(); // Return the result from service
    }
	
	 @GetMapping("/countByActionTypeAndEventDate") // New endpoint for action type and event date
	    public List<ActionTypeEventDateDTO> getCountByActionTypeAndEventDate() {
	        return eventLogApService.getCountByActionTypeAndEventDate(); // Return the service response
	    }

}
