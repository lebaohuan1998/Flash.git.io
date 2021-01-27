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
 * Servlet Filter implementation class CheckLogined
 */
@WebFilter("/LoginServlet")
public class CheckLogined implements Filter {

    /**
     * Default constructor. 
     */
    public CheckLogined() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Object obj = req.getSession().getAttribute("role");
		if(obj == null) {
		chain.doFilter(request, response);
		} else if(obj != null && obj.equals("1")) {
			res.sendRedirect(req.getContextPath() + "/EmployeeServlet");
		} else if(obj != null && obj.equals("2")) {
			res.sendRedirect(req.getContextPath() + "/CarServlet");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
