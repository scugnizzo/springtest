package com.buzzmove.springtest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.buzzmove.springtest.DBUtils.DBConnectionUtil;
import com.buzzmove.springtest.model.TaskManager;

@Repository
public class TaskManagerDAOImpl implements TaskManagerDAO {

	final String INSERT_QUERY = "INSERT INTO TASK_MANAGER (ID_TASK, TITLE_CUSTOMER, FIRSTNAME, LASTNAME, NOTES, SCHEDULETED_DATE)";
	final String SELECT_QUERY_ALL = "SELECT ID_TASK, TITLE_CUSTOMER, FIRSTNAME, LASTNAME, NOTES, SCHEDULETED_DATE FROM TASK_MANAGER";
	final String SELECT_QUERY_BY = "SELECT ID_TASK, TITLE_CUSTOMER, FIRSTNAME, LASTNAME, NOTES, SCHEDULETED_DATE FROM TASK_MANAGER WHERE ID_TASK =  ? ";
	final String UPDATE_QUERY = "UPDATE TASK_MANAGER SET TITLE_CUSTOMER = ? , FIRSTNAME = ?, LASTNAME = ?, NOTES= ?, SCHEDULETED_DATE = ? WHERE ID_TASK = ? ";
	final String DELETE_QUERY = "DELETE FROM TASK_MANAGER WHERE ID_TASK = ? ";
	final String COUNT_QUERY = "SELECT count(*) FROM TASK_MANAGER WHERE ID_TASK =  ";

	public TaskManagerDAOImpl() {
	}

