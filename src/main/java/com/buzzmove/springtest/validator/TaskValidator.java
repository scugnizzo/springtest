package com.buzzmove.springtest.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.buzzmove.springtest.model.TaskManager;

@Component
public class TaskValidator implements Validator {

	public boolean supports(Class<?> clazz) {
	      return TaskManager.class.equals(clazz);
	   }

	public void validate(Object target, Errors errors) {
	      
	      TaskManager objTask = (TaskManager) target;

	       
	      if (!isTitleObj(objTask.getTitleCustomer())) {
	    	  errors.rejectValue("titleCustomer", "required.title");
	      }
	      
	      if (!isValidateObj(objTask.getLastname())) {
	     	  errors.rejectValue("lastname", "required.lastname");
	      }
	      
	      if (!isValidateObj(objTask.getFirstname())) {
	    	  errors.rejectValue("firstname", "required.firstname");
	      }
	      
	      if(objTask.getScheduledDate()==null){
	    	  errors.rejectValue("scheduledDate", "required.scheduledDate");
		  }
	   }
	
	
	private boolean isValidateObj(String obj){
		return((obj!=null) && (!obj.equalsIgnoreCase("")))? true : false;
	}
	
	private boolean isTitleObj(String obj){
		return((obj!=null) && (!obj.equalsIgnoreCase("")))? true : false;
	}
	
	 

}
