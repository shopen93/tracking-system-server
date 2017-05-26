package pl.lodz.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.lodz.dto.RestrictionDTO;
import pl.lodz.models.Point;
import pl.lodz.models.Restriction;
import pl.lodz.models.User;
import pl.lodz.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/getAllUsers")
	public @ResponseBody List<User> getAllUsers(@RequestBody String login) {
		return userService.getAllUsers(login);
	}
	
	@RequestMapping("/getUserDetails")
	public @ResponseBody User getUserDetails(@RequestBody int userId) {
		return userService.getUser(userId);
	}
	
	@RequestMapping("/saveRestriction")
	public @ResponseBody void saveRestriction(@RequestParam("userId") int userId, @RequestBody RestrictionDTO data) {
		User user = userService.getUser(userId);
		
		List<Point> points = new ArrayList<Point>();
		String[] x = data.getX().split(";");
		String[] y = data.getY().split(";");
		
		for(int i = 0; i < x.length; i++) {
			Point point = new Point(Double.parseDouble(x[i]), Double.parseDouble(y[i]));
			points.add(point);
		}
		
		Restriction restriction = new Restriction(data.getName(), points);
		user.addRestriction(restriction);
		
		userService.saveUser(user);
	}
	
	@RequestMapping("/deleteRestriction")
	public @ResponseBody void deleteRestriction(@RequestParam("index") int index, @RequestBody User user) {
		user.getRestrictions().remove(index);
		userService.saveUser(user);
	}
	
}
