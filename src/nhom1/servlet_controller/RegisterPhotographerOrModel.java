package nhom1.servlet_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.UserPOMRegisterDAO;
import nhom1.md5.MD5Library;
import nhom1.model.NormalUser;
import nhom1.model.PhotographerOrModel;

/**
 * Servlet implementation class RegisterPhotographerOrModel
 */
@WebServlet("/RegisterPhotographerOrModel")
public class RegisterPhotographerOrModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserPOMRegisterDAO upomr= new UserPOMRegisterDAO();
	private MD5Library md = new MD5Library();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterPhotographerOrModel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("registerphoto.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String fullName = request.getParameter("fullname");
		System.out.println(fullName);
		String pwd = request.getParameter("password");
		System.out.println(pwd);
		String email = request.getParameter("email");
		System.out.println(email);
		String phone = request.getParameter("phone");
		System.out.println(phone);
		String ngheDanh="";
		 ngheDanh= request.getParameter("nghedanh");
		System.out.println(ngheDanh);
		String tcc= request.getParameter("thecancuoc");
		System.out.println(tcc);
		
		if (upomr.checkEmailDupplicate(email)) {
			response.sendRedirect(request.getContextPath() + "/RegisterPhotographerOrModel?err=false");
		} else {
			PhotographerOrModel pom= new PhotographerOrModel(email, fullName, ngheDanh, md.md5(pwd), phone, tcc, "2");
			if (upomr.RegisterPOM(pom)) {
				response.sendRedirect(request.getContextPath() + "/LoginServlet?Register=success");
			} else {
				response.sendRedirect(request.getContextPath() + "/RegisterPhotographerOrModel?Register=false");
			}
		}
		

	}

}
