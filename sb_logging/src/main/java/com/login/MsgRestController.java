package com.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {
	Logger logger=LoggerFactory.getLogger(MsgRestController.class);
	@GetMapping("/")
	public String msg()
	{
		logger.info("welcome msg started");
		try {
			int i=10/0;
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error("this is error message "+e.getMessage());
		}
		String msg="welcome ";
		logger.info("after message ended");;
		logger.warn("this is warning message");
		return "message response";
		
	}
}
