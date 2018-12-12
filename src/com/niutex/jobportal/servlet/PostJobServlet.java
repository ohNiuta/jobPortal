package com.niutex.jobportal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niutex.jobportal.dao.JobPostingDAO;
import com.niutex.jobportal.entities.JobPosting;

@WebServlet("/PostJob")
public class PostJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PostJobServlet() {
        super();        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/postJob.jsp");
		reqDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String messageBody = request.getParameter("messagebody");
		String jobName = request.getParameter("jobname");
		String posterName = request.getParameter("postername");
		String secretPassword = request.getParameter("secretpassword");
		String contactPhone = request.getParameter("contactphone");
		
		JobPosting jobPosting = new JobPosting();
		
		jobPosting.setMessageBody(messageBody);
		jobPosting.setJobName(jobName);
		jobPosting.setPosterName(posterName);
		jobPosting.setJobPostingPassword(secretPassword);
		jobPosting.setContactPhone(contactPhone);
		
		JobPostingDAO jobPostDao = new JobPostingDAO();
		jobPostDao.insertJobPosting(jobPosting);
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/postJobSuccess.jsp");
		reqDispatcher.forward(request, response);

	}

}
