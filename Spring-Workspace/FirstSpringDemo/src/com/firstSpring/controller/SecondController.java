package com.firstSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/greet")
public class SecondController {
	/*
	 * This class SecondController itself is annotated with a reqmapper param.
	 * So the url pattern should follow "/greet/index". So every method which
	 * handles a model in this class should follow the url patters as "/greet/*"
	 * So the below method helloworld will be accessed from
	 * "http://localhost:8080/FirstSpringDemo/greet/index"
	 */
	@RequestMapping("/index")
	public ModelAndView helloWorld() {
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage",
				"This is the second way of interpreting the controller with annotations");
		return modelAndView;
	}
}
