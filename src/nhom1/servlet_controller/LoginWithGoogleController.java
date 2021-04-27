package nhom1.servlet_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.AccountDAO;
import nhom1.dao.UserProfileInfoDAO;
import nhom1.dao.UserRegisterDAO;
import nhom1.md5.MD5Library;
import nhom1.model.User;

/**
 * Servlet implementation class LoginUserGoogle
 */
@WebServlet("/LoginUserGoogle")
public class LoginWithGoogleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MD5Library md = new MD5Library();
	private UserRegisterDAO unr = new UserRegisterDAO();
	private UserProfileInfoDAO und = new UserProfileInfoDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginWithGoogleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String fullName = request.getParameter("fullName");
		String pwd = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		System.out.println(email);
		System.out.println(fullName);
		System.out.println(phone);
		System.out.println(pwd);
		AccountDAO accDAO = new AccountDAO();
			User nu = new User(fullName, md.md5(pwd), phone, email, "3");
			if (unr.Register(nu)) {
				und.updateActive("1", email);
				session.setAttribute("user", accDAO.getRoleUser(email, md.md5(pwd)).getFullName());
				session.setAttribute("role", accDAO.getRoleUser(email, md.md5(pwd)).getRole() );// employee admin
				session.setAttribute("id", accDAO.getRoleUser(email, md.md5(pwd)).getId());
				session.setAttribute("pass", accDAO.getRoleUser(email, md.md5(pwd)).getPassword());
				session.setAttribute("email", email);
				response.sendRedirect(request.getContextPath() + "/HomePageServlet");
			} else {
				response.sendRedirect(request.getContextPath() + "/HomePageServlet");
			}
	}

}
