package pl.lodz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.lodz.models.Login;
import pl.lodz.services.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping("/tryLogin")
	public @ResponseBody int tryLogin(@RequestBody Login login) {
		return loginService.login(login.getLogin(), login.getPassword());
	}
	
	@RequestMapping("/register")
	public @ResponseBody String register(@RequestBody Login login) {		
		loginService.register(login.getLogin(), login.getPassword());
		return "OK";
	}
	
}
