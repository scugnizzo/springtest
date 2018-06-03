package com.buzzmove.springtest.dao;

public enum TaskManagerMap implements EntityMap{
	ID_TASK("idTask","ID_TASK"),
	TITLE_CUSTOMER("titleCustomer","TITLE_CUSTOMER"),
	FIRSTNAME("firstname","FIRSTNAME"),
	LASTNAME("lastname","LASTNAME"),
	NOTES("notes","NOTES"),
	SCHEDULETED_DATE("scheduledDate","SCHEDULETED_DATE"),
	;
	  
	 

	private String databaseColumnName;
	private String entityColumnName;
	
	/***
	 * 
	 * @param entityColumnName
	 * @param databaseColumnName
	 */
	private TaskManagerMap(String entityColumnName, String databaseColumnName){
		this.databaseColumnName = databaseColumnName;
		this.entityColumnName = entityColumnName;
	}

	@Override
	public String getDatabaseColumnName(){
		return databaseColumnName;
	}

	@Override
	public String getEntityColumnName(){
		return entityColumnName;
	}

}
