package nhom1.servlet_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom1.dao.AccountDAO;
import nhom1.dao.UserProfileInfoDAO;
import nhom1.dao.PhotographerInfoDAO;

/**
 * Servlet implementation class ActiveEmail
 */
@WebServlet("/ActiveEmail")
public class ActiveEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountDAO acc = new AccountDAO();
	private UserProfileInfoDAO und= new UserProfileInfoDAO();
	private PhotographerInfoDAO upd= new PhotographerInfoDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActiveEmailController() {
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
					und.updateActive("1", id);

					RequestDispatcher dispatcher = request.getRequestDispatcher("activeemail.jsp");
					dispatcher.forward(request, response);
				}

			} else if (acc.getActiveEmailPhoto(user, token) != null) {
				if (acc.getActiveEmailPhoto(user, token).getTokenEmail().equals(token)) {
					int id =Integer.parseInt(acc.getActiveEmailPhoto(user, token).getId());
					upd.updateActive("1", id);
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
