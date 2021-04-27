package nhom1.servlet_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom1.dao.ArticleDAO;
import nhom1.model.Article;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/baiviet")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDAO art = new ArticleDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Article arti = new Article();
		String idArticle = request.getParameter("id");
		arti = art.getByArticleId(idArticle);
		request.setAttribute("ArticleViewId", arti);
		request.setAttribute("ArticleAlbum", art.getServicePackageArticle());
		request.setAttribute("ArticleNewViewId", art.get5NewArticle(idArticle));
		request.setAttribute("ArticleRandom", art.get4ArticleRandom(idArticle));
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/baiviet.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
