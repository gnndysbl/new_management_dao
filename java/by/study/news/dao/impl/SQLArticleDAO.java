package by.study.news.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.study.news.bean.Article;
import by.study.news.dao.NewsDAO;
import by.study.news.dao.exception.DAOException;

public class SQLArticleDAO implements NewsDAO {

	@Override
	public void add(Article article) throws DAOException {
		// TODO Auto-generated method stub

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false",
				"root", "password")) {

			try (PreparedStatement stmt = connection
					.prepareStatement("insert into news(title, brief, content, article_date, status, users_id) "
							+ "values(?, ?, ?, ?, ?, ?)")) {

				stmt.setString(1, article.getTitle());
				stmt.setString(2, article.getBrief());
				stmt.setString(3, article.getContent());

				// позже работа с датой уйдет в слой сервисов
				Date now = article.getDate();
				Timestamp timestamp = new Timestamp(now.getTime());
				// позже работа с датой уйдет в слой сервисов

				stmt.setTimestamp(4, timestamp);
				stmt.setInt(5, article.getStatus());
				stmt.setInt(6, 18);

				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException("article placement error", e);
		}

	}

	@Override
	public void deleteById(int id) throws DAOException {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false",
				"root", "password")) {

			try (PreparedStatement stmt = connection.prepareStatement("UPDATE news set status = ? where id = ? ")) {

				stmt.setInt(1, 2);
				stmt.setInt(2, id);
				stmt.executeUpdate();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException("deleting error", e);
		}

	}

	@Override
	public void editById(Article article, int Id) throws DAOException {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false",
				"root", "password")) {

			try (PreparedStatement stmt = connection.prepareStatement(
					"UPDATE news set title = ?, brief = ?, content = ?, article_date = ?  where id = ? ")) {

				stmt.setString(1, article.getTitle());
				stmt.setString(2, article.getBrief());
				stmt.setString(3, article.getContent());
				stmt.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
				stmt.setInt(5, Id);
				stmt.executeUpdate();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException("editting error", e);
		}

	}

	@Override
	public Article getById(int id) throws DAOException {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false",
				"root", "password")) {

			try (PreparedStatement stmt = connection.prepareStatement("select * from news where id=?")) {

				stmt.setInt(1, id);
				ResultSet resultSet = stmt.executeQuery();

				if (resultSet.next()) {

					Date date = resultSet.getTimestamp("article_date");

					return new Article(resultSet.getInt("id"), date, resultSet.getString("title"),
							resultSet.getString("brief"), resultSet.getString("content"), resultSet.getInt("status"));

				} else {
					return null;
				}

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new DAOException("getting article error", e1);
		}

	}

	public List<Article> getArticlesFromTo(int a, int b) throws DAOException {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false",
				"root", "password")) {

			try (PreparedStatement stmt = connection.prepareStatement("select * from news")) {

				ResultSet resultSet = stmt.executeQuery();
				List<Article> list = new ArrayList<>();
				int counter = 0;
				while (resultSet.next()) {
					counter ++;
					if (counter >= a & counter <= b) {
					

					list.add(new Article(resultSet.getInt("id"), resultSet.getTimestamp("article_date"),
							resultSet.getString("title"), resultSet.getString("brief"), resultSet.getString("content"),
							resultSet.getInt("status")));
					}
				}
				return list;
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new DAOException("getting articles error", e1);
		}
	}
	
	@Override
	public List<Article> getAllArticles() throws DAOException {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false",
				"root", "password")) {

			try (PreparedStatement stmt = connection.prepareStatement("select * from news")) {

				ResultSet resultSet = stmt.executeQuery();
				List<Article> list = new ArrayList<>();

				while (resultSet.next()) {

					list.add(new Article(resultSet.getInt("id"), resultSet.getTimestamp("article_date"),
							resultSet.getString("title"), resultSet.getString("brief"), resultSet.getString("content"),
							resultSet.getInt("status")));

				}
				return list;
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new DAOException("getting articles error", e1);
		}

	}
}
