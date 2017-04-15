package pl.lodz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
}
