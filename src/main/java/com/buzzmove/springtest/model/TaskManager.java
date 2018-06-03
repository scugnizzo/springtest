package com.buzzmove.springtest.model;

import java.io.Serializable;
import java.util.Date;

public class TaskManager implements Serializable{
	private static final long serialVersionUID = 1L;

	public TaskManager(){}
	public TaskManager(String titleCustomer, String firstname,  String lastname, String scheduledDate){
		this.titleCustomer = titleCustomer;
		this.scheduledDate = scheduledDate;
		this.firstname = firstname;
		this.lastname = lastname;
		this.idTask = titleCustomer.trim() + firstname.trim() + lastname.trim() + scheduledDate.trim();
	}
	
	//The title of the customer e.g Mr, Mrs, Miss
	private String idTask;
	
	//The title of the customer e.g Mr, Mrs, Miss
	private String titleCustomer;
	
	//First Name of customer 
	private String firstname;
	
	//Last Name of customer
	private String lastname;
	
	 
	//Scheduled Date - Mandatory
	private String scheduledDate;
	
	private String notes;
	
	//private Address addressLine;
//	public Address getAddressLine() {
//		return addressLine;
//	}
//
//	public void setAddressLine(Address addressLine) {
//		this.addressLine = addressLine;
//	}

	public String getTitleCustomer() {
		return titleCustomer;
	}

	public void setTitleCustomer(String titleCustomer) {
		this.titleCustomer = titleCustomer;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	 

	public String getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}


	public String getIdTask() {
		return idTask;
	}

	public void setIdTask(String idTask) {
		this.idTask = idTask;
	}

	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((idTask == null) ? 0 : idTask.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result
				+ ((scheduledDate == null) ? 0 : scheduledDate.hashCode());
		result = prime * result
				+ ((titleCustomer == null) ? 0 : titleCustomer.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskManager other = (TaskManager) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (idTask == null) {
			if (other.idTask != null)
				return false;
		} else if (!idTask.equals(other.idTask))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (scheduledDate == null) {
			if (other.scheduledDate != null)
				return false;
		} else if (!scheduledDate.equals(other.scheduledDate))
			return false;
		if (titleCustomer == null) {
			if (other.titleCustomer != null)
				return false;
		} else if (!titleCustomer.equals(other.titleCustomer))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TaskManager [idTask=" + idTask + ", titleCustomer="
				+ titleCustomer + ", firstname=" + firstname + ", lastname="
				+ lastname + ", scheduledDate=" + scheduledDate + ", notes="
				+ notes + "]";
	}
	
	
	 

}
