package editors;

import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport  { 
	/*
	 * When a form is submitted and if we need the salutation to be associated
	 * with the name and user does not provide anything with the name we can set
	 * the default value along with the user's input.
	 */	@Override
	public void setAsText(String studentName) throws IllegalArgumentException {
	//checking if the user provided name has any salutation
		 if(studentName.contains("Mr.") || studentName.contains("Ms.")){
			setValue(studentName);
		}
		 //if not setting the salutation to Ms by default.
		else{
			studentName = "Ms."+studentName;
			setValue(studentName);
		}
		
	}

	
}
