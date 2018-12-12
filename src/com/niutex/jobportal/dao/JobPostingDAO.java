package com.niutex.jobportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.niutex.jobportal.entities.JobPosting;

public class JobPostingDAO {
	
	private Connection conn;
	
	public JobPostingDAO() {
//		specify driver using for connection to mysql
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String Database_URL = "jdbc:mysql://localhost/JobPortal";
		
		final String Database_USER = "JobPortal";
		final String Database_PASSWORD = "";
		
		
			try {
				Class.forName(JDBC_DRIVER);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		try {
			this.conn = DriverManager.getConnection(Database_URL, Database_USER, Database_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public JobPosting getJobPostingById(int id) {
//		object that allows to communicate with the database;
//		send sql write in in java and send to db
		Statement statement;
		ResultSet resultSet;
		 
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from JobPostings where id = " + id);
		
			if(resultSet.next()) {
				JobPosting jobPostingToReturn = new JobPosting();
				
				jobPostingToReturn.setContactPhone(resultSet.getString("contactPhone"));
				jobPostingToReturn.setMessageBody(resultSet.getString("messageBody"));
				jobPostingToReturn.setJobName(resultSet.getString("jobName"));
				jobPostingToReturn.setPosterName(resultSet.getString("posterName"));
				jobPostingToReturn.setId(resultSet.getInt("id"));
				jobPostingToReturn.setJobPostingPassword(resultSet.getString("jobPostingPassword"));
				
				return jobPostingToReturn;
				
			}
			statement.close();
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		return null;
		
		
	}
	
	public void insertJobPosting(JobPosting posting) {
		
		String sep = "','";
		
		try {
			Statement statement = conn.createStatement();
			String sqlQuery = "insert into jobPostings("
					+ "messageBody,jobName,posterName,contactPhone,jobPostingPassword) values('"
					+ posting.getMessageBody() + sep
					+ posting.getJobName() + sep
					+ posting.getPosterName() + sep
					+ posting.getContactPhone() + sep
					+ posting.getJobPostingPassword() + "')";	
			System.out.println(sqlQuery);
//			executeUpdate affects database
			statement.executeUpdate(sqlQuery);		
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void remveJobPosting(int jobPostingId) {
		
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate("delete from jobPostings where id=" + jobPostingId);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<JobPosting> getAllJobPostings() {
		
		Statement statement;
		ResultSet resultSet;
		
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from jobPostings");
			List<JobPosting> allJobs = new ArrayList<>();
			
			while(resultSet.next()) {
				JobPosting jobPostingToAdd = new JobPosting();
				
				jobPostingToAdd.setContactPhone(resultSet.getString("contactPhone"));
				jobPostingToAdd.setMessageBody(resultSet.getString("messageBody"));
				jobPostingToAdd.setJobName(resultSet.getString("jobName"));
				jobPostingToAdd.setPosterName(resultSet.getString("posterName"));
				jobPostingToAdd.setId(resultSet.getInt("id"));
				
				allJobs.add(jobPostingToAdd);
								
			}
			
			statement.close();
			resultSet.close();
			return allJobs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
