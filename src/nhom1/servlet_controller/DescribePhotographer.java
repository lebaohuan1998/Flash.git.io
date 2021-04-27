package nhom1.servlet_controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import nhom1.dao.DescribePhotographerDAO;
import nhom1.dao.PhotographerInfoDAO;
import nhom1.model.DecribePhotographer;
import nhom1.model.Photographer;

/**
 * Servlet implementation class GoiDichVu_LichBan
 */
@WebServlet("/DescribePhotographer")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 5, // 2MB
maxFileSize = 1024 * 1024 * 5, // 5MB
maxRequestSize = 1024 * 1024 * 5) // 5MB

public class DescribePhotographer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DescribePhotographerDAO dpd = new DescribePhotographerDAO();
	private PhotographerInfoDAO upd = new PhotographerInfoDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DescribePhotographer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		
		
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("cmd");
			if(theCommand==null)
			{
				theCommand="view";
			}
			switch (theCommand) {
			case "view":
				view(request, response);
				break;
			case "describe":
				describe(request, response);
				break;
			case "overview":
				uploadImage(request, response);
				break;
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	
		
		
		
	}

	private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int photographerID = (Integer) session.getAttribute("id");
		 long millis=System.currentTimeMillis(); 
		 request.setAttribute("urlAdd", millis);
		DecribePhotographer getD= dpd.getDescribe(photographerID);
		System.out.println("photographerID="+photographerID);
		Photographer pom =upd.getInfo(photographerID);
		request.setAttribute("describeText", getD.getDescribe());
		
		request.setAttribute("imgname1", getD.getImageFirst());
		request.setAttribute("imgname2", getD.getImageSecond());
		//System.out.println("anh 1 la"+getD.getImageFirst());
		//request.setAttribute("email", pom.getEmail());
		//request.setAttribute("role", pom.getRoleId());
		
		request.setAttribute("role", "4");
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/tho-chup-anh.jsp");
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

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("cmd");
			if(theCommand==null)
			{
				theCommand="view";
			}
			switch (theCommand) {
			case "describe":
				describe(request, response);
				break;
			case "view":
				view(request, response);
				break;
			
			case "uploadImage":
				uploadImage(request, response);
				break;
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	
		
		
		
		
	}

	private void uploadImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int photographerID = (Integer) session.getAttribute("id");
		String describeText = dpd.getDescribe(photographerID).getDescribe();
		//String describeText = request.getParameter("editor1");
		//Photographer pomGet =upd.getInfo(photographerID);
		request.setAttribute("imgname1",dpd.getDescribe(photographerID).getImageFirst() );
		request.setAttribute("imgname2",dpd.getDescribe(photographerID).getImageSecond() );

		String role= "4";
		
		Part part = request.getPart("file1");
		if (part != null) {
			String realPath = request.getServletContext().getRealPath("/images/" + photographerID+role);
			String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realPath))) {
				Files.createDirectories(Path.of(realPath));
			}
			if (!filename.equals("")) {
				
				part.write(realPath + "/" + "imageDes1.jpg");
				request.setAttribute("imgname1", "imageDes1.jpg");
			}

			//System.out.println("name1:" + filename);
		}
		
		Part partSecond = request.getPart("file2");
		if (part != null) {
			String realPath2 = request.getServletContext().getRealPath("/images/" + photographerID+role);
			String filename2 = Path.of(partSecond.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realPath2))) {
				Files.createDirectories(Path.of(realPath2));
			}
			if (!filename2.equals("")) {
				partSecond.write(realPath2 + "/" + "imageDes2.jpg");
				request.setAttribute("imgname2", "imageDes2.jpg");
			}

			System.out.println("nameImage Des2:" + filename2);
		}
	
		
		
		
		DecribePhotographer pom = new DecribePhotographer();
		pom.setDescribe(describeText);
		pom.setPhotographerID(photographerID);

		pom.setImageFirst((String) request.getAttribute("imgname1"));
		pom.setImageSecond((String) request.getAttribute("imgname2"));
	
		//System.out.print("idDescribe" +idDescribe);
		
		if(dpd.updateDescribe(pom, photographerID))
		response.sendRedirect(request.getContextPath() + "/DescribePhotographer?flag=5&updateImage=true");
		else
		{
			response.sendRedirect(request.getContextPath() + "/DescribePhotographer?flag=5&updateImage=false");
		}
		
	}

	private void describe(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		int photographerID = (Integer) session.getAttribute("id");
		String describeText = request.getParameter("editor1");
		
		//Photographer pomGet =upd.getInfo(photographerID);
		request.setAttribute("imgname1",dpd.getDescribe(photographerID).getImageFirst() );
		request.setAttribute("imgname2",dpd.getDescribe(photographerID).getImageSecond() );
//
//		pom.setImageFirst((String) request.getAttribute("imgname1"));
//		pom.setImageSecond((String) request.getAttribute("imgname2"));
			
		//String id=pomGet.getId();
		String role= "4";
		
		Part part = request.getPart("file1");
		if (part != null) {
			String realPath = request.getServletContext().getRealPath("/images/" + photographerID+role);
			String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realPath))) {
				Files.createDirectories(Path.of(realPath));
			}
			if (!filename.equals("")) {
				part.write(realPath + "/" + "imageDes1.jpg");
				request.setAttribute("imgname1", "imageDes1.jpg");
			}

			//System.out.println("name1:" + filename);
		}
		
		Part partSecond = request.getPart("file2");
		if (part != null) {
			String realPath2 = request.getServletContext().getRealPath("/images/" + photographerID+role);
			String filename2 = Path.of(partSecond.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realPath2))) {
				Files.createDirectories(Path.of(realPath2));
			}
			if (!filename2.equals("")) {
				partSecond.write(realPath2 + "/" + "imageDes2.jpg");
				request.setAttribute("imgname2", "imageDes2.jpg");
			}

			System.out.println("nameImage Des2:" + filename2);
		}
	
		
		
		
		DecribePhotographer pom = new DecribePhotographer();
		pom.setDescribe(describeText);
		pom.setPhotographerID(photographerID);
		//request.setAttribute("imgname1", "imageDes1.jpg");
		//request.setAttribute("imgname2", "imageDes2.jpg");
		pom.setImageFirst((String) request.getAttribute("imgname1"));
		pom.setImageSecond((String) request.getAttribute("imgname2"));
	
		//System.out.print("idDescribe" +idDescribe);
		
		if(dpd.updateDescribe(pom, photographerID))
		response.sendRedirect(request.getContextPath() + "/DescribePhotographer?flag=5&updateDescribe=true");
		else
		{
			response.sendRedirect(request.getContextPath() + "/DescribePhotographer?flag=5&updateDescribe=false");
		}
	}

}
