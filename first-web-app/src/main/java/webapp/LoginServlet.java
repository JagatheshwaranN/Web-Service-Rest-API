package webapp;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
* Browser sends Http Request to Web Server
* 
* Code in Web Server => Input:HttpRequest, Output: HttpResponse
* JEE with Servlets
* 
* Web Server responds with Http Response
*/

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class 
//used to extend the capabilities of servers 
//that host applications accessed by means of 
//a request-response programming model.

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UserValidationService userValidationService = new UserValidationService();

//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>First Web App</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("My First Servlet..");
//		out.println("</body>");
//		out.println("</html>");
//	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
//		String name = request.getParameter("name");
//		request.setAttribute("name", name);
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		boolean isValidUser = userValidationService.isUserValid(name, password);
		if (isValidUser) {
			request.setAttribute("name", name);
			request.setAttribute("password", password);
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Invalid Credentials!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}

}
 