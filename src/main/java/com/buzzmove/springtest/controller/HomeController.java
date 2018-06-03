package com.buzzmove.springtest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.buzzmove.springtest.DBUtils.DBConnectionUtil;
import com.buzzmove.springtest.dao.TaskManagerDAO;
import com.buzzmove.springtest.model.TaskManager;
import com.buzzmove.springtest.service.TaskManagerService;
import com.buzzmove.springtest.service.TaskManagerServiceImpl;
import com.buzzmove.springtest.validator.TaskValidator;

@Controller
public class HomeController extends AdminBaseConfig{
	
	@Autowired
	private TaskValidator taskValidator;
	
	 
	@Autowired
    private TaskManagerServiceImpl taskManagerServiceImpl;

	
	@ModelAttribute("task")
	public TaskManager costruct(){
		return super.newTask();
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	      binder.addValidators(taskValidator);
	}

	@RequestMapping("/list")
	public ModelAndView welcomeMessage(@RequestParam(value = "name", required = false) String name) {
		ModelAndView view = new ModelAndView(LIST_PAGE);
		view.addObject("name", name);
		view.addObject("initListTask", taskManagerServiceImpl.getAllTaskManager());
		view.addObject("titlePersons", super.initListTitle());
	 	 
		return view;
	}
	
	 
	@RequestMapping(value="/listOrder", method = RequestMethod.GET)
	public ModelAndView orderby(@RequestParam(value = "orderName", required = true) String orderName) {
		ModelAndView view = new ModelAndView(LIST_PAGE);
		List<TaskManager> listTaskManager = new ArrayList<TaskManager>();
		listTaskManager = taskManagerServiceImpl.getAllTaskManager();
		super.sorderByAttribut(listTaskManager,orderName);
		 
		view.addObject("orderName", orderName);
		view.addObject("initListTask", listTaskManager);
		view.addObject("titlePersons", super.initListTitle());
	 	 
		return view;
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam(value = "idTask", required = true) String idTask) {
		ModelAndView view = new ModelAndView(LIST_PAGE);
		List<TaskManager> listTaskManager = new ArrayList<TaskManager>();
		 
		int size = taskManagerServiceImpl.getAllTaskManager().size();
		taskManagerServiceImpl.delete(idTask);
		listTaskManager = taskManagerServiceImpl.getAllTaskManager();
		if(listTaskManager.size()<size){
			System.out.print("Delete operate with success");
		}
		view.addObject("idTask", idTask);
		view.addObject("initListTask", listTaskManager);
		view.addObject("titlePersons", super.initListTitle());
	 	 
		return view;
	}
	
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(){
		DBConnectionUtil.initDB();
		return super.HOME;
	}
	
 
	
	/*
	 * new task object
	*/
    @RequestMapping(value="/newTask", method = RequestMethod.POST)
    public String newUser(BindingResult result, Model model) {
    	model.addAttribute("task", super.newTask());
    	
        return NEW_TASK;
      
   }
	
	
   
   @RequestMapping(value = "/saveTask", method = RequestMethod.POST)
	public ModelAndView doSaveTask(@Validated @ModelAttribute("task") TaskManager taskForm, BindingResult result, Map<String, Object> model) {
	    taskValidator.validate(taskForm, result);
	    ModelAndView view = new ModelAndView(LIST_PAGE);
      
	    view.addObject("name", ""); 
	    view.addObject("titlePersons", super.initListTitle());
	    int res = 0;
	    
	    List<TaskManager> listTaskManager = new ArrayList<TaskManager>();
	    listTaskManager = taskManagerServiceImpl.getAllTaskManager();
	    TaskManager task = compileTask(taskForm);
		
	    if (!result.hasErrors()) {
		    res = taskManagerServiceImpl.save(task);
			if(res>0) {
				System.out.println("Inser/Update with success");
				listTaskManager = taskManagerServiceImpl.getAllTaskManager();
			}
		}
	    
	    view.addObject("initListTask", listTaskManager);
		
	     
		return view;
	}

}