	public List<TaskManager> getAllTaskManager() {
		System.out.println("START: findPerson");

		Statement stmt = null;
		ResultSet resultSet = null;
		List<TaskManager> lisTaskManager = new ArrayList<TaskManager>();
		Connection connection = null;
		try {

			TaskManager task = null;
			connection = DBConnectionUtil.getConnectionInit();
			stmt = connection.createStatement();
			stmt.execute(SELECT_QUERY_ALL);
			resultSet = stmt.getResultSet();
			while (resultSet.next()) {
				if (!resultSet.wasNull()) {
					task = new TaskManager();
					task.setIdTask(resultSet.getString("ID_TASK"));
					task.setTitleCustomer(resultSet.getString("TITLE_CUSTOMER"));
					task.setFirstname(resultSet.getString("FIRSTNAME"));
					task.setLastname(resultSet.getString("LASTNAME"));
					task.setNotes(resultSet.getString("NOTES"));
					task.setScheduledDate(resultSet
							.getString("SCHEDULETED_DATE"));
					lisTaskManager.add(task);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lisTaskManager;
	}

	public TaskManager getTaskManagerById(String idTask) {
		String SQL = SELECT_QUERY_BY + idTask + " ";
		System.out.println("START: findPerson");
		PreparedStatement pstmt = null;

		ResultSet resultSet = null;
		List<TaskManager> lisTaskManager = new ArrayList<TaskManager>();
		Connection connection = null;

		try {

			TaskManager task = null;
			connection = DBConnectionUtil.getConnectionInit();
			pstmt = connection.prepareStatement(SELECT_QUERY_BY);
			pstmt.setString(1, idTask);
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				task = new TaskManager();
				task.setIdTask(resultSet.getString("ID_TASK"));
				task.setTitleCustomer(resultSet.getString("TITLE_CUSTOMER"));
				task.setFirstname(resultSet.getString("FIRSTNAME"));
				task.setLastname(resultSet.getString("LASTNAME"));
				task.setNotes(resultSet.getString("NOTES"));
				task.setScheduledDate(resultSet.getString("SCHEDULETED_DATE"));
				lisTaskManager.add(task);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lisTaskManager.size() > 0 ? lisTaskManager.get(0) : null;

	}

	public int save(TaskManager task) {
		// INSERT_QUERY 
		Connection connection = null;
		Statement stmt = null;
		int counts = 0;
		try {

			connection = DBConnectionUtil.getConnectionInit();
			connection.setAutoCommit(false);
  
			if(rowCount(task,connection)>0) {
				//This is update case
				update(task, connection);
			} else{
				//This is update case
			 	stmt = connection.createStatement();
				String query = getSqlQueryInsert(task);
				counts = stmt.executeUpdate(query);
				connection.commit();
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return counts;

	}

	public void delete(String idTask) {

		Connection connection = null;
		PreparedStatement pStmt = null;
		try {
			connection = DBConnectionUtil.getConnectionInit();
			pStmt = connection.prepareStatement(DELETE_QUERY);
			pStmt.setString(1, idTask);

			pStmt.executeUpdate();
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null)
					pStmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<TaskManager> getAllTaskManageMockr() {

		List<TaskManager> list = new ArrayList<TaskManager>();
		list.add(new TaskManager("Mr.", "Max", "Sposato", new String(
				"12/09/2017")));
		TaskManager task1 = new TaskManager("Mr.", "Max", "Sposato",
				new String("12/09/2017"));
		list.add(task1);
		task1.setNotes("Try messege");

		list.add(new TaskManager("Mr.", "massimo", "sposato", "12/09/1973"));
		list.add(new TaskManager("Miss.", "Jhon", "Lendel", "12/09/1973"));
		list.add(new TaskManager("Mrs.", "Math", "Lendel", "12/09/1973"));
		list.add(new TaskManager("Sr.", "Path", "Smith", "12/09/1973"));

		return list;

	}

	// UPDATE TASK_MANAGER SET TITLE_CUSTOMER = ? , FIRSTNAME = ?, LASTNAME = ?,
	// NOTES= ?, SCHEDULETED_DATE = ? WHERE ID_TASK = ?";
	public void update(TaskManager task, Connection connection) {
		 
		PreparedStatement pStmt = null;

		try {
            // UPDATE table_name SET column1 = value1, column2 = value2, ...	WHERE condition;
			//UPDATE TASK_MANAGER SET TITLE_CUSTOMER = ? , FIRSTNAME = ?, LASTNAME = ?, NOTES= ?, SCHEDULETED_DATE = ? WHERE ID_TASK = ? 
			pStmt = connection.prepareStatement(UPDATE_QUERY);
			pStmt.setString(1, task.getTitleCustomer());
			pStmt.setString(2, task.getFirstname());
			pStmt.setString(3, task.getLastname());
			pStmt.setString(4, task.getNotes());
			pStmt.setString(5, task.getScheduledDate());
			pStmt.setString(6, task.getIdTask());

			pStmt.executeUpdate();
			connection.commit();
		 
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null)
					pStmt.close();
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int rowCount(TaskManager task, Connection connection ) {
		 
		Statement stmt = null;
		int rows = 0;
		ResultSet result = null;
		try {
			stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			result = stmt.executeQuery(COUNT_QUERY + "'" + task.getIdTask()+ "'");
		 
			 
			while (result.next()) {
				rows = result.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (result != null)
					result.close();
				if (stmt != null)
					stmt.close();
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}

	/***
	 * "INSERT INTO TASK_MANAGER (ID_TASK, TITLE_CUSTOMER, FIRSTNAME, LASTNAME, NOTES, SCHEDULETED_DATE)"
	 * @param task
	 * @return
	 */
	private String getSqlQueryInsert(TaskManager task) {
		System.out.println(" START - getSqlQueryInsert ");
		StringBuilder sqlQuery = new StringBuilder(INSERT_QUERY);
		sqlQuery.append(" VALUES ('");
		sqlQuery.append(task.getIdTask());
		sqlQuery.append("', '" + task.getTitleCustomer());
		sqlQuery.append("', '" + task.getFirstname());
		sqlQuery.append("', '" + task.getLastname());
		sqlQuery.append("', '" + task.getNotes());
		sqlQuery.append("', '" + task.getScheduledDate());
		sqlQuery.append("')");

		System.out.println("getSqlQueryInsert - SQL QUERY : "
				+ sqlQuery.toString());
		System.out.println(" END - getSqlQueryInsert ");
		return sqlQuery.toString();
	}
}
