package nhom1.servlet_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.AccountDAO;
import nhom1.dao.DescribePhotographerDAO;
import nhom1.dao.PhotographerInfoDAO;
import nhom1.dao.PhotographerRegisterDAO;
import nhom1.md5.MD5Library;
import nhom1.model.Photographer;

/**
 * Servlet implementation class LoginPhotographerGoogle
 */
@WebServlet("/LoginPhotographerGoogle")
public class LoginPhotographerGoogle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MD5Library md = new MD5Library();
	private PhotographerRegisterDAO upomr = new PhotographerRegisterDAO();
	private DescribePhotographerDAO dpd = new DescribePhotographerDAO();
	private PhotographerInfoDAO upd = new PhotographerInfoDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginPhotographerGoogle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String fullName = request.getParameter("fullname");
		String pwd = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String ngheDanh = "";
		ngheDanh = request.getParameter("nghedanh");
		String tcc = request.getParameter("thecancuoc");
		String address = request.getParameter("address");
		Photographer pom = new Photographer(email, fullName, ngheDanh, md.md5(pwd), phone, tcc, address, "4");
		AccountDAO accDAO = new AccountDAO();
		if (upomr.RegisterPhotographer(pom)) {
			String idPhotographer = upomr.getIdPhotographer(email);
			pom.setId(idPhotographer);
			if (upomr.addIdentityPhotographers(pom)) {
				upomr.AddMapLocation(idPhotographer);
				upd.updateActive("1", Integer.parseInt(idPhotographer));
				dpd.insertFirstDescribe(Integer.parseInt(idPhotographer));
				session.setAttribute("user", accDAO.getRolePhoto(email, md.md5(pwd)).getFullName());
				session.setAttribute("role", accDAO.getRolePhoto(email, md.md5(pwd)).getRole());// employee admin
				session.setAttribute("id", accDAO.getRolePhoto(email, md.md5(pwd)).getId());
				session.setAttribute("pass", accDAO.getRolePhoto(email, md.md5(pwd)).getPassword());
				session.setAttribute("email", email);
				response.sendRedirect(request.getContextPath() + "/HomePageServlet");
			}else {
				response.sendRedirect(request.getContextPath() + "/HomePageServlet");
			}
		}

	}

}
