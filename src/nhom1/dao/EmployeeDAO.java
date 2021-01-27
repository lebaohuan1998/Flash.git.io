package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.Employee;
import nhom1.ultility.EmployeeQuery;

public class EmployeeDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	public boolean addEmployee(Employee emp) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(EmployeeQuery.INSERT_EMP);
			preparedStmt.setString(1, emp.getAccount());
			preparedStmt.setString(2, emp.getDepartment());
			preparedStmt.setString(3, emp.getEmployeeAddress());
			preparedStmt.setString(4, emp.getEmployeeBirthDate());
			preparedStmt.setString(5, emp.getEmployeeEmail());
			preparedStmt.setString(6, emp.getEmployeeName());
			preparedStmt.setString(7, emp.getEmployeePhone());
			preparedStmt.setString(8, emp.getPassword());
			preparedStmt.setInt(9, emp.getSex());
			preparedStmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStmt != null) {
					preparedStmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<Employee> getAllEmployee() {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			List<Employee> list = new ArrayList<>();
			preparedStmt = connection.prepareStatement(EmployeeQuery.GETALL_EMP);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String account = rs.getString("employee_account");
				String department = rs.getString("employee_department");
				String employeeAddress = rs.getString("employee_address");
				String employeeBirthDate = rs.getString("employee_birthdate");
				String employeeEmail = rs.getString("employee_email");
				String employeeName = rs.getString("employee_name");
				String employeePhone = rs.getString("employee_phone");
				String password = rs.getString("employee_password");
				int sex = rs.getInt("employee_sex");
				Employee emp = new Employee(employeeId, account, department, employeeAddress, employeeBirthDate,
						employeeEmail, employeeName, employeePhone, password, sex);
				list.add(emp);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStmt != null) {
					preparedStmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean deleteEmployee(int id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(EmployeeQuery.DELETE_EMP);
			preparedStmt.setInt(1, id);
			preparedStmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStmt != null) {
					preparedStmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public List<Employee> getEmployeeByName(String name){
		try {
			connection = ConnectionClass.createConnect().getConnection();
			List<Employee> list = new ArrayList<>();
			preparedStmt = connection.prepareStatement(EmployeeQuery.SEARCH_EMP);
			preparedStmt.setString(1, "%"+name+"%");
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String account = rs.getString("employee_account");
				String department = rs.getString("employee_department");
				String employeeAddress = rs.getString("employee_address");
				String employeeBirthDate = rs.getString("employee_birthdate");
				String employeeEmail = rs.getString("employee_email");
				String employeeName = rs.getString("employee_name");
				String employeePhone = rs.getString("employee_phone");
				String password = rs.getString("employee_password");
				int sex = rs.getInt("employee_sex");
				Employee emp = new Employee(employeeId, account, department, employeeAddress, employeeBirthDate,
						employeeEmail, employeeName, employeePhone, password, sex);
				list.add(emp);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStmt != null) {
					preparedStmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
