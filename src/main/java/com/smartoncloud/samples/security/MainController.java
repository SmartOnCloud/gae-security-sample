package com.smartoncloud.samples.security;

import static com.google.appengine.api.users.UserServiceFactory.getUserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.appengine.api.users.UserService;

@Controller
public class MainController {
    private UserService userService = getUserService();

    @RequestMapping("index.html")
    public String index(Model m) {
	m.addAttribute("loginURL", userService.createLoginURL("/index.html"));
	m.addAttribute("logoutURL", userService.createLogoutURL("/index.html"));
	return "index";
    }

    @RequestMapping("protected.html")
    @Secured
    public String protected_site() {
	return "protected";
    }

    @RequestMapping("protected_admin.html")
    @Secured(admin = true)
    public String protected_site_admin() {
	return "protected_admin";
    }
    
    // simple authorisation exception handlers
    @ExceptionHandler(AccessDeniedException.class)
    public String handleIOException(AccessDeniedException ex) {
	return "forbidden";
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    public String handleIOException(UnauthorizedAccessException ex) {
	return "forbidden";
    }
}
