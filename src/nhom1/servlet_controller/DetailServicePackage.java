package nhom1.servlet_controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom1.dao.ArticleDAO;
import nhom1.dao.BookingDAO;
import nhom1.dao.FLowListServicePackageDAO;
import nhom1.dao.InfoServicePackageOfPhotographerDAO;
import nhom1.dao.ListImageDAO;
import nhom1.dao.PhotographerInfoDAO;
import nhom1.dao.RatingServicePackageDAO;
import nhom1.dao.ScheduleAvailableDAO;
import nhom1.dao.ServicePackageDAO;
import nhom1.dao.UserProfileInfoDAO;
import nhom1.model.Booking;
import nhom1.model.Images;
import nhom1.model.User;
import nhom1.model.Photographer;
import nhom1.model.RatingServicePackage;
import nhom1.model.ScheduleAvailable;
import nhom1.model.ServicePackage;

/**
 * Servlet implementation class DetailServicePackage
 */
@WebServlet("/servicePackage")
public class DetailServicePackage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InfoServicePackageOfPhotographerDAO ip = new InfoServicePackageOfPhotographerDAO();
	private ListImageDAO li = new ListImageDAO();
	private PhotographerInfoDAO up = new PhotographerInfoDAO();
	private RatingServicePackageDAO rs = new RatingServicePackageDAO();
	private ScheduleAvailableDAO sad = new ScheduleAvailableDAO();
	private FLowListServicePackageDAO fsp = new FLowListServicePackageDAO();
	private UserProfileInfoDAO un = new UserProfileInfoDAO();
	private ServicePackageDAO spd = new ServicePackageDAO();
	private BookingDAO ba = new BookingDAO();
	private ArticleDAO art = new ArticleDAO();

	public DetailServicePackage() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.setAttribute("bookingNoti", "Bạn đặt chụp thành công! vui lòng theo
		// dõi trạng thái đơn hàng");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			// read the "command" parameter
			// request.setAttribute("clickBooking", "enable");
			String command = request.getParameter("command");
			if (command == null) {
				command = "show";
			}
			switch (command) {
			case "show":
				showView(request, response);
				break;
			case "rating":
				ratingServicePackage(request, response);
				break;

			case "FOLLOW":
				addFollowPhotographer(request, response);
				break;

			case "booking":
				bookingServicePackage(request, response);

				break;

			case "SaveServicePackage":
				addFollowServicePackage(request, response);
				break;
			default:
				showView(request, response);
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void autoCancelBooking(HttpServletRequest request, HttpServletResponse response)
			throws InterruptedException, ExecutionException {
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("id");
		String userIdString = String.valueOf(userId);

		String spId = (String) request.getParameter("idServicePackagex");
		int servicePackageId = Integer.parseInt(spId);
		// run schedule auto cancel order
		int id = ba.getID(userId, servicePackageId);
		String name = "tính năng tự động hủy của Flash";
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(6);
		ScheduledFuture<String> scheduledFuture = executor.schedule(new Callable<String>() {
			@Override
			public String call() throws Exception {
				if (ba.getStatusBooking(userId, servicePackageId) == 1) {
					ba.updateStatusBooking(name, id, 1);
				}

				return "Called!";
			}
		}, 5, TimeUnit.MINUTES);

		System.out.println("result = " + scheduledFuture.get());
		executor.shutdown();

	}

	private void bookingServicePackage(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ParseException, InterruptedException, ExecutionException {
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("id");
		String userIdString = String.valueOf(userId);
		// String userIdx= (String) request.getParameter("idUserx");
		String spId = (String) request.getParameter("idServicePackagex");
		int servicePackageId = Integer.parseInt(spId);
		ServicePackage sp = new ServicePackage();
		sp = spd.getOneServicePackageById(servicePackageId);

		String takeDate = (String) request.getParameter("idDate");
		// System.out.println("in thu ngay"+takeDate);

		Date date = Date.valueOf(takeDate);
//		 SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");  
//		 java.util.Date date = formatter1.parse("2018-09-09");

		// System.out.println("in thu ngay 2"+date);
		String note = request.getParameter("idText");
		String phone = request.getParameter("idPhone");
		int price = sp.getPrice();
		int deposit = sp.getDeposit();
		String description = sp.getDescription();
		String categoryId = sp.getCategoryId();
		String shootingLocationId = sp.getShootingLocation();

		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		// LocalDateTime now = LocalDateTime.now();
		// System.out.println(dtf.format(now));
		// request.setAttribute("bookingNoti", "Bạn đặt chụp thành công! vui lòng theo
		// dõi trạng thái đơn hàng");
		// Date takeDate2= Date(now);
		Booking b = new Booking(userIdString, spId, price, deposit, description, shootingLocationId, categoryId, note,
				phone, date);

		// System.out.println("vao den day roi");
		if (ba.getConditionBooking(userId, servicePackageId, 1) == 0) {
			if (ba.createBooking(b)) {
				// request.setAttribute("hideRating", "yes");
				response.sendRedirect(request.getContextPath() + "/servicePackage?spID=" + spId + "&booking=true");
				autoCancelBooking(request, response);

			} else {
				response.sendRedirect(request.getContextPath() + "/servicePackage?spID=" + spId + "&booking=false");

			}
		} else {
			System.out.println("tao van tan day roi sao ko bang trang");
			response.sendRedirect(request.getContextPath() + "/servicePackage?spID=" + spId + "&booking=false");
		}
	}

	private void addFollowServicePackage(HttpServletRequest request, HttpServletResponse response) {
		try {
			String idServicePackage = request.getParameter("id1");
			String idUser = request.getParameter("id2");
			fsp.FollowServicePackage(idServicePackage, idUser);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void addFollowPhotographer(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String idPhoto = request.getParameter("id1");
			String idUser = request.getParameter("id2");
			ip.addFollow(idPhoto, idUser);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void ratingServicePackage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

//		request.setAttribute("hideRating", "yes");
		String in = (String) request.getParameter("input-9Rating");
		// System.out.println("in="+in);
		HttpSession session = request.getSession();

		if (in.equalsIgnoreCase("1") || in.equalsIgnoreCase("2") || in.equalsIgnoreCase("3") || in.equalsIgnoreCase("4")
				|| in.equalsIgnoreCase("5")) {
			int userID = (int) session.getAttribute("id");
			String spID = (String) request.getParameter("spID");
			int servicePackageID = Integer.parseInt(spID);
			String content = request.getParameter("inputComment");
			content = content.replaceAll("<", " ");
			content = content.replaceAll(">", " ");

			int pointStar = Integer.parseInt(request.getParameter("input-9Rating"));
			long millis = System.currentTimeMillis();
			java.sql.Date ratingDate = new java.sql.Date(millis);
			boolean flagRating = false;

			RatingServicePackage r = new RatingServicePackage(servicePackageID, userID, content, pointStar, flagRating,
					ratingDate);
			RatingServicePackageDAO rsp = new RatingServicePackageDAO();
			if (rsp.insertRating(r)) {
				request.setAttribute("hideRating", "yes");
				response.sendRedirect(request.getContextPath() + "/servicePackage?spID=" + spID);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("form/pagenotfound.jsp");
				dispatcher.forward(request, response);
			}

//	
//			RequestDispatcher dispatcher = request.getRequestDispatcher("form/danhgiaalbum.jsp");
//			dispatcher.forward(request, response);

		}

	}

	private void showView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("showFollow", "no");
		request.setAttribute("hideRating", "yes");
		HttpSession session = request.getSession();
		User n = new User();
		// System.out.println("role la bao nhieu"+session.getAttribute("role"));
		String spID = (String) request.getParameter("spID");
		int servicePackageID = Integer.parseInt(spID);
		List<Images> listI = new ArrayList<>();
		listI = li.getListImages(spID);
		request.setAttribute("listServiecPakage", art.getServicePackageArticle());
		request.setAttribute("listImages", listI);
		ServicePackage a = new ServicePackage();
		a = rs.getInfoAlbum(servicePackageID);
		request.setAttribute("album", a);
		String photographerID = a.getPhotographerID();

		// System.out.println(""+photographerID);
		int photoID = Integer.parseInt(photographerID);
		Photographer pom = up.getInfo(photoID);

		request.setAttribute("idPhoto", photoID);

		if (session.getAttribute("role") != null) {
			int checkRole = (int) session.getAttribute("role");

			if (checkRole == 3) {

				int userID = (int) session.getAttribute("id");
				n = un.getInfo(userID);
				request.setAttribute("phoneNumber", n.getNumberPhone());
				// System.out.println("so dienn thoai"+n.getNumberPhone());
				request.setAttribute("userID", userID);
				request.setAttribute("userDetail", n);
				request.setAttribute("hideRating", "no");
				// System.out.println("vao day chua"+userID);
				// request.setAttribute("showFollow", "yes");
				request.setAttribute("idUser", userID);
				request.setAttribute("idServicePackage", spID);
				// request.setAttribute("showSaved", "yes");

				if (ba.getStatusBooking(userID, servicePackageID) == 1) {
					request.setAttribute("clickBooking", "disable");
				} else if (ba.getStatusBooking(userID, servicePackageID) != 1) {
					request.setAttribute("clickBooking", "enable");
				}

				if (fsp.checkFollowSericePackage(spID, String.valueOf(userID))) {
					request.setAttribute("showSaved", "yes");
				} else {
					request.setAttribute("showSaved", "no");
				}

				if (ip.checkFollow(photographerID, String.valueOf(userID))) {
					request.setAttribute("showFollowed", "yes");
				} else {
					request.setAttribute("showFollowed", "no");
				}
			}
		}

		else {
			request.setAttribute("clickBooking", "noUser");
		}

		List<ScheduleAvailable> b = new ArrayList<>();
		// request.setAttribute("dateWork", b);

		b = sad.getDateServicePackage(servicePackageID);

		request.setAttribute("dateWork", b);
		if (b.isEmpty()) {
			request.setAttribute("hideDate", "yes");
		}
		// System.out.println("xem id==="+b.get(0).getId());

		request.setAttribute("pom", pom);
		request.setAttribute("rolePhotographer", "4");
		request.setAttribute("servicePackageID", spID);
		// request.setAttribute("photographerID",photographerID);

		List<RatingServicePackage> listComment = new ArrayList<>();
		request.setAttribute("hidePageComment", "no");
		request.setAttribute("roleUser", "3");
		int countComment = rs.sizeofListComment(servicePackageID);
		request.setAttribute("countComment", countComment);

		if (countComment == 0) {

			// request.setAttribute("noComment", "ChÆ°a cĂ³ bĂ¬nh luáº­n trong gĂ³i chá»¥p
			// nĂ y");
			request.setAttribute("hidePageComment", "yes");
		}

		else {
			request.setAttribute("hidePageComment", "no");

			request.setAttribute("page", paging(servicePackageID));
			String page = request.getParameter("page");
			if (page == null) {
				listComment = rs.listCommmentServicePackage(servicePackageID, 0);
			} else {
				int paging = (Integer.parseInt(page) - 1) * 5;
				listComment = rs.listCommmentServicePackage(servicePackageID, paging);
			}
		}
		request.setAttribute("listComment", listComment);

		RequestDispatcher dispatcher = request.getRequestDispatcher("form/danhgiaalbum.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

	public List<Integer> paging(int id) {
		int size = rs.sizeofListComment(id);
		System.out.println("size:" + size);
		List<Integer> listPage = new ArrayList<>();
		int m = size / 5;
		int n = size % 5;
		if (n != 0) {
			m = m + 1;
		}
		for (int i = 0; i < m; i++) {
			listPage.add(i + 1);
		}
		return listPage;
	}

}
