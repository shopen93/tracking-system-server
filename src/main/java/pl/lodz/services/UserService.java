package pl.lodz.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lodz.dao.UserDAO;
import pl.lodz.models.User;

@Service
public class UserService {

	@Autowired
	UserDAO userDao;
	
	@Transactional
	public User getUser(String name) {
		return userDao.findByName(name);
	}
	
	@Transactional
	public void saveUser(User user) {
		userDao.save(user);
	}
	
}
