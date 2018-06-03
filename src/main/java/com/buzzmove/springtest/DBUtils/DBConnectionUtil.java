package com.buzzmove.springtest.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionUtil {
	public DBConnectionUtil() {}
	
	public static void initDB() {
		Connection cn = null;
		Statement stmt = null;
		try {
			cn = getConnectionInit();
			stmt = cn.createStatement();
			
			//CREATE DATABASE IF NOT EXISTS taskdb;
			//USE taskdb;

			StringBuilder sqlCreate = new StringBuilder(" CREATE TABLE TASK_MANAGER (ID_TASK varchar(100), TITLE_CUSTOMER varchar(100), FIRSTNAME varchar(100), LASTNAME varchar(100) , NOTES varchar(100), SCHEDULETED_DATE varchar(20))");
			stmt.execute("DROP TABLE TASK_MANAGER IF EXISTS");
			stmt.execute(sqlCreate.toString());
			
			stmt.execute("INSERT INTO TASK_MANAGER (ID_TASK, TITLE_CUSTOMER, FIRSTNAME, LASTNAME, NOTES, SCHEDULETED_DATE) VALUES('Mr.MAXSPO12091973','Mr.', 'MAX', 'SPO','','12091973')");
 			stmt.execute("INSERT INTO TASK_MANAGER (ID_TASK, TITLE_CUSTOMER, FIRSTNAME, LASTNAME, NOTES, SCHEDULETED_DATE) VALUES('Mr.MAXSPO12091975','Mr.', 'MAX', 'SPO','','12091975')");
 			stmt.execute("INSERT INTO TASK_MANAGER (ID_TASK, TITLE_CUSTOMER, FIRSTNAME, LASTNAME, NOTES, SCHEDULETED_DATE) VALUES('Mr.SPOSPO12091980','Mr.', 'SPO', 'SPO','','12091980')");
			 
			
			cn.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}finally {
			close(cn, stmt);
		}
		
	}
	
	public static Connection getConnectionInit() throws SQLException, ClassNotFoundException {
		//Class.forName("org.hsqldb.jdbc.JDBCDriver");
        Class.forName("org.hsqldb.jdbcDriver");
		return DriverManager.getConnection("jdbc:hsqldb:mem", "sa", "");
	}
	
	/***
	 * 
	 * @param cn
	 * @param stmt
	 */
	public static void close(Connection cn, Statement stmt){
		try {
			if(stmt!=null) stmt.close();
			if(cn!=null) cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
