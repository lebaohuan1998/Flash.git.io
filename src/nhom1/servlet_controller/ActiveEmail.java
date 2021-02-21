package nhom1.servlet_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom1.dao.AccountDAO;
import nhom1.dao.UserNorInfoDAO;
import nhom1.dao.UserPhotoDAO;

/**
 * Servlet implementation class ActiveEmail
 */
@WebServlet("/ActiveEmail")
public class ActiveEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountDAO acc = new AccountDAO();
	private UserNorInfoDAO und= new UserNorInfoDAO();
	private UserPhotoDAO upd= new UserPhotoDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActiveEmail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String token = request.getParameter("active");
		try {
			if (acc.getActiveEmailUser(user, token) != null) {
				if (acc.getActiveEmailUser(user, token).getTokenEmail().equals(token)) {
					int id=Integer.parseInt(acc.getActiveEmailUser(user, token).getId());
					und.updateActive("active", id);

					RequestDispatcher dispatcher = request.getRequestDispatcher("activeemail.jsp");
					dispatcher.forward(request, response);
				}

			} else if (acc.getActiveEmailPhoto(user, token) != null) {
				if (acc.getActiveEmailPhoto(user, token).getTokenEmail().equals(token)) {
					int id =Integer.parseInt(acc.getActiveEmailPhoto(user, token).getId());
					upd.updateActive("active", id);
					RequestDispatcher dispatcher = request.getRequestDispatcher("activeemail.jsp");
					dispatcher.forward(request, response);
				}

			} else {

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
