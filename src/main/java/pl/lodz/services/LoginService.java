package pl.lodz.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lodz.dao.LoginDAO;
import pl.lodz.models.Login;
import pl.lodz.models.User;

@Service
public class LoginService {

	@Autowired
	LoginDAO loginDao;
	
	@Transactional
	public List<User> login(String login, String password) {
		Login temp = loginDao.findByLogin(login);
		if(temp != null) {
			// we have this login
			if(temp.getPassword().equals(password)) {
				// password match, return list of users
				return temp.getUsers();
			}
			
			// password not match, return empty list
			return new ArrayList<User>();
		}
		
		// we don't have login
		return null;
	}
	
	@Transactional
	public boolean tryRegister(String login) {
		Login temp = loginDao.findByLogin(login);
		if(temp != null) {
			// we have this login
			return false;
		}
		
		return true;
	}
	
	@Transactional
	public void register(String login, String password) {
		Login newLogin = new Login(login, password);
		loginDao.save(newLogin);
	}
	
}
