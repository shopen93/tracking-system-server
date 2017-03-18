package pl.lodz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.lodz.models.User;
import pl.lodz.services.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping("/tryLogin")
	public @ResponseBody List<User> tryLogin(String login, String password) {
		return loginService.login(login, password);
	}
	
	@RequestMapping("/register")
	public @ResponseBody String register(String login, String password) {
		if(loginService.tryRegister(login)) {
			loginService.register(login, password);
			return "OK";
		}
		
		return "EXIST";
	}
	
}
