
package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.*;
@Controller
@RequestMapping("/")
public class Home {
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewHome(HttpServletRequest request, HttpServletResponse response) {
		return "Home";
	}
	@RequestMapping(path = "/about", method = RequestMethod.GET)
	public String viewAbout(HttpServletRequest request, HttpServletResponse response) {
		return "AboutUs";
	}
	@RequestMapping(path = "/contact", method = RequestMethod.GET)
	public String viewContact(HttpServletRequest request, HttpServletResponse response) {
		return "ContactUs";
	}
}
