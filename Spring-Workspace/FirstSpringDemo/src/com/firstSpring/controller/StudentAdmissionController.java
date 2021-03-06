package com.firstSpring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beans.Student;
import editors.StudentNameEditor;

@Controller
public class StudentAdmissionController {
	
	@InitBinder
	public void intiBinder(WebDataBinder dataBinder){
		dataBinder.setDisallowedFields(new String[] {"mobileNo"});
		SimpleDateFormat format =new SimpleDateFormat("MM-dd-yyyy");
		dataBinder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(format, false));
		//User defined custom name editor.
		dataBinder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}
	
	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
		return modelAndView;
	}

	@ModelAttribute
	public void addingCommonValues(Model m) {
		m.addAttribute("common", "This message should be in all the pages. No matter What!");
	}

	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	// the request param values are taken from the UI from the elements with the
	// name attributes and if the user did not provide the values the default
	// values are printed
	public ModelAndView submitAdmissionForm(@RequestParam(value = "studentName", defaultValue = "Admin") String name,
			@RequestParam("studentHobby") String hobby) {
		ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
		modelAndView.addObject("msg", "Details submitted by " + name + " and the hobby :" + hobby);
		modelAndView.addObject("name", name);
		return modelAndView;
	}
	/*
	 * //If there are multiple req params we can use a map to store and retrieve
	 * all the params
	 * 
	 * @RequestMapping(value = "/submitAdmissionForm.html", method =
	 * RequestMethod.POST) public ModelAndView submitMethod(@RequestParam
	 * Map<String, String> reqParams ) { ModelAndView modelAndView = new
	 * ModelAndView("AdmissionSuccess"); String name =
	 * reqParams.get("studentName"); String hobby =
	 * reqParams.get("studentHobby"); modelAndView.addObject("msg",
	 * "Details submitted by "+name+" and the hobby :"+ hobby );
	 * modelAndView.addObject("name", name ); return modelAndView; }
	 */

	/*
	 * @RequestMapping(value = "/submitAdmissionForm1.html", method =
	 * RequestMethod.POST) public ModelAndView submitMethod1(@RequestParam
	 * Map<String, String> reqParams ) { ModelAndView modelAndView = new
	 * ModelAndView("AdmissionSuccess"); Student student = new Student();
	 * student.setStudentName(reqParams.get("studentName"));
	 * student.setStudentHobby(reqParams.get("studentHobby"));
	 * modelAndView.addObject("msg",
	 * "Displaying with the help of student bean object and Form 1" );
	 * modelAndView.addObject("student", student ); return modelAndView; }
	 */
	// The above method can be simplified by using @ModelAttribute annotation.
	@RequestMapping(value = "/submitAdmissionForm1.html", method = RequestMethod.POST)
	public ModelAndView submitMethod1(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		/*
		 * Here the @ModelAttribute maps the values from the UI i.e. the values
		 * of studentName and studentHobby to the corresponding values of the
		 * the bean class Student. For doing so the declaration of both the
		 * variable much match the bean class with the jsp variable values.
		 * studentName in bean matches studentName in admissionForm.jsp The
		 * parameter BindingResult is helpful in detecting the errors when user
		 * provides a wrong value in any of the fileds. The error might be
		 * syntactically wrong like string passed where mobile number (int)
		 * accepts only integers.
		 */
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("AdmissionForm");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
		modelAndView.addObject("msg", "Displaying with the help of student bean object and Form 1");
		return modelAndView;
	}
}
