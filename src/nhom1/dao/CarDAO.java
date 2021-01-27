package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.Car;
import nhom1.model.ParkingLot;
import nhom1.ultility.CarQuery;

public class CarDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	public boolean addCar(Car car) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(CarQuery.INSERT_CAR);
			preparedStmt.setString(1, car.getLicensePlate());
			preparedStmt.setString(2, car.getCarColor());
			preparedStmt.setString(3, car.getCarType());
			preparedStmt.setString(4, car.getCompany());
//			preparedStmt.setInt(5, car.getParkId().getParkId());
			preparedStmt.setInt(5, car.getParkId());
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

	public List<Car> getAllCar() {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			List<Car> list = new ArrayList<>();
			preparedStmt = connection.prepareStatement(CarQuery.GETALL_CAR);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String licensePlate = rs.getString("car_license_plate");
				String carColor = rs.getString("car_color");
				String carType = rs.getString("car_type");
				String carCompany = rs.getString("car_company");
				int parkId = rs.getInt("car_park_id");
//				int parkArea = rs.getInt("park_area");
//				String parkName = rs.getString("park_name");
//				String parkPlace = rs.getString("park_place");
//				double parkPrice = rs.getDouble("park_price");
//				String parkStatus = rs.getString("park_status");				
//				Car car = new Car(licensePlate, carColor, carType, carCompany, new ParkingLot(parkArea, parkName, parkPlace, parkPrice, parkStatus));
				Car car = new Car(licensePlate, carColor, carType, carCompany, parkId);
				list.add(car);
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

	public boolean deleteCar(String licensePlate) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(CarQuery.DELETE_CAR);
			preparedStmt.setString(1, licensePlate);
			preparedStmt.execute();					
			if (preparedStmt.getUpdateCount()<1) {
				return false;
			}
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
	public Car getCarById(String id) {
		try {
			Car car = null;
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(CarQuery.GETBYID_CAR);
			preparedStmt.setString(1, id);
			rs = preparedStmt.executeQuery();
			if (rs.next()) {
				String licensePlate = rs.getString("car_license_plate");
				String carColor = rs.getString("car_color");
				String carType = rs.getString("car_type");
				String carCompany = rs.getString("car_company");
				int parkId = rs.getInt("car_park_id");
//				int parkArea = rs.getInt("park_area");
//				String parkName = rs.getString("park_name");
//				String parkPlace = rs.getString("park_place");
//				double parkPrice = rs.getDouble("park_price");
//				String parkStatus = rs.getString("park_status");

//				car = new Car(licensePlate, carColor, carType, carCompany, new ParkingLot(parkId, parkArea, parkName, parkPlace, parkPrice, parkStatus));
				car = new Car(licensePlate, carColor, carType, carCompany, parkId);
			}
			return car;
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

	public boolean updateCar(Car car, String id) {
		try {
			connection = ConnectionClass.createConnect().getConnection();
			preparedStmt = connection.prepareStatement(CarQuery.UPDATE_CAR);
			preparedStmt.setString(1, car.getCarColor());
			preparedStmt.setString(2, car.getCarType());
			preparedStmt.setString(3, car.getCompany());
//			preparedStmt.setInt(4, car.getParkId().getParkId());
			preparedStmt.setInt(4, car.getParkId());
			preparedStmt.setString(5, car.getLicensePlate());
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
	public List<Car> getCarByLicense(String name){
		try {
			connection = ConnectionClass.createConnect().getConnection();
			List<Car> list = new ArrayList<>();
			preparedStmt = connection.prepareStatement(CarQuery.SEARCH_CAR);
			preparedStmt.setString(1, "%" + name + "%");
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String licensePlate = rs.getString("car_license_plate");
				String carColor = rs.getString("car_color");
				String carType = rs.getString("car_type");
				String carCompany = rs.getString("car_company");
				int parkId = rs.getInt("car_park_id");
//				int parkArea = rs.getInt("park_area");
//				String parkName = rs.getString("park_name");
//				String parkPlace = rs.getString("park_place");
//				double parkPrice = rs.getDouble("park_price");
//				String parkStatus = rs.getString("park_status");				
//				Car car = new Car(licensePlate, carColor, carType, carCompany, new ParkingLot(parkArea, parkName, parkPlace, parkPrice, parkStatus));
				Car car = new Car(licensePlate, carColor, carType, carCompany, parkId);
				list.add(car);
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
