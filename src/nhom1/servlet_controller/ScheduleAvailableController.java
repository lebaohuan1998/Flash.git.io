package nhom1.servlet_controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.CategoryDAO;
import nhom1.dao.ServicePackageDAO;
import nhom1.dao.ListServicePackageDAO;
import nhom1.dao.LocationDAO;
import nhom1.dao.ScheduleAvailableDAO;
import nhom1.model.ServicePackage;
import nhom1.model.Category;
import nhom1.model.Images;

/**
 * Servlet implementation class GoiDichVu_LichBan
 */
@WebServlet("/GoiDichVuLichBan")
public class ScheduleAvailableController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListServicePackageDAO lad = new ListServicePackageDAO();
	private CategoryDAO cd = new CategoryDAO();
	private ServicePackageDAO coa = new ServicePackageDAO();
	private LocationDAO ld = new LocationDAO();
	private ScheduleAvailableDAO sbd = new ScheduleAvailableDAO();
	private Date date1;
	private Date date2;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ScheduleAvailableController() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			// read the "command" parameter
			String command = request.getParameter("command");
			if (command == null) {
				command = "SHOW";
			}
			switch (command) {
			case "SHOW":
				showViews(request, response);
				break;
			case "ADDDATE":
				addDate(request, response);
				break;
			case "DELETE":
				deleteAlbum(request, response);
				break;
			case "DELETEDATE":
				deleteDate(request, response);
				break;
			case "SEARCH":
				searchAlbum(request, response);
				break;
			case "DELETEALLDATE":
				deleteAllDate(request, response);
				break;
			case "HideShow":
				hideShow(request, response);
				break;
			default:
				showViews(request, response);
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	private void hideShow(HttpServletRequest request, HttpServletResponse response) {
		String idA = request.getParameter("arr");
		idA = idA.substring(2, idA.length() - 2);
		String idAlbum[] = idA.split("\",\"");
		for (int i = 0; i < idAlbum.length; i++) {
			if (coa.getStatusPackage(idAlbum[i]) == 1) {
				coa.hideShow(idAlbum[i], "0");
			} else if (coa.getStatusPackage(idAlbum[i]) == 0) {
				coa.hideShow(idAlbum[i], "1");
			}
		}

	}

	private void deleteAllDate(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String idA = request.getParameter("arr");
		idA = idA.substring(2, idA.length() - 2);
		String idAlbum[] = idA.split("\",\"");

		for (int i = 0; i < idAlbum.length; i++) {
			sbd.deleteAllDateById(idAlbum[i]);
		}

	}

	private void deleteDate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		String idDate = request.getParameter("idDate");

		sbd.deleteDateById(idDate);
		response.sendRedirect(request.getContextPath() + "/GoiDichVuLichBan?flag=3&deletedate=true");
	}

	private void searchAlbum(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void addDate(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
		try {

			String date = request.getParameter("scheduleDate");
			String idA = request.getParameter("arr");
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(java.time.LocalDate.now().toString());

			if (date1.after(date2)) {
				if (idA != null) {
					idA = idA.substring(2, idA.length() - 2);
					String idAlbum[] = idA.split("\",\"");
					for (int i = 0; i < idAlbum.length; i++) {
						sbd.addDateBusy(date, idAlbum[i]);
					}
					response.sendRedirect(request.getContextPath() + "/GoiDichVuLichBan?flag=3&addDate=true");

				}
			} else {
				response.sendRedirect(request.getContextPath() + "/GoiDichVuLichBan?flag=3&addDate=false");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String categoryId = request.getParameter("theloaichup");
		System.out.println("categoryId :" + categoryId);
		List<Category> listC = new ArrayList<>();
		listC = cd.getListCategory();
		request.setAttribute("listC", listC);
		List<ServicePackage> la = new ArrayList<>();
		request.setAttribute("page", paging(String.valueOf(id), categoryId));
		List<ServicePackage> listA = new ArrayList<>();
		if (!categoryId.equals("0")) {
			listA = lad.getListAlbumByCategoryId(categoryId, id, 0);
		} else {
			listA = lad.listAlbum(id, 0);
		}

		for (ServicePackage a : listA) {
			a.setDate(sbd.getDateByAlbumId(a.getId()));
			la.add(a);
		}
		request.setAttribute("theloai", categoryId);
		request.setAttribute("listA", la);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/tho-chup-anh.jsp");
		dispatcher.forward(request, response);

	}

	private void showViews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		List<ServicePackage> listA = new ArrayList<>();
		List<Category> listC = new ArrayList<>();
		listC = cd.getListCategory();
		request.setAttribute("listC", listC);
		request.setAttribute("page", paging(String.valueOf(id), "0"));
		String page = request.getParameter("page");
		String categoryId = request.getParameter("categoryId");
		if (categoryId == null) {
			if (page == null) {
				listA = lad.listAlbum(id, 0);
			} else {
				int paging = (Integer.parseInt(page) - 1) * 3;
				listA = lad.listAlbum(id, paging);
			}
		}else {
			if (page == null) {
				listA = lad.listAlbum(id, 0);
			} else {
				int paging = (Integer.parseInt(page) - 1) * 3;
				if(!categoryId.equals("0")) {
					listA = lad.getListAlbumByCategoryId(categoryId, id, paging);
				}else {
					listA = lad.listAlbum(id, paging);
				}
				
			}
		}

		List<ServicePackage> la = new ArrayList<>();
		for (ServicePackage a : listA) {
			a.setDate(sbd.getDateByAlbumId(a.getId()));
			la.add(a);
		}
		request.setAttribute("theloai", categoryId);
		request.setAttribute("listA", la);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/tho-chup-anh.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	private void deleteAlbum(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String email = (String) session.getAttribute("email");
		int role = (Integer) session.getAttribute("role");
		String idA = request.getParameter("arr");
		idA = idA.substring(2, idA.length() - 2);
		String idAlbum[] = idA.split("\",\"");
		List<Images> listI = new ArrayList<>();

		for (int i = 0; i < idAlbum.length; i++) {
			// xóa ảnh trong db
			String AlbumName = coa.getOneServicePackageById(Integer.parseInt(idAlbum[i])).getServicepackageName();
			String linkAlbum = request.getServletContext()
					.getRealPath("/images/" + email + role + "/albums/" + AlbumName);
			listI = coa.listImages(Integer.parseInt(idAlbum[i]));
			for (int j = 0; j < listI.size(); j++) {
				String fileName = coa.getImageById(listI.get(j).getId()).getImageName();
				fileName = linkAlbum + "/" + fileName;
				if (coa.deleteImage(Integer.parseInt(listI.get(j).getId()))) {
					try {
						File file = new File(fileName);

						if (file.delete()) {

						} else {
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}

			// xóa album
			if (lad.deleteAlbum(idAlbum[i])) {
				try {
					File file = new File(linkAlbum);

					if (file.delete()) {
						System.out.println("dele");
					} else {
						System.out.println("not dele");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
			}
		}

	}

	public List<Integer> paging(String id, String category) {
		if (category.equals("0")) {
			int size = lad.sizeOfListAlbum(id);
			List<Integer> listPage = new ArrayList<>();
			int m = size / 3;
			int n = size % 3;
			if (n != 0) {
				m = m + 1;
			}
			for (int i = 0; i < m; i++) {
				listPage.add(i + 1);
			}
			return listPage;
		} else {
			int size = lad.sizeOfListAlbumByCategory(id, category);
			List<Integer> listPage = new ArrayList<>();
			int m = size / 3;
			int n = size % 3;
			if (n != 0) {
				m = m + 1;
			}
			for (int i = 0; i < m; i++) {
				listPage.add(i + 1);
			}
			return listPage;
		}

	}

}
