import com.example.model.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent event){

		ServletContext sc = event.getServletContext();
		
		String url = sc.getInitParameter("infurl");
		sc.setAttribute("takeurl", url);

		String text = sc.getInitParameter("downurl");
		sc.setAttribute("taketext", text);		
	}
	public void contextDestroyed(ServletContextEvent event){

	}
}

 

