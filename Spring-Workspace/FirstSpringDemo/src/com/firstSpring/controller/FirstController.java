/*package com.firstSpring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class FirstController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage", "Hi, this is my first spring mvc page");
		return modelAndView;
	}

}*/
//The above method is writing the controller class without using annotation.
//It can be written using annotations as well. Shown below.
package com.firstSpring.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
// the controller class itself can be annotated with a @requestMapping param.
// Check the secondController class for example.
public class FirstController {
	// Standard and basic way to handle the request from dispatcher servlet and
	// prepare the model.
	@RequestMapping("/index")
	public ModelAndView helloWorld() {
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage",
				"This is the second way of interpreting the controller with annotations");
		return modelAndView;
	}

	@RequestMapping("/welcome/{username}/{countryname}")
	public ModelAndView helloWorld(@PathVariable("username") String name, @PathVariable("countryname") String country) {
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage", "Hi, " + name + " welcome back! Logged in from " + country);
		return modelAndView;
	}

	// to bind all the params without specifying multiple parameters in the
	// method signature a map can be used.
	@RequestMapping("/{username}/{countryname}")
	public ModelAndView helloWorldMethod(@PathVariable Map<String, String> pathVars) {
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		String name = pathVars.get("username");
		String country = pathVars.get("countryname");
		modelAndView.addObject("welcomeMessage", "Hi, " + name + " welcome back! Logged in from " + country);
		return modelAndView;
	}
}