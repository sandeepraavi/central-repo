package com.gontuseries.studentadmissioncontroller;

import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport {

	// When you will submit the admission form --> 
	// Spring MVC will run setAsTExt function of this class -->
	// Before performing data binding task for studentName property of student object
	
	@Override
	public void setAsText(String studentName)throws IllegalArgumentException {
				
		if(studentName.contains("Mr.") || studentName.contains("Ms.")) {

			setValue(studentName);
		
		} else {

			studentName = "Ms."+studentName;
			
			setValue(studentName);  // Whatever value you will provide to setValue --- spring MVC will use the
									// same value to perform data binding task for studentName property
		}
	}

}