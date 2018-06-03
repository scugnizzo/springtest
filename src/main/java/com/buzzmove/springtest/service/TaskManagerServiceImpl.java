package com.buzzmove.springtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.buzzmove.springtest.dao.TaskManagerDAO;
import com.buzzmove.springtest.dao.TaskManagerDAOImpl;
import com.buzzmove.springtest.model.TaskManager;

 
 @Service
public class TaskManagerServiceImpl implements TaskManagerService{

	   
 
	
	public List<TaskManager> getAllTaskManager() {
		// TODO Auto-generated method stub
		System.out.println("getAllTaskManager");
		TaskManagerDAO dao= new TaskManagerDAOImpl();
		return dao.getAllTaskManager();
	}

	public TaskManager getTaskManagerById(String idTask) {
		System.out.println("getTaskManagerById");
		TaskManagerDAO dao= new TaskManagerDAOImpl();
		return dao.getTaskManagerById(idTask);
	}

	public int save(TaskManager task) {
		System.out.println("save");
		
		TaskManagerDAO dao = new TaskManagerDAOImpl();
		
		
		return dao.save(task);
	}

	public void delete(String idTask) {
		TaskManagerDAO dao = new TaskManagerDAOImpl();
		System.out.println("delete");
		dao.delete(idTask);
	}

	 
	public List<TaskManager> getAllTaskManageMockr() {
		System.out.println("getAllTaskManageMockr");
		TaskManagerDAO dao = new TaskManagerDAOImpl();
		return dao.getAllTaskManageMockr();
	}

	 
	public void update(TaskManager task) {
		
	}

	 
	public int rowCount(TaskManager task) {
		
		return 0;
	}

}
