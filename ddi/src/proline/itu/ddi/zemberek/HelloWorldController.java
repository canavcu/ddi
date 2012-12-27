package proline.itu.ddi.zemberek;


import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.*;

	public class HelloWorldController implements Controller {
		
			public ModelAndView handleRequest(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {
		
				String aMessage = "Hello World MVC!";
				 response.getWriter().println();
				ModelAndView modelAndView = new ModelAndView("index");
				modelAndView.addObject("message", aMessage);
				return modelAndView;
			}
	}

