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


@WebServlet(urlPatterns = {"/RemoveJob", "/JobRemove"})
public class RemoveJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RemoveJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/removeJob.jsp");
		reqDispatcher.forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		JobPostingDAO dao = new JobPostingDAO();
		
		int postingId = Integer.parseInt(request.getParameter("id"));
		JobPosting posting = dao.getJobPostingById(postingId);
		
		if(posting == null) {
			request.setAttribute("error", true);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/removeJob.jsp");
			reqDispatcher.forward(request, response);
		}
		
		if(request.getParameter("password").equals(posting.getJobPostingPassword())) {
			dao.remveJobPosting(postingId);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/removeJobSuccess.jsp");
			reqDispatcher.forward(request, response);
		} else {
			request.setAttribute("error", true);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/removeJob.jsp");
			reqDispatcher.forward(request, response);
		}
		
	}

}
