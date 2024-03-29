package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TreatmentDetails;
import com.dao.ITreatmentDetailsDAO;
import com.dao.TreatmentDetailsDAO;




@WebServlet("/AddTreatmentDetailsServlet")
public class AddTreatmentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		try {
				response.setContentType("text/html");
	
				TreatmentDetails treatmentDetails = new TreatmentDetails();
			
		
				treatmentDetails.setPatientID(request.getParameter("patientID"));
				treatmentDetails.setDoctorID(request.getParameter("doctorID"));
				treatmentDetails.setbP(Integer.parseInt(request.getParameter("bP")));
				treatmentDetails.sethR(Integer.parseInt(request.getParameter("hR")));
				treatmentDetails.setsPO2(Double.parseDouble(request.getParameter("sPO2")));
				treatmentDetails.setFintake(Double.parseDouble(request.getParameter("fintake")));
				treatmentDetails.setFoutput(Double.parseDouble(request.getParameter("foutput")));
				
				
				ITreatmentDetailsDAO iTreatmentDetails= new TreatmentDetailsDAO();
				int treatmentDetailsID = iTreatmentDetails.addTreatmentDetails(treatmentDetails);
					
				request.setAttribute("TreatmentDetailsID", treatmentDetailsID);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addTreatmentDetails_Medicine.jsp");
				dispatcher.forward(request, response);
					
				
			}
			catch(NumberFormatException e) 
			{
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Fail.jsp");
				dispatcher.forward(request, response);
			}
			
			catch(Exception ex) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Fail.jsp");
				dispatcher.forward(request, response);
			}
		
	}
}	

