package nhom1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom1.connection.ConnectionClass;
import nhom1.model.ServicePackage;
import nhom1.ultility.ServicePackageQuery;
import nhom1.ultility.NormalUserQuery;

public class SearchServicePackageDAO {
	private Connection connection;
	private PreparedStatement preparedStmt;
	private ResultSet rs;

	public List<ServicePackage> searchPackage(int workPlaceId, int categoryId, int price, int paging, String textSearch,
			String date, String sort) {
		if (sort == null) {
			sort = "";
		}
		if(date==null) {
			date="";
		}
		try {
			List<ServicePackage> listS = new ArrayList<>();
			connection = ConnectionClass.createConnect().getConnection();
			if (sort.equals("")) {
				if (date.equals("")) {// date
					if (textSearch.equals("")) {// text
						if (workPlaceId == 0 && categoryId == 0 && price == 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE);
							preparedStmt.setInt(1, paging);
						} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123);
							preparedStmt.setInt(1, workPlaceId);
							preparedStmt.setInt(2, categoryId);
							preparedStmt.setInt(3, price);
							preparedStmt.setInt(4, paging);
						} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23);
							preparedStmt.setInt(1, categoryId);
							preparedStmt.setInt(2, price);
							preparedStmt.setInt(3, paging);
						} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13);
							preparedStmt.setInt(1, workPlaceId);
							preparedStmt.setInt(2, price);
							preparedStmt.setInt(3, paging);
						} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12);
							preparedStmt.setInt(1, workPlaceId);
							preparedStmt.setInt(2, categoryId);
							preparedStmt.setInt(3, paging);
						} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1);
							preparedStmt.setInt(1, workPlaceId);
							preparedStmt.setInt(2, paging);
						} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2);
							preparedStmt.setInt(1, categoryId);
							preparedStmt.setInt(2, paging);
						} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3);
							preparedStmt.setInt(1, price);
							preparedStmt.setInt(2, paging);
						}
					} else {// text
						if (workPlaceId == 0 && categoryId == 0 && price == 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGETEXT);
							preparedStmt.setString(1, "%" + textSearch + "%");
							preparedStmt.setString(2, "%" + textSearch + "%");
							preparedStmt.setInt(3, paging);
						} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123TEXT);
							preparedStmt.setString(1, "%" + textSearch + "%");
							preparedStmt.setString(2, "%" + textSearch + "%");
							preparedStmt.setInt(3, workPlaceId);
							preparedStmt.setInt(4, categoryId);
							preparedStmt.setInt(5, price);
							preparedStmt.setInt(6, paging);
						} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23TEXT);
							preparedStmt.setString(1, "%" + textSearch + "%");
							preparedStmt.setString(2, "%" + textSearch + "%");
							preparedStmt.setInt(3, categoryId);
							preparedStmt.setInt(4, price);
							preparedStmt.setInt(5, paging);
						} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13TEXT);
							preparedStmt.setString(1, "%" + textSearch + "%");
							preparedStmt.setString(2, "%" + textSearch + "%");
							preparedStmt.setInt(3, workPlaceId);
							preparedStmt.setInt(4, price);
							preparedStmt.setInt(5, paging);
						} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12TEXT);
							preparedStmt.setString(1, "%" + textSearch + "%");
							preparedStmt.setString(2, "%" + textSearch + "%");
							preparedStmt.setInt(3, workPlaceId);
							preparedStmt.setInt(4, categoryId);
							preparedStmt.setInt(5, paging);
						} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
							System.out.println("+");
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1TEXT);
							preparedStmt.setString(1, "%" + textSearch + "%");
							preparedStmt.setString(2, "%" + textSearch + "%");
							preparedStmt.setInt(3, workPlaceId);
							preparedStmt.setInt(4, paging);
						} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2TEXT);
							preparedStmt.setString(1, "%" + textSearch + "%");
							preparedStmt.setString(2, "%" + textSearch + "%");
							preparedStmt.setInt(3, categoryId);
							preparedStmt.setInt(4, paging);
						} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3TEXT);
							preparedStmt.setString(1, "%" + textSearch + "%");
							preparedStmt.setString(2, "%" + textSearch + "%");
							preparedStmt.setInt(3, price);
							preparedStmt.setInt(4, paging);
						}
					}
				} else {// date
					if (textSearch.equals("")) {// text
						if (workPlaceId == 0 && categoryId == 0 && price == 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGEDATE);
							preparedStmt.setString(1, date);
							preparedStmt.setInt(2, paging);
						} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123DATE);
							preparedStmt.setString(1, date);
							preparedStmt.setInt(2, workPlaceId);
							preparedStmt.setInt(3, categoryId);
							preparedStmt.setInt(4, price);
							preparedStmt.setInt(5, paging);
						} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23DATE);
							preparedStmt.setString(1, date);
							preparedStmt.setInt(2, categoryId);
							preparedStmt.setInt(3, price);
							preparedStmt.setInt(4, paging);
						} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13DATE);
							preparedStmt.setString(1, date);
							preparedStmt.setInt(2, workPlaceId);
							preparedStmt.setInt(3, price);
							preparedStmt.setInt(4, paging);
						} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12DATE);
							preparedStmt.setString(1, date);
							preparedStmt.setInt(2, workPlaceId);
							preparedStmt.setInt(3, categoryId);
							preparedStmt.setInt(4, paging);
						} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1DATE);
							preparedStmt.setString(1, date);
							preparedStmt.setInt(2, workPlaceId);
							preparedStmt.setInt(3, paging);
						} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2DATE);
							preparedStmt.setString(1, date);
							preparedStmt.setInt(2, categoryId);
							preparedStmt.setInt(3, paging);
						} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
							preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3DATE);
							preparedStmt.setString(1, date);
							preparedStmt.setInt(2, price);
							preparedStmt.setInt(3, paging);
						}
					} else {
						if (workPlaceId == 0 && categoryId == 0 && price == 0) {
							preparedStmt = connection
									.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGETEXTDATE);
							preparedStmt.setString(1, date);
							preparedStmt.setString(2, "%" + textSearch + "%");
							preparedStmt.setString(3, "%" + textSearch + "%");
							preparedStmt.setInt(4, paging);
						} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
							preparedStmt = connection
									.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123TEXTDATE);
							preparedStmt.setString(1, date);
							preparedStmt.setString(2, "%" + textSearch + "%");
							preparedStmt.setString(3, "%" + textSearch + "%");
							preparedStmt.setInt(4, workPlaceId);
							preparedStmt.setInt(5, categoryId);
							preparedStmt.setInt(6, price);
							preparedStmt.setInt(7, paging);
						} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
							preparedStmt = connection
									.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23TEXTDATE);
							preparedStmt.setString(1, date);
							preparedStmt.setString(2, "%" + textSearch + "%");
							preparedStmt.setString(3, "%" + textSearch + "%");
							preparedStmt.setInt(4, categoryId);
							preparedStmt.setInt(5, price);
							preparedStmt.setInt(6, paging);
						} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
							preparedStmt = connection
									.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13TEXTDATE);
							preparedStmt.setString(1, date);
							preparedStmt.setString(2, "%" + textSearch + "%");
							preparedStmt.setString(3, "%" + textSearch + "%");
							preparedStmt.setInt(4, workPlaceId);
							preparedStmt.setInt(5, price);
							preparedStmt.setInt(6, paging);
						} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
							preparedStmt = connection
									.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12TEXTDATE);
							preparedStmt.setString(1, date);
							preparedStmt.setString(2, "%" + textSearch + "%");
							preparedStmt.setString(3, "%" + textSearch + "%");
							preparedStmt.setInt(4, workPlaceId);
							preparedStmt.setInt(5, categoryId);
							preparedStmt.setInt(6, paging);
						} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
							System.out.println("+");
							preparedStmt = connection
									.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1TEXTDATE);
							preparedStmt.setString(1, date);
							preparedStmt.setString(2, "%" + textSearch + "%");
							preparedStmt.setString(3, "%" + textSearch + "%");
							preparedStmt.setInt(4, workPlaceId);
							preparedStmt.setInt(5, paging);
						} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
							preparedStmt = connection
									.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2TEXTDATE);
							preparedStmt.setString(1, date);
							preparedStmt.setString(2, "%" + textSearch + "%");
							preparedStmt.setString(3, "%" + textSearch + "%");
							preparedStmt.setInt(4, categoryId);
							preparedStmt.setInt(5, paging);
						} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
							preparedStmt = connection
									.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3TEXTDATE);
							preparedStmt.setString(1, date);
							preparedStmt.setString(2, "%" + textSearch + "%");
							preparedStmt.setString(3, "%" + textSearch + "%");
							preparedStmt.setInt(4, price);
							preparedStmt.setInt(5, paging);
						}
					}
				}
			} else {
				if (sort.equals("1")) {
					if (date.equals("")) {// date
						if (textSearch.equals("")) {// text
							if (workPlaceId == 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGESORT1);
								preparedStmt.setInt(1, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123SORT1);
								preparedStmt.setInt(1, workPlaceId);
								preparedStmt.setInt(2, categoryId);
								preparedStmt.setInt(3, price);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23SORT1);
								preparedStmt.setInt(1, categoryId);
								preparedStmt.setInt(2, price);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13SORT1);
								preparedStmt.setInt(1, workPlaceId);
								preparedStmt.setInt(2, price);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12SORT1);
								preparedStmt.setInt(1, workPlaceId);
								preparedStmt.setInt(2, categoryId);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1SORT1);
								preparedStmt.setInt(1, workPlaceId);
								preparedStmt.setInt(2, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2SORT1);
								preparedStmt.setInt(1, categoryId);
								preparedStmt.setInt(2, paging);
							} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3SORT1);
								preparedStmt.setInt(1, price);
								preparedStmt.setInt(2, paging);
							}
						} else {// text
							if (workPlaceId == 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGETEXTSORT1);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123TEXTSORT1);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, workPlaceId);
								preparedStmt.setInt(4, categoryId);
								preparedStmt.setInt(5, price);
								preparedStmt.setInt(6, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23TEXTSORT1);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, categoryId);
								preparedStmt.setInt(4, price);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13TEXTSORT1);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, workPlaceId);
								preparedStmt.setInt(4, price);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12TEXTSORT1);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, workPlaceId);
								preparedStmt.setInt(4, categoryId);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
								System.out.println("+");
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1TEXTSORT1);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, workPlaceId);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2TEXTSORT1);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, categoryId);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3TEXTSORT1);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, price);
								preparedStmt.setInt(4, paging);
							}
						}
					} else {// date
						if (textSearch.equals("")) {// text
							if (workPlaceId == 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGEDATESORT1);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123DATESORT1);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, workPlaceId);
								preparedStmt.setInt(3, categoryId);
								preparedStmt.setInt(4, price);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23DATESORT1);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, categoryId);
								preparedStmt.setInt(3, price);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13DATESORT1);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, workPlaceId);
								preparedStmt.setInt(3, price);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12DATESORT1);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, workPlaceId);
								preparedStmt.setInt(3, categoryId);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1DATESORT1);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, workPlaceId);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2DATESORT1);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, categoryId);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3DATESORT1);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, price);
								preparedStmt.setInt(3, paging);
							}
						} else {
							if (workPlaceId == 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGETEXTDATESORT1);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123TEXTDATESORT1);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, workPlaceId);
								preparedStmt.setInt(5, categoryId);
								preparedStmt.setInt(6, price);
								preparedStmt.setInt(7, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23TEXTDATESORT1);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, categoryId);
								preparedStmt.setInt(5, price);
								preparedStmt.setInt(6, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13TEXTDATESORT1);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, workPlaceId);
								preparedStmt.setInt(5, price);
								preparedStmt.setInt(6, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12TEXTDATESORT1);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, workPlaceId);
								preparedStmt.setInt(5, categoryId);
								preparedStmt.setInt(6, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
								System.out.println("+");
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1TEXTDATESORT1);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, workPlaceId);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2TEXTDATESORT1);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, categoryId);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3TEXTDATESORT1);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, price);
								preparedStmt.setInt(5, paging);
							}
						}
					}

				}
				if (sort.equals("2")) {
					if (date.equals("")) {// date
						if (textSearch.equals("")) {// text
							if (workPlaceId == 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGESORT2);
								preparedStmt.setInt(1, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123SORT2);
								preparedStmt.setInt(1, workPlaceId);
								preparedStmt.setInt(2, categoryId);
								preparedStmt.setInt(3, price);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23SORT2);
								preparedStmt.setInt(1, categoryId);
								preparedStmt.setInt(2, price);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13SORT2);
								preparedStmt.setInt(1, workPlaceId);
								preparedStmt.setInt(2, price);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12SORT2);
								preparedStmt.setInt(1, workPlaceId);
								preparedStmt.setInt(2, categoryId);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1SORT2);
								preparedStmt.setInt(1, workPlaceId);
								preparedStmt.setInt(2, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2SORT2);
								preparedStmt.setInt(1, categoryId);
								preparedStmt.setInt(2, paging);
							} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3SORT2);
								preparedStmt.setInt(1, price);
								preparedStmt.setInt(2, paging);
							}
						} else {// text
							if (workPlaceId == 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGETEXTSORT2);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123TEXTSORT2);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, workPlaceId);
								preparedStmt.setInt(4, categoryId);
								preparedStmt.setInt(5, price);
								preparedStmt.setInt(6, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23TEXTSORT2);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, categoryId);
								preparedStmt.setInt(4, price);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13TEXTSORT2);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, workPlaceId);
								preparedStmt.setInt(4, price);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12TEXTSORT2);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, workPlaceId);
								preparedStmt.setInt(4, categoryId);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
								System.out.println("+");
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1TEXTSORT2);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, workPlaceId);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2TEXTSORT2);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, categoryId);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3TEXT);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, price);
								preparedStmt.setInt(4, paging);
							}
						}
					} else {// date
						if (textSearch.equals("")) {// text
							if (workPlaceId == 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGEDATESORT2);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123DATESORT2);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, workPlaceId);
								preparedStmt.setInt(3, categoryId);
								preparedStmt.setInt(4, price);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23DATESORT2);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, categoryId);
								preparedStmt.setInt(3, price);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13DATESORT2);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, workPlaceId);
								preparedStmt.setInt(3, price);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12DATESORT2);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, workPlaceId);
								preparedStmt.setInt(3, categoryId);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1DATESORT2);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, workPlaceId);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2DATESORT2);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, categoryId);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3DATESORT2);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, price);
								preparedStmt.setInt(3, paging);
							}
						} else {
							if (workPlaceId == 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGETEXTDATE);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123TEXTDATE);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, workPlaceId);
								preparedStmt.setInt(5, categoryId);
								preparedStmt.setInt(6, price);
								preparedStmt.setInt(7, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23TEXTDATESORT2);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, categoryId);
								preparedStmt.setInt(5, price);
								preparedStmt.setInt(6, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13TEXTDATE);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, workPlaceId);
								preparedStmt.setInt(5, price);
								preparedStmt.setInt(6, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12TEXTDATE);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, workPlaceId);
								preparedStmt.setInt(5, categoryId);
								preparedStmt.setInt(6, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
								System.out.println("+");
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1TEXTDATESORT2);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, workPlaceId);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2TEXTDATESORT2);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, categoryId);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3TEXTDATESORT2);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, price);
								preparedStmt.setInt(5, paging);
							}
						}
					}
				}
				if (sort.equals("3")) {
					if (date.equals("")) {// date
						if (textSearch.equals("")) {// text
							if (workPlaceId == 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGESORT3);
								preparedStmt.setInt(1, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123SORT3);
								preparedStmt.setInt(1, workPlaceId);
								preparedStmt.setInt(2, categoryId);
								preparedStmt.setInt(3, price);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23SORT3);
								preparedStmt.setInt(1, categoryId);
								preparedStmt.setInt(2, price);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13SORT3);
								preparedStmt.setInt(1, workPlaceId);
								preparedStmt.setInt(2, price);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12SORT3);
								preparedStmt.setInt(1, workPlaceId);
								preparedStmt.setInt(2, categoryId);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1SORT3);
								preparedStmt.setInt(1, workPlaceId);
								preparedStmt.setInt(2, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2SORT3);
								preparedStmt.setInt(1, categoryId);
								preparedStmt.setInt(2, paging);
							} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3SORT3);
								preparedStmt.setInt(1, price);
								preparedStmt.setInt(2, paging);
							}
						} else {// text
							if (workPlaceId == 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGETEXTSORT3);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123TEXTSORT3);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, workPlaceId);
								preparedStmt.setInt(4, categoryId);
								preparedStmt.setInt(5, price);
								preparedStmt.setInt(6, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23TEXTSORT3);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, categoryId);
								preparedStmt.setInt(4, price);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13TEXTSORT3);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, workPlaceId);
								preparedStmt.setInt(4, price);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12TEXTSORT3);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, workPlaceId);
								preparedStmt.setInt(4, categoryId);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
								System.out.println("+");
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1TEXTSORT3);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, workPlaceId);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2TEXTSORT3);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, categoryId);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3TEXTSORT3);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, price);
								preparedStmt.setInt(4, paging);
							}
						}
					} else {// date
						if (textSearch.equals("")) {// text
							if (workPlaceId == 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGEDATESORT3);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123DATESORT3);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, workPlaceId);
								preparedStmt.setInt(3, categoryId);
								preparedStmt.setInt(4, price);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23DATESORT3);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, categoryId);
								preparedStmt.setInt(3, price);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13DATESORT3);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, workPlaceId);
								preparedStmt.setInt(3, price);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12DATESORT3);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, workPlaceId);
								preparedStmt.setInt(3, categoryId);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1DATESORT3);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, workPlaceId);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2DATESORT3);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, categoryId);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3DATESORT3);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, price);
								preparedStmt.setInt(3, paging);
							}
						} else {
							if (workPlaceId == 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGETEXTDATESORT3);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123TEXTDATESORT3);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, workPlaceId);
								preparedStmt.setInt(5, categoryId);
								preparedStmt.setInt(6, price);
								preparedStmt.setInt(7, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23TEXTDATESORT3);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, categoryId);
								preparedStmt.setInt(5, price);
								preparedStmt.setInt(6, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13TEXTDATESORT3);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, workPlaceId);
								preparedStmt.setInt(5, price);
								preparedStmt.setInt(6, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12TEXTDATESORT3);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, workPlaceId);
								preparedStmt.setInt(5, categoryId);
								preparedStmt.setInt(6, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
								System.out.println("+");
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1TEXTDATESORT3);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, workPlaceId);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2TEXTDATESORT3);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, categoryId);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3TEXTDATESORT3);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, price);
								preparedStmt.setInt(5, paging);
							}
						}
					}
				}
				if (sort.equals("4")) {
					if (date.equals("")) {// date
						if (textSearch.equals("")) {// text
							if (workPlaceId == 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGESORT4);
								preparedStmt.setInt(1, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123SORT4);
								preparedStmt.setInt(1, workPlaceId);
								preparedStmt.setInt(2, categoryId);
								preparedStmt.setInt(3, price);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23SORT4);
								preparedStmt.setInt(1, categoryId);
								preparedStmt.setInt(2, price);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13SORT4);
								preparedStmt.setInt(1, workPlaceId);
								preparedStmt.setInt(2, price);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12SORT4);
								preparedStmt.setInt(1, workPlaceId);
								preparedStmt.setInt(2, categoryId);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1SORT4);
								preparedStmt.setInt(1, workPlaceId);
								preparedStmt.setInt(2, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2SORT4);
								preparedStmt.setInt(1, categoryId);
								preparedStmt.setInt(2, paging);
							} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3SORT4);
								preparedStmt.setInt(1, price);
								preparedStmt.setInt(2, paging);
							}
						} else {// text
							if (workPlaceId == 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGETEXTSORT4);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123TEXTSORT4);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, workPlaceId);
								preparedStmt.setInt(4, categoryId);
								preparedStmt.setInt(5, price);
								preparedStmt.setInt(6, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23TEXTSORT4);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, categoryId);
								preparedStmt.setInt(4, price);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13TEXTSORT4);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, workPlaceId);
								preparedStmt.setInt(4, price);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12TEXTSORT4);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, workPlaceId);
								preparedStmt.setInt(4, categoryId);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
								System.out.println("+");
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1TEXTSORT4);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, workPlaceId);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2TEXTSORT4);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, categoryId);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3TEXTSORT4);
								preparedStmt.setString(1, "%" + textSearch + "%");
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setInt(3, price);
								preparedStmt.setInt(4, paging);
							}
						}
					} else {// date
						if (textSearch.equals("")) {// text
							if (workPlaceId == 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGEDATESORT4);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123DATESORT4);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, workPlaceId);
								preparedStmt.setInt(3, categoryId);
								preparedStmt.setInt(4, price);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23DATESORT4);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, categoryId);
								preparedStmt.setInt(3, price);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13DATESORT4);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, workPlaceId);
								preparedStmt.setInt(3, price);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12DATESORT4);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, workPlaceId);
								preparedStmt.setInt(3, categoryId);
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1DATESORT4);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, workPlaceId);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2DATESORT4);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, categoryId);
								preparedStmt.setInt(3, paging);
							} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3DATESORT4);
								preparedStmt.setString(1, date);
								preparedStmt.setInt(2, price);
								preparedStmt.setInt(3, paging);
							}
						} else {
							if (workPlaceId == 0 && categoryId == 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGETEXTDATESORT4);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE123TEXTDATESORT4);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, workPlaceId);
								preparedStmt.setInt(5, categoryId);
								preparedStmt.setInt(6, price);
								preparedStmt.setInt(7, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE23TEXTDATESORT4);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, categoryId);
								preparedStmt.setInt(5, price);
								preparedStmt.setInt(6, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE13TEXTDATESORT4);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, workPlaceId);
								preparedStmt.setInt(5, price);
								preparedStmt.setInt(6, paging);
							} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE12TEXTDATESORT4);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, workPlaceId);
								preparedStmt.setInt(5, categoryId);
								preparedStmt.setInt(6, paging);
							} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
								System.out.println("+");
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE1TEXTDATESORT4);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, workPlaceId);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE2TEXTDATESORT4);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, categoryId);
								preparedStmt.setInt(5, paging);
							} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
								preparedStmt = connection
										.prepareStatement(ServicePackageQuery.SEARCHSERVICEPACKAGE3TEXTDATESORT4);
								preparedStmt.setString(1, date);
								preparedStmt.setString(2, "%" + textSearch + "%");
								preparedStmt.setString(3, "%" + textSearch + "%");
								preparedStmt.setInt(4, price);
								preparedStmt.setInt(5, paging);
							}
						}
					}
				}

			}
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				String serviceId = rs.getString("servicepackages.id");
				String servicepackageName = rs.getString("servicepackages.servicepackageName");
				String category = rs.getString("categories.categoryName");
				String shootingLocation = rs.getString("provinces.provinceName");
				String priceService = rs.getString("servicepackages.price");
				String nickName = rs.getString("photographers.nickName");
				String deposit = rs.getString("servicepackages.deposit");
				String photographerID = rs.getString("servicepackages.photographerId");
				String coverImage = rs.getString("images.imageName");
				float pointRating=rs.getFloat("servicepackages.pointRating");
				ServicePackage s = new ServicePackage();
				s.setId(serviceId);
				s.setServicepackageName(servicepackageName);
				s.setCategoryName(category);
				s.setShootingLocation(shootingLocation);
				s.setDeposit(Integer.parseInt(deposit));
				s.setPrice(Integer.parseInt(priceService));
				s.setPhotographerID(photographerID);
				s.setNickName(nickName);
				s.setCoverImage(coverImage);
				s.setPointRating(pointRating);
				listS.add(s);
			}
			return listS;
		} catch (

		SQLException e) {
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

	public int countServicePakage(int workPlaceId, int categoryId, int price, String textSearch, String date) {
		try {
			int count = 0;
			if(date==null) {
				date="";
			}
			connection = ConnectionClass.createConnect().getConnection();
			if (date.equals("")) {
				if (textSearch.equals("")) {
					if (workPlaceId == 0 && categoryId == 0 && price == 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE);
					} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE123);
						preparedStmt.setInt(1, workPlaceId);
						preparedStmt.setInt(2, categoryId);
						preparedStmt.setInt(3, price);
					} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE23);
						preparedStmt.setInt(1, categoryId);
						preparedStmt.setInt(2, price);
					} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE13);
						preparedStmt.setInt(1, workPlaceId);
						preparedStmt.setInt(2, price);
					} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE12);
						preparedStmt.setInt(1, workPlaceId);
						preparedStmt.setInt(2, categoryId);
					} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE1);
						preparedStmt.setInt(1, workPlaceId);
					} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE2);
						preparedStmt.setInt(1, categoryId);
					} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE3);
						preparedStmt.setInt(1, price);
					}
				} else {
					if (workPlaceId == 0 && categoryId == 0 && price == 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGETEXT);
						preparedStmt.setString(1, "%" + textSearch + "%");
						preparedStmt.setString(2, "%" + textSearch + "%");
					} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE123TEXT);
						preparedStmt.setString(1, "%" + textSearch + "%");
						preparedStmt.setString(2, "%" + textSearch + "%");
						preparedStmt.setInt(3, workPlaceId);
						preparedStmt.setInt(4, categoryId);
						preparedStmt.setInt(5, price);
					} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE23TEXT);
						preparedStmt.setString(1, "%" + textSearch + "%");
						preparedStmt.setString(2, "%" + textSearch + "%");
						preparedStmt.setInt(3, categoryId);
						preparedStmt.setInt(4, price);
					} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE13TEXT);
						preparedStmt.setString(1, "%" + textSearch + "%");
						preparedStmt.setString(2, "%" + textSearch + "%");
						preparedStmt.setInt(3, workPlaceId);
						preparedStmt.setInt(4, price);
					} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE12TEXT);
						preparedStmt.setString(1, "%" + textSearch + "%");
						preparedStmt.setString(2, "%" + textSearch + "%");
						preparedStmt.setInt(3, workPlaceId);
						preparedStmt.setInt(4, categoryId);
					} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE1TEXT);
						preparedStmt.setString(1, "%" + textSearch + "%");
						preparedStmt.setString(2, "%" + textSearch + "%");
						preparedStmt.setInt(3, workPlaceId);
					} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE2TEXT);
						preparedStmt.setString(1, "%" + textSearch + "%");
						preparedStmt.setString(2, "%" + textSearch + "%");
						preparedStmt.setInt(3, categoryId);
					} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE3TEXT);
						preparedStmt.setString(1, "%" + textSearch + "%");
						preparedStmt.setString(2, "%" + textSearch + "%");
						preparedStmt.setInt(3, price);
					}
				}
			} else {// date
				if (textSearch.equals("")) {// text
					if (workPlaceId == 0 && categoryId == 0 && price == 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGEDATE);
						preparedStmt.setString(1, date);
					} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE123DATE);
						preparedStmt.setString(1, date);
						preparedStmt.setInt(2, workPlaceId);
						preparedStmt.setInt(3, categoryId);
						preparedStmt.setInt(4, price);
					} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE23DATE);
						preparedStmt.setString(1, date);
						preparedStmt.setInt(2, categoryId);
						preparedStmt.setInt(3, price);
					} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE13DATE);
						preparedStmt.setString(1, date);
						preparedStmt.setInt(2, workPlaceId);
						preparedStmt.setInt(3, price);
					} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE12DATE);
						preparedStmt.setString(1, date);
						preparedStmt.setInt(2, workPlaceId);
						preparedStmt.setInt(3, categoryId);
					} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE1DATE);
						preparedStmt.setString(1, date);
						preparedStmt.setInt(2, workPlaceId);
					} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE2DATE);
						preparedStmt.setString(1, date);
						preparedStmt.setInt(2, categoryId);
					} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE3DATE);
						preparedStmt.setString(1, date);
						preparedStmt.setInt(2, price);
					}
				} else {
					if (workPlaceId == 0 && categoryId == 0 && price == 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGETEXTDATE);
						preparedStmt.setString(1, date);
						preparedStmt.setString(2, "%" + textSearch + "%");
						preparedStmt.setString(3, "%" + textSearch + "%");
					} else if (workPlaceId != 0 && categoryId != 0 && price != 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE123TEXTDATE);
						preparedStmt.setString(1, date);
						preparedStmt.setString(2, "%" + textSearch + "%");
						preparedStmt.setString(3, "%" + textSearch + "%");
						preparedStmt.setInt(4, workPlaceId);
						preparedStmt.setInt(5, categoryId);
						preparedStmt.setInt(6, price);
					} else if (workPlaceId == 0 && categoryId != 0 && price != 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE23TEXTDATE);
						preparedStmt.setString(1, date);
						preparedStmt.setString(2, "%" + textSearch + "%");
						preparedStmt.setString(3, "%" + textSearch + "%");
						preparedStmt.setInt(4, categoryId);
						preparedStmt.setInt(5, price);
					} else if (workPlaceId != 0 && categoryId == 0 && price != 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE13TEXTDATE);
						preparedStmt.setString(1, date);
						preparedStmt.setString(2, "%" + textSearch + "%");
						preparedStmt.setString(3, "%" + textSearch + "%");
						preparedStmt.setInt(4, workPlaceId);
						preparedStmt.setInt(5, price);
					} else if (workPlaceId != 0 && categoryId != 0 && price == 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE12TEXTDATE);
						preparedStmt.setString(1, date);
						preparedStmt.setString(2, "%" + textSearch + "%");
						preparedStmt.setString(3, "%" + textSearch + "%");
						preparedStmt.setInt(4, workPlaceId);
						preparedStmt.setInt(5, categoryId);
					} else if (workPlaceId != 0 && categoryId == 0 && price == 0) {
						System.out.println("+");
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE1TEXTDATE);
						preparedStmt.setString(1, date);
						preparedStmt.setString(2, "%" + textSearch + "%");
						preparedStmt.setString(3, "%" + textSearch + "%");
						preparedStmt.setInt(4, workPlaceId);
					} else if (workPlaceId == 0 && categoryId != 0 && price == 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE2TEXTDATE);
						preparedStmt.setString(1, date);
						preparedStmt.setString(2, "%" + textSearch + "%");
						preparedStmt.setString(3, "%" + textSearch + "%");
						preparedStmt.setInt(4, categoryId);
					} else if (workPlaceId == 0 && categoryId == 0 && price != 0) {
						preparedStmt = connection.prepareStatement(ServicePackageQuery.COUNTSERVICEPACKAGE3TEXTDATE);
						preparedStmt.setString(1, date);
						preparedStmt.setString(2, "%" + textSearch + "%");
						preparedStmt.setString(3, "%" + textSearch + "%");
						preparedStmt.setInt(4, price);
					}
				}
			}
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
			return count;
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
		return 0;
	}

}
