package com.example.web;

import com.example.model.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CurConv extends HttpServlet {
         public void doPost(HttpServletRequest request,
                              HttpServletResponse response)
                              throws IOException, ServletException {


	      String adds =request.getParameter("adds");
              if(adds.equals("?")){      
		String myurl=(String)getServletContext().getAttribute("takeurl");
    		response.sendRedirect(myurl);
		}
	      else if(adds.equals("!")){
		String mytext=(String)getServletContext().getAttribute("taketext");
    		response.sendRedirect(mytext);

		}
	      else{	
              	String f = request.getParameter("from");
              	String t = request.getParameter("to");	
              	String amount = request.getParameter("amount");	

	      	double am = Double.parseDouble(amount);


	      	CurExpert c = new CurExpert();
	      	double res = c.getRes(f,t,am);


            	response.setContentType("text/html");
              	PrintWriter out = response.getWriter();
              	out.println("<h1>Currency Converter</h1>");

		out.print(amount + " in " + f + " = " + res+ " in " + t);

	       }
	      
	}     
}


