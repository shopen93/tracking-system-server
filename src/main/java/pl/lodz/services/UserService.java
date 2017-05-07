package pl.lodz.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lodz.dao.LoginDAO;
import pl.lodz.dao.UserDAO;
import pl.lodz.models.User;

@Service
public class UserService {

	@Autowired
	UserDAO userDao;
	
	@Autowired
	LoginDAO loginDao;
	
	@Transactional
	public User getUser(int id) {
		return userDao.findById(id);
	}
		
	@Transactional
	public void saveUser(User user) {
		userDao.save(user);
	}
	
	@Transactional
	public List<User> getAllUsers(String login) {
		return loginDao.findByLogin(login).getUsers();
	}
	
}
