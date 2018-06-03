package com.buzzmove.springtest.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.buzzmove.springtest.model.TaskManager;

public abstract class AdminBaseConfig {
	
	protected final String HOME = "home";
	protected final String TASK_FORM = "taskForm";
	protected final String NEW_TASK = "newTask";
	protected final String LIST_PAGE = "list";
	
	

	protected List<TaskManager> saveMock(TaskManager task){
		List<TaskManager> listTaskManager = new ArrayList<TaskManager>();
		boolean find=false;
		
		for(TaskManager bean:listTaskManager){
			if(task.getIdTask().equalsIgnoreCase(bean.getIdTask())){
				find = true;
			}
		}
		
		if(!find)listTaskManager.add(task);
		return listTaskManager;
	}
	
	protected TaskManager newTask(){
		return new TaskManager();
	}
	
	protected  List<TaskManager> initList(){
		List<TaskManager> list = new ArrayList<TaskManager>();
		list.add(new TaskManager("Mr.", "massimo", "sposato", "12/09/1973"));
		list.add(new TaskManager("Miss.", "Jhon", "Lendel","12/09/1973"));
		list.add(new TaskManager("Mrs.", "Math", "Lendel", "12/09/1973"));
		list.add(new TaskManager("Sr.", "Path", "Smith", "12/09/1973"));
		 
		return list;
	}
	
	protected  List<String> initListTitle(){
		List<String> list = new ArrayList<String>();
		list.add("Mr.");
		list.add("Miss.");
		list.add("Mrs.");
		list.add("Sr.");
		return list;
	}
	
	
	 
	
	protected TaskManager compileTask(	TaskManager    taskForm ){
		TaskManager task = new TaskManager(taskForm.getTitleCustomer(),taskForm.getFirstname(),taskForm.getLastname(),taskForm.getNotes());
		String idTask = taskForm.getTitleCustomer().trim()+taskForm.getFirstname().trim()+taskForm.getLastname().trim();
		task.setNotes(taskForm.getNotes());
		task.setIdTask(idTask);
		
		System.out.println(" Generete key for task id :" +idTask);
		return task;
	}
	
	/***
	 * 
	 * @param listTaskManager
	 * @param attribute
	 */
	protected void sorderByAttribut(List<TaskManager> listTaskManager, String attribute) {
		 
		if(attribute.equalsIgnoreCase("Firstname")){
		
			Collections.sort(listTaskManager, new Comparator<TaskManager>(){
			    public int compare(TaskManager s1, TaskManager s2) {
			        return new String(s1.getFirstname()).compareTo(new String(s2.getFirstname()));
			    }
			});
		}else if(attribute.equalsIgnoreCase("Lastname")){
			Collections.sort(listTaskManager, new Comparator<TaskManager>(){
			    public int compare(TaskManager s1, TaskManager s2) {
			        return new String(s1.getLastname()).compareTo(new String(s2.getLastname()));
			    }
			});
		}else if(attribute.equalsIgnoreCase("TitleCustomer")){
			Collections.sort(listTaskManager, new Comparator<TaskManager>(){
			    public int compare(TaskManager s1, TaskManager s2) {
			        return new String(s1.getTitleCustomer()).compareTo(new String(s2.getTitleCustomer()));
			    }
			});
		}else if(attribute.equalsIgnoreCase("ScheduledDate")){
			Collections.sort(listTaskManager, new Comparator<TaskManager>(){
			    public int compare(TaskManager s1, TaskManager s2) {
			        return new String(s1.getScheduledDate()).compareTo(new String(s2.getScheduledDate()));
			    }
			});
		}else{
			
			Collections.sort(listTaskManager, new Comparator<TaskManager>(){
			    public int compare(TaskManager s1, TaskManager s2) {
			        return new String(s1.getIdTask()).compareTo(new String(s2.getIdTask()));
			    }
			});
		}
		
		
		
		
    }
}
