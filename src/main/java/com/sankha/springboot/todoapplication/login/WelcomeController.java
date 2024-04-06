package com.sankha.springboot.todoapplication.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userName")
public class WelcomeController {
	/*
	private Logger logger = LoggerFactory.getLogger(getClass());
	 * http://localhost:8080/login?name=Sankha
	 * @RequestMapping("login") 
	 * public String login(@RequestParam String name,ModelMap model) { 
	 * logger.debug("I want this printed at debug level");
	 * logger.info("I want this printed at info level");
	 * logger.warn("I want this printed at warn level");
	 * System.out.println("Request param: "+name); model.put("username", name);
	 * return "login"; 
	 * }
	 */
	//@Autowired
//	private AuthenticationService auth;
//	
//	public LoginController(AuthenticationService auth) {
//		super();
//		this.auth = auth;
//	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("userName", getLoggedInUsername());
		return "welcome";
	}
	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		//Authentication
//		boolean isAuthenticated = auth.authenticateUser(name, password);
//		if(isAuthenticated) {
//			model.put("userName", name);
//			//model.put("userPassword", password);
//			return "welcome";
//		}
//		model.put("errorMessage", "Invalid Credentials");
//		return "login";
//		
//	}
//	
	 
}
