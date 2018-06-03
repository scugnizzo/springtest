package com.buzzmove.springtest.service;

import java.util.List;

import com.buzzmove.springtest.model.TaskManager;


public interface TaskManagerService {

	/**
	 * 
	 * @return
	 */
	  List<TaskManager> getAllTaskManageMockr();
	
	/**
	 * 
	 * @return
	 */
	  List<TaskManager> getAllTaskManager();
	
	/**
	 * 
	 * @param idTask
	 * @return
	 */
	  TaskManager getTaskManagerById(String idTask);
	
	/**
	 * 
	 * @param task
	 * @return
	 */
	  int  save(TaskManager task);
	
	/**
	 * 
	 * @param task
	 * @return
	 */
	  void update(TaskManager task);
	
	/**
	 * 
	 * @param task
	 * @return
	 */
	 void  delete(String idTask);
	  
	  /**
	   * 
	   * @param task
	   * @return
	   */
	  int rowCount (TaskManager task);

}
