package pl.lodz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.lodz.models.Coordinates;
import pl.lodz.models.Login;
import pl.lodz.models.User;
import pl.lodz.services.LoginService;
import pl.lodz.services.UserService;

@Controller
@RequestMapping("/mobile")
public class MobileController {

	@Autowired
	UserService userService;
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/addCoordinates", method = RequestMethod.PUT)
	public @ResponseBody void addCoordinates(String login, String name, String latitude, String longitude) {
		Login loginData = loginService.getLogin(login);
		List<User> users = loginData.getUsers();
		Coordinates coords = new Coordinates(Double.valueOf(latitude), Double.valueOf(longitude));
		for(User user : users) {
			if(name.equals(user.getName())) {
				user.addCoords(coords);
				userService.saveUser(user);
				return;
			}
		}
		
		User newUser = new User(name);
		newUser.addCoords(coords);
		loginData.addUser(newUser);
		loginService.saveLogin(loginData);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Boolean login(String login, String password) {
		int errorCode = loginService.login(login, password);
		if(errorCode == 0) {
			return new Boolean(true);
		}
		
		return new Boolean(false);
	}
	
}
