package com.gontuseries.studentadmissioncontroller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
 
public class HobbyValidator implements ConstraintValidator<IsValidHobby, String> {
 
	private String listOfValidHobbes;
	
    @Override
    public void initialize(IsValidHobby isValidHobby) { 
    	this.listOfValidHobbes=isValidHobby.listOfValidHobbies();
    	
    }
 
    @Override
    public boolean isValid(String studentHobby, ConstraintValidatorContext ctx) {
        
    	if(studentHobby == null) {
    		
            return false;
        }
        
    	if (studentHobby.matches(listOfValidHobbes)) {
    		
    		return true;
    	} else {
    		
    		return false;
    	}
    }
 
}