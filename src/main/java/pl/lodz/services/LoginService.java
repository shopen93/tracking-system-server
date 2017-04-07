package pl.lodz.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lodz.dao.LoginDAO;
import pl.lodz.models.Login;

@Service
public class LoginService {

	@Autowired
	LoginDAO loginDao;
	
	@Transactional
	public int login(String login, String password) {
		Login temp = loginDao.findByLogin(login);
		if(temp != null) {
			// we have this login
			if(temp.getPassword().equals(password)) {
				// password match
				return 0;
			}			
			return 99;
		}
		
		// we don't have login
		return -1;
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
