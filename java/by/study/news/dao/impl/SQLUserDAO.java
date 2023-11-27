package by.study.news.dao.impl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import by.study.news.bean.User;
import by.study.news.dao.UserDAO;
import by.study.news.dao.exception.DAOException;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLUserDAO implements UserDAO {

	@Override
	public void signIn(String login, String password) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void registration(User user) throws DAOException {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false",
				"root", "password")) {

			try (PreparedStatement stmt = connection
					.prepareStatement("insert into users(login, password) values(?, ?)")) {
				stmt.setString(1, user.getLogin());
				stmt.setString(2, user.getPassword());
				stmt.executeUpdate();
			}

			try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false",
					"root", "password");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM users")) {

				while (rs.next()) {
					//System.out.println(rs.getInt(1));
					int id = rs.getInt(1);
					//System.out.println(id);
					user.setId(id);
				}
			}

			try (PreparedStatement stmt = connection
					.prepareStatement("insert into user_details(name, last_name, email, register_date, users_id) "
							+ "values(?, ?, ?, ?, ?)")) {

				stmt.setString(1, user.getName());
				stmt.setString(2, user.getLastName());
				stmt.setString(3, user.getEmail());
				stmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
				stmt.setInt(5, user.getId());
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException("registration error", e);
		}
	}
}
