package pl.lodz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.lodz.models.Coordinates;
import pl.lodz.models.User;
import pl.lodz.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/addCoordinates", method = RequestMethod.PUT)
	public @ResponseBody void addCoordinates(String name, String latitude, String longitude) {
		User user = userService.getUser(name);
		Coordinates coords = new Coordinates(Double.valueOf(latitude), Double.valueOf(longitude));
		
		if(user != null) {
			user.addCoords(coords);
		} else {
			user = new User(name);
			user.addCoords(coords);
		}
		
		userService.saveUser(user);
	}
	
	@RequestMapping("/getDataForUser")
	public @ResponseBody User getDataForUser(@RequestBody String name) {
		return userService.getUser(name);
	}
	
}
