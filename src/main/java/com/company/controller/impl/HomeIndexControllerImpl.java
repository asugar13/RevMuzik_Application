package com.company.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = { "", "/" })
public class HomeIndexControllerImpl {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView formIndex() {
		ModelAndView modelAndView = new ModelAndView("HomeIndex");
		return modelAndView;
	}

}
