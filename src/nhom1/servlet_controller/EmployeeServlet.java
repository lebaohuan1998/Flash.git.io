package nhom1.servlet_controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom1.dao.EmployeeDAO;
import nhom1.model.BookingOffice;
import nhom1.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO empDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
		 empDAO = new EmployeeDAO();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			// route to the appropriate method
			switch (theCommand) {
			case "LIST":
				listEmployee(request, response);
				break;
			case "ADD":
				addEmployee(request, response);
				break;
			case "LOAD_ADD":
				loadEmployeeAdd(request, response);
				break;
			case "UPDATE":
				updateEmployee(request, response);
				break;
			case "DELETE":
				deleteEmployee(request, response);
				break;
			case "SEARCH":
				searchEployee(request, response);
				break;
			default:
				listEmployee(request, response);
			}
		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void searchEployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("nameSearch");
		List<Employee> list = empDAO.getEmployeeByName(name);
		request.setAttribute("LIST_EMP", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/table-employee.jsp");
		dispatcher.forward(request, response);	
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			Integer id = Integer.parseInt(request.getParameter("empID"));
			if (empDAO.deleteEmployee(id)) {
				response.sendRedirect(request.getContextPath() + "/EmployeeServlet");
				request.setAttribute("sucess", "Delete sucessfuly");
			} else {
				request.setAttribute("message", "Something went wrong!");
				request.getRequestDispatcher("/EmployeeServlet").forward(request, response);
			}	
		
			
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

	private void loadEmployeeAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/form-add-employee.jsp");
		dispatcher.forward(request, response);
		
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException, ServletException {
		String account = request.getParameter("employeeAccount");
		String department = request.getParameter("employeeDepartment");
		String employeeAddress = request.getParameter("employeeAddress");
		String employeeBirthDate = request.getParameter("employeeBirthdate");
		String employeeEmail = request.getParameter("employeeEmail");
		String employeeName = request.getParameter("employeeName");
		String employeePhone = request.getParameter("employeePhone");
		String password = request.getParameter("employeePassword");
		int sex = Integer.parseInt(request.getParameter("gender"));
		Employee e = new Employee(account, department, employeeAddress, employeeBirthDate, employeeEmail, employeeName, employeePhone, password, sex);
		if(empDAO.addEmployee(e)) {
			response.sendRedirect(request.getContextPath() + "/EmployeeServlet?success=" + URLEncoder.encode("Add successfuly", "UTF-8"));
		}else {
			request.getRequestDispatcher("/EmployeeServlet?command=LOAD_ADD&message="  + URLEncoder.encode("Something wrong", "UTF-8")).forward(request, response);
		}
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> list = empDAO.getAllEmployee();
		request.setAttribute("LIST_EMP", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form/table-employee.jsp");
		dispatcher.forward(request, response);		
	}

}
