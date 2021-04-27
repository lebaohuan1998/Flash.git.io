package nhom1.servlet_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.InfoServicePackageOfPhotographerDAO;
import nhom1.dao.LocationDAO;
import nhom1.dao.MapPhotographerDAO;
import nhom1.dao.SeacrchPhotographerDAO;
import nhom1.model.MapPhoto;
import nhom1.model.Photographer;

/**
 * Servlet implementation class SearchPhotographer
 */
@WebServlet("/SearchPhotographer")
public class SearchPhotographerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MapPhotographerDAO mpd = new MapPhotographerDAO();
	private SeacrchPhotographerDAO spd = new SeacrchPhotographerDAO();
	private LocationDAO ld = new LocationDAO();
	private InfoServicePackageOfPhotographerDAO iaopd = new InfoServicePackageOfPhotographerDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchPhotographerController() {
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
			String theCommand = request.getParameter("command");
			if (theCommand == null) {
				theCommand = "show";
			}
			switch (theCommand) {
			case "show":
				show(request, response);
				break;
			case "SearchPhotographer":
				searchPhotographerLocation(request, response);
				break;
			case "SearchPhotographerBy":
				searchPhotographerBy(request, response);
				break;
			case "showSearch":
				searchShow(request, response);
				break;
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void searchShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("listLocation", ld.listLocation());
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/Xemnhiepanhgia.jsp");
		dispatcher.forward(request, response);
		session.setAttribute("listPhotographer", null);
		session.setAttribute("care", null);
		session.setAttribute("count", null);
		session.setAttribute("placeId", "0");
		session.setAttribute("categoryId", "0");
		session.setAttribute("textSearch", "");
		session.setAttribute("listPage", null);
		session.setAttribute("searchbylocation", null);
	}

	private void searchPhotographerBy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		try {
			int idUser = (Integer) session.getAttribute("id");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			String page = request.getParameter("page");
			String location = request.getParameter("place");
			String category = request.getParameter("category");
			String textSearch = request.getParameter("textsearch");
			if (textSearch == null) {
				textSearch = "";
			}
			if (category == null) {
				category = "0";
			}
			if (location == null) {
				location = "0";
			}
			if (page == null) {
				page = "1";
			}
			String care = request.getParameter("care");
			request.setAttribute("listLocation", ld.listLocation());
			List<Photographer> listPhotographer = new ArrayList<>();
			listPhotographer = spd.searchBy(location, category, textSearch, (Integer.parseInt(page) - 1) * 6, care);
			for (Photographer photographer : listPhotographer) {
				boolean check = iaopd.checkFollow(photographer.getId(), String.valueOf(idUser));
				if (check == true) {
					photographer.setFollow(true);
				} else {
					photographer.setFollow(false);
				}
			}
			session.setAttribute("listPhotographer", listPhotographer);
			int count = spd.countPhotographerBy(location, category, textSearch);
			session.setAttribute("count", count);
			List<Integer> listPage = new ArrayList<>();
			int numberPage = count / 6;
			if (count % 6 != 0) {
				numberPage = numberPage + 1;
			}
			for (int i = 0; i < numberPage; i++) {
				listPage.add(i);
			}
			session.setAttribute("placeId", location);
			session.setAttribute("categoryId", category);
			session.setAttribute("textSearch", textSearch);
			session.setAttribute("care", care);
			session.setAttribute("listPage", listPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("form/Xemnhiepanhgia.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			String page = request.getParameter("page");
			String location = request.getParameter("place");
			String category = request.getParameter("category");
			String textSearch = request.getParameter("textsearch");
			if (textSearch == null) {
				textSearch = "";
			}
			if (category == null) {
				category = "0";
			}
			if (location == null) {
				location = "0";
			}
			if (page == null) {
				page = "1";
			}
			String care = request.getParameter("care");
			request.setAttribute("listLocation", ld.listLocation());
			List<Photographer> listPhotographer = new ArrayList<>();
			listPhotographer = spd.searchBy(location, category, textSearch, (Integer.parseInt(page) - 1) * 6, care);
			session.setAttribute("listPhotographer", listPhotographer);
			int count = spd.countPhotographerBy(location, category, textSearch);
			session.setAttribute("count", count);
			List<Integer> listPage = new ArrayList<>();
			int numberPage = count / 6;
			if (count % 6 != 0) {
				numberPage = numberPage + 1;
			}
			for (int i = 0; i < numberPage; i++) {
				listPage.add(i);
			}
			session.setAttribute("placeId", location);
			session.setAttribute("categoryId", category);
			session.setAttribute("textSearch", textSearch);
			session.setAttribute("care", care);
			session.setAttribute("listPage", listPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("form/Xemnhiepanhgia.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	private void searchPhotographerLocation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// TODO Auto-generated method stub
		try {
			int idUser = (Integer) session.getAttribute("id");
			String type = request.getParameter("searchByLocation");
			String location = request.getParameter("place");
			String category = request.getParameter("category");
			String textSearch = request.getParameter("textsearch");
			String care = request.getParameter("care");
			String page = request.getParameter("page");
			String locationx = "0";
			String locationy = "0";
			if (type != null) {
				locationx = (String) session.getAttribute("x");
				locationy = (String) session.getAttribute("y");
			} else {
				locationx = request.getParameter("x");
				locationy = request.getParameter("y");
				session.setAttribute("x", String.valueOf(locationx));
				session.setAttribute("y", String.valueOf(locationy));
			}
			float x = Float.parseFloat(locationx);
			float y = Float.parseFloat(locationy);
			List<MapPhoto> listM = new ArrayList<>();
			request.setAttribute("listLocation", ld.listLocation());
			List<Photographer> listP;
			listP = spd.searchByLocation(location, category, textSearch);
			for (Photographer photographer : listP) {
				listM.add(mpd.getLocationPhotographerById(photographer.getId()));
			}
			List<Photographer> listPhotographer = new ArrayList<>();
			// tính khoảng cách
			for (MapPhoto mapPhoto : listM) {
				if (mapPhoto.getLocationy() != null && mapPhoto.getLocationx() != null) {
					float d = distFrom(x, y, Float.parseFloat(mapPhoto.getLocationx()),
							Float.parseFloat(mapPhoto.getLocationy()));
					System.out.println("khoang cach :"+d);
					if (d <= 20000) {// Khoảng cách tìm kiếm
						listPhotographer.add(spd.searchPhotographerById(mapPhoto.getId()));
						for (Photographer photographer : listPhotographer) {
							boolean check = iaopd.checkFollow(photographer.getId(), String.valueOf(idUser));
							if (check == true) {
								photographer.setFollow(true);
							} else {
								photographer.setFollow(false);
							}
						}
					}
				}
			}
			if (page == null) {
				page = "1";
			}
			List<Photographer> listPhotographerResult = new ArrayList<>();
			if (listPhotographer.size() < 6) {
				for (int i = ((Integer.parseInt(page) - 1) * 6); i < listPhotographer.size(); i++) {
					listPhotographerResult.add(listPhotographer.get(i));
				}
			} else if (listPhotographer.size() % 6 == 0&&!page.equals("1")) {
				for (int i = ((Integer.parseInt(page) - 1) * 6); i < (Integer.parseInt(page)) * 6; i++) {
					listPhotographerResult.add(listPhotographer.get(i));
				}
			} else if (listPhotographer.size() % 6 != 0&&!page.equals("1")) {
				for (int i = (Integer.parseInt(page) - 1) * 6; i < ((Integer.parseInt(page) - 1) * 6 + (listPhotographer.size() / 6)); i++) {
					listPhotographerResult.add(listPhotographer.get(i));
				}
			}else if (page.equals("1")) {
				for (int i = ((Integer.parseInt(page) - 1) * 6); i <6; i++) {
					listPhotographerResult.add(listPhotographer.get(i));
				}
			}

			session.setAttribute("listPhotographer", listPhotographerResult);
			int count = listPhotographer.size();
			session.setAttribute("count", count);
			List<Integer> listPage = new ArrayList<>();
			int numberPage = count / 6;
			if (count % 6 != 0) {
				numberPage = numberPage + 1;
			}
			for (int i = 0; i < numberPage; i++) {
				listPage.add(i);
			}
			session.setAttribute("placeId", location);
			session.setAttribute("categoryId", category);
			session.setAttribute("textSearch", textSearch);
			session.setAttribute("care", care);
			session.setAttribute("listPage", listPage);
			session.setAttribute("searchbylocation", "yes");
			RequestDispatcher dispatcher = request.getRequestDispatcher("form/Xemnhiepanhgia.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			String type = request.getParameter("searchByLocation");
			String location = request.getParameter("place");
			String category = request.getParameter("category");
			String textSearch = request.getParameter("textsearch");
			String care = request.getParameter("care");
			String page = request.getParameter("page");
			String locationx = "0";
			String locationy = "0";
			if (type != null) {
				locationx = (String) session.getAttribute("x");
				locationy = (String) session.getAttribute("y");
			} else {
				locationx = request.getParameter("x");
				locationy = request.getParameter("y");
				session.setAttribute("x", String.valueOf(locationx));
				session.setAttribute("y", String.valueOf(locationy));
			}
			float x = Float.parseFloat(locationx);
			float y = Float.parseFloat(locationy);
			List<MapPhoto> listM = new ArrayList<>();
			request.setAttribute("listLocation", ld.listLocation());
			List<Photographer> listP;
			listP = spd.searchByLocation(location, category, textSearch);
			for (Photographer photographer : listP) {
				listM.add(mpd.getLocationPhotographerById(photographer.getId()));
			}
			List<Photographer> listPhotographer = new ArrayList<>();
			// tính khoảng cách
			for (MapPhoto mapPhoto : listM) {
				if (mapPhoto.getLocationy() != null && mapPhoto.getLocationx() != null) {
					float d = distFrom(x, y, Float.parseFloat(mapPhoto.getLocationx()),
							Float.parseFloat(mapPhoto.getLocationy()));
					System.out.println("khoang cach :"+d);
					if (d <= 20000) {// Khoảng cách tìm kiếm
						listPhotographer.add(spd.searchPhotographerById(mapPhoto.getId()));
						
					}
				}
			}
			if (page == null) {
				page = "1";
			}
			List<Photographer> listPhotographerResult = new ArrayList<>();
			if (listPhotographer.size() < 6) {
				for (int i = ((Integer.parseInt(page) - 1) * 6); i < listPhotographer.size(); i++) {
					listPhotographerResult.add(listPhotographer.get(i));
				}
			} else if (listPhotographer.size() % 6 == 0&&!page.equals("1")) {
				for (int i = ((Integer.parseInt(page) - 1) * 6); i < (Integer.parseInt(page)) * 6; i++) {
					listPhotographerResult.add(listPhotographer.get(i));
				}
			} else if (listPhotographer.size() % 6 != 0&&!page.equals("1")) {
				for (int i = (Integer.parseInt(page) - 1) * 6; i < ((Integer.parseInt(page) - 1) * 6 + (listPhotographer.size() / 6)); i++) {
					listPhotographerResult.add(listPhotographer.get(i));
				}
			}else if (page.equals("1")) {
				for (int i = ((Integer.parseInt(page) - 1) * 6); i <6; i++) {
					listPhotographerResult.add(listPhotographer.get(i));
				}
			}

			session.setAttribute("listPhotographer", listPhotographerResult);
			int count = listPhotographer.size();
			session.setAttribute("count", count);
			List<Integer> listPage = new ArrayList<>();
			int numberPage = count / 6;
			if (count % 6 != 0) {
				numberPage = numberPage + 1;
			}
			for (int i = 0; i < numberPage; i++) {
				listPage.add(i);
			}
			session.setAttribute("placeId", location);
			session.setAttribute("categoryId", category);
			session.setAttribute("textSearch", textSearch);
			session.setAttribute("care", care);
			session.setAttribute("listPage", listPage);
			session.setAttribute("searchbylocation", "yes");
			RequestDispatcher dispatcher = request.getRequestDispatcher("form/Xemnhiepanhgia.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	public float distFrom(float lat1, float lng1, float lat2, float lng2) {
		double earthRadius = 6371000; // meters
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(dLng / 2) * Math.sin(dLng / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		float dist = (float) (earthRadius * c);
		return dist;
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		try {
			int idUser = (Integer) session.getAttribute("id");
			String page = request.getParameter("page");
			String location = request.getParameter("place");
			String category = request.getParameter("category");
			System.out.println(page + "|" + location + "|" + category);
			request.setAttribute("listLocation", ld.listLocation());
			List<Photographer> listPhotographer = new ArrayList<>();
			if (page == null) {
				listPhotographer = spd.getListPhotographer(0);
				for (Photographer photographer : listPhotographer) {
					boolean check = iaopd.checkFollow(photographer.getId(), String.valueOf(idUser));
					if (check == true) {
						photographer.setFollow(true);
					} else {
						photographer.setFollow(false);
					}
				}
				request.setAttribute("listPhotographer", listPhotographer);

			} else if (page != null) {
				listPhotographer = spd.getListPhotographer((Integer.parseInt(page) - 1) * 6);
				for (Photographer photographer : listPhotographer) {
					boolean check = iaopd.checkFollow(photographer.getId(), String.valueOf(idUser));
					if (check == true) {
						photographer.setFollow(true);
					} else {
						photographer.setFollow(false);
					}
				}
				request.setAttribute("listPhotographer", listPhotographer);
			}
			int count = spd.countPhotographer();
			System.out.println(count);
			request.setAttribute("count", count);
			List<Integer> listPage = new ArrayList<>();
			int numberPage = count / 6;
			if (count % 6 != 0) {
				numberPage = numberPage + 1;
			}
			for (int i = 0; i < numberPage; i++) {
				listPage.add(i);
			}
			request.setAttribute("listPage", listPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("form/Xemnhiepanhgia.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			String page = request.getParameter("page");
			String location = request.getParameter("place");
			String category = request.getParameter("category");
			System.out.println(page + "|" + location + "|" + category);
			request.setAttribute("listLocation", ld.listLocation());
			List<Photographer> listPhotographer = new ArrayList<>();
			if (page == null) {
				listPhotographer = spd.getListPhotographer(0);
				request.setAttribute("listPhotographer", listPhotographer);
			} else if (page != null) {
				listPhotographer = spd.getListPhotographer((Integer.parseInt(page) - 1) * 6);
				request.setAttribute("listPhotographer", listPhotographer);
			}
			int count = spd.countPhotographer();
			System.out.println(count);
			request.setAttribute("count", count);
			List<Integer> listPage = new ArrayList<>();
			int numberPage = count / 6;
			if (count % 6 != 0) {
				numberPage = numberPage + 1;
			}
			for (int i = 0; i < numberPage; i++) {
				listPage.add(i);
			}
			request.setAttribute("listPage", listPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("form/Xemnhiepanhgia.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			int idUser = (Integer) session.getAttribute("id");
			String location = request.getParameter("place");
			String category = request.getParameter("category");
			String textSearch = request.getParameter("textsearch");
			request.setAttribute("listLocation", ld.listLocation());
			List<Photographer> listPhotographer = new ArrayList<>();
			listPhotographer = spd.searchBy(location, category, textSearch, 0, null);
			for (Photographer photographer : listPhotographer) {
				boolean check = iaopd.checkFollow(photographer.getId(), String.valueOf(idUser));
				if (check == true) {
					photographer.setFollow(true);
				} else {
					photographer.setFollow(false);
				}
			}
			request.setAttribute("listPhotographer", listPhotographer);
			int count = spd.countPhotographerBy(location, category, textSearch);
			request.setAttribute("count", count);
			List<Integer> listPage = new ArrayList<>();
			int numberPage = count / 6;
			if (count % 6 != 0) {
				numberPage = numberPage + 1;
			}
			for (int i = 0; i < numberPage; i++) {
				listPage.add(i);
			}
			request.setAttribute("placeId", location);
			request.setAttribute("categoryId", category);
			request.setAttribute("textSearch", textSearch);
			session.setAttribute("care", null);
			request.setAttribute("listPage", listPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("form/Xemnhiepanhgia.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			String location = request.getParameter("place");
			String category = request.getParameter("category");
			String textSearch = request.getParameter("textsearch");
			request.setAttribute("listLocation", ld.listLocation());
			List<Photographer> listPhotographer = new ArrayList<>();
			listPhotographer = spd.searchBy(location, category, textSearch, 0, null);
			request.setAttribute("listPhotographer", listPhotographer);
			int count = spd.countPhotographerBy(location, category, textSearch);
			request.setAttribute("count", count);
			List<Integer> listPage = new ArrayList<>();
			int numberPage = count / 6;
			if (count % 6 != 0) {
				numberPage = numberPage + 1;
			}
			for (int i = 0; i < numberPage; i++) {
				listPage.add(i);
			}
			request.setAttribute("placeId", location);
			request.setAttribute("categoryId", category);
			request.setAttribute("textSearch", textSearch);
			session.setAttribute("care", null);
			request.setAttribute("listPage", listPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("form/Xemnhiepanhgia.jsp");
			dispatcher.forward(request, response);
		}
		
		

	}

}
