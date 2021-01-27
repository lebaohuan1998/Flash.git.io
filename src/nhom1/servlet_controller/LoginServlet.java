package nhom1.servlet_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.AccountDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private String userID = "sang";
//	private String password = "123";
//	private int role = 1;
    /**
     * @see HttpServlet#HttpServlet()
     */
	 public void init() {
			
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("log-in.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		System.out.println(user);
		String pwd = request.getParameter("password");
		System.out.println(pwd);
		HttpSession session = request.getSession();
		AccountDAO accDAO = new AccountDAO();
		if(accDAO.getAccount(user, pwd) && user != "" && pwd != ""){
			int role = accDAO.getRole(user, pwd).getRole();
			session.setAttribute("user", user);
			if (role == 1) {
				session.setAttribute("role", "1");//employee admin
				response.sendRedirect(request.getContextPath() + "/EmployeeServlet");
				
			} else if (role == 2)  {
				session.setAttribute("role", "2");//car admin
				response.sendRedirect(request.getContextPath() + "/CarServlet");
			}
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/log-in.jsp");
			System.out.println("Wrong username and pass");
			rd.forward(request, response);
		}
	}

}