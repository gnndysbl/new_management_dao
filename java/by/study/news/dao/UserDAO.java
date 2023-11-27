package by.study.news.dao;

import by.study.news.bean.User;
import by.study.news.dao.exception.DAOException;

public interface UserDAO {
	
	void signIn(String login, String password) throws DAOException;
	void registration(User user) throws DAOException;

}
