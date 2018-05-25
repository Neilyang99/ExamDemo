package com.mvc.exam.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.exam.model.Station;
import com.mvc.exam.model.User;
import com.mvc.exam.service.StationService;
import com.mvc.exam.service.UserService;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	StationService service;
	
	@Autowired
	UserService serviceUser;
	
	/**
	 * show menu
	 */
	@RequestMapping(value =  { "/" }, method = RequestMethod.GET)
	public String home(Model model) {

		return "home";
	}
	
	@RequestMapping(value ={ "/listStation" }, method = RequestMethod.GET)
	public String listStation(ModelMap model) {
		List<Station> station = service.findAllStation();
		model.addAttribute("station",station);
				
		return "allStation";
	}

	@RequestMapping(value = { "/newStation" }, method = RequestMethod.GET)
	public String newStation(ModelMap model) {
		Station station = new Station();
		model.addAttribute("station", station);
		return "regStation";
	}
	
	@RequestMapping(value = { "/newStation" }, method = RequestMethod.POST)
	public String saveStation(@Valid Station station, BindingResult result, ModelMap model){
		
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return "regStation";
		}
		
		service.saveStation(station);
		
		model.addAttribute("msg","Station: "+station.getStationName()+ " registered successfully");
		
		return "regStation";
	}
	
	@RequestMapping(value = { "/view-{id}-station" }, method = RequestMethod.GET)
	public String viewStation(@PathVariable int id, ModelMap model){
		Station station = service.findById(id);
		model.addAttribute("station", station);
		
		User user = serviceUser.findByID(id);//?????
		model.addAttribute("user", user);
		
		return "viewStation";
	}
	
	@RequestMapping(value = { "/del-{id}-station" }, method = RequestMethod.GET)
	public String deleteStation(@PathVariable int id) {
		service.deleteStationById(id);
		return "redirect:/listStation";
	}
	
	@RequestMapping(value = { "/view-{id}-station" }, method = RequestMethod.POST)
	public String updateStation(@Valid Station station, BindingResult result, ModelMap model, @PathVariable int id) {
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return "viewStation";
		}
		System.out.println("AAAAAAAAAAAAAA--"+station.getStationName());
		service.updateStation(station);
		model.addAttribute("msg","Station: "+station.getStationName()+ " updated successfully");
		return "viewStation";
	}

	//--User --------------------------------------
	
	@RequestMapping(value = { "/newUser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		return "regUser";
	}
	
	@RequestMapping(value = { "/newUser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, ModelMap model){
		
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return "regUser";
		}
		//check unique key of employee id
		//
		
		serviceUser.saveUser(user);
		
		model.addAttribute("msg","User: "+user.getName()+ " registered successfully");
		
		return "regUser";
	}

	@RequestMapping(value ={ "/listUser" }, method = RequestMethod.GET)
	public String listUser(ModelMap model) {
		List<User> user = serviceUser.findAllUser();
		model.addAttribute("user",user);
				
		return "allUser";
	}
	
	@RequestMapping(value = { "/view-{id}-user" }, method = RequestMethod.GET)
	public String viewUser(@PathVariable int id, ModelMap model){
		User user = serviceUser.findByID(id);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		
		return "regUser";
	}
	

	@RequestMapping(value = { "/del-{id}-user" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id) {
		serviceUser.deleteUserByID(id);
		return "redirect:/listUser";
	}
	
	@RequestMapping(value = { "/view-{id}-user" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result, ModelMap model, @PathVariable int id) {
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return "regUser";
		}
		
		serviceUser.updateUser(user);
		
		model.addAttribute("msg","User: "+user.getName()+ " updated successfully");
		model.addAttribute("edit", true);
		
		return "regUser";
	}
}
