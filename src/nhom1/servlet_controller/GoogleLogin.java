package nhom1.servlet_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom1.accsessgoogle.Constants;
import nhom1.model.GooglePojo;

/**
 * Servlet implementation class GoogleLogin
 */
@WebServlet("/GoogleLogin")
public class GoogleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Constants constants= new Constants();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoogleLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		
		if (code == null || code.isEmpty()) {
			RequestDispatcher dis = request.getRequestDispatcher("log-in.jsp");
			dis.forward(request, response);
		} else {
			String accessToken = constants.getToken(code);
			GooglePojo googlePojo = constants.getUserInfo(accessToken);
			System.out.println(googlePojo.getEmail());
			System.out.println(googlePojo.getFamily_name());
			System.out.println(googlePojo.getGiven_name());
			System.out.println(googlePojo.getId());
			System.out.println(googlePojo.getLink());
			System.out.println(googlePojo.getPicture());
			System.out.println(googlePojo.isVerified_email());
			request.setAttribute("id", googlePojo.getId());
			request.setAttribute("name", googlePojo.getName());
			request.setAttribute("email", googlePojo.getEmail());
			RequestDispatcher dis = request.getRequestDispatcher("NewFile.jsp");
			dis.forward(request, response);
		}
	    



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    System.out.println("huan post");

	}

}
