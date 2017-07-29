package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/home")
public class ControllerServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/nameWithBeans.jsp");
		
		//global scope, the user bean will be accessible from anywhere
//		getServletContext().setAttribute("userBean", user);
		
		//session scope, the user bean will be accessible for the lifetime of the current session
//		request.getSession().setAttribute("userBean", user);
		
		//request scope, the user bean will only live for the lifetime of the request
//		request.getSession().setAttribute("userBean", user);
		
		dispatcher.forward(request, response);
		
//		response.getWriter().print("HELLO WORLD");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		User user = new User();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		if (!name.isEmpty() && !email.isEmpty())
		{
			user.setName(name);
			user.setEmail(email);
			request.getSession().setAttribute("userBean", user);

//			System.out.println(name + " -- " + email);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/nameWithBeans.jsp");
			dispatcher.forward(request, response);
//			dispatcher.include(request, response);
			
		}
		else
		{
			response.sendRedirect("/WEB-INF/name.jsp");
		}
	}

}
