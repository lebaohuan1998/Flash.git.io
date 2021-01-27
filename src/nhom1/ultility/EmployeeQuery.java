package nhom1.ultility;

public interface EmployeeQuery {
	public static final String INSERT_EMP = "INSERT INTO employees(`employee_account`, `employee_department`, `employee_address`, `employee_birthdate`, `employee_email`, `employee_name`, `employee_phone`, `employee_password`, `employee_sex`) VALUES(?,?,?,?,?,?,?,?,?)";
	public static final String DELETE_EMP = "DELETE FROM employees WHERE employee_id=?";
	public static final String GETALL_EMP = "SELECT * FROM employees";
	public static final String SEARCH_EMP = "SELECT * FROM employees WHERE employee_name LIKE ?";
}
