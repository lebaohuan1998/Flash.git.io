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
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginServlet")
public class LoginFilter implements Filter {
 
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	/**
	 * @see Filter#destroy()
	 */

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
	        HttpServletRequest request = (HttpServletRequest) req;
	        HttpServletResponse response = (HttpServletResponse) res;
	        HttpSession session = request.getSession();
	        String loginURI = request.getContextPath() + "/LoginServlet";

	        boolean loggedIn = session != null && session.getAttribute("user") != null;
	        boolean loginRequest = request.getRequestURI().equals(loginURI);

	        if (loggedIn | loginRequest) {
	            chain.doFilter(request, response);
	        } else {
	            response.sendRedirect(loginURI);
	        }
	    }


	public void destroy() {
		// TODO Auto-generated method stub
	}

}
