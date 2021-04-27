package nhom1.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CarAdmin
 */
@WebFilter(urlPatterns = {"/admin"})
public class Guest implements Filter {

	/**
	 * Default constructor.
	 */
	public Guest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Object obj = req.getSession().getAttribute("role");
		if (obj != null) {
			if (obj.equals(1)) {
				res.sendRedirect(req.getContextPath() + "/ManagermentAdminSystem");
			} else if (obj.equals(2)) {
				res.sendRedirect(req.getContextPath() + "/ManagermentAdminOperator");
			} else {
				res.sendRedirect(req.getContextPath() + "/HomePageServlet");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
