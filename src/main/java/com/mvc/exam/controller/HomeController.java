package com.mvc.exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.exam.model.Station;
import com.mvc.exam.model.User;
import com.mvc.exam.service.StationService;
import com.mvc.exam.service.UserService;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
@SessionAttributes("stations")
public class HomeController {

	@Autowired
	StationService _service;
	
	@Autowired
	UserService _serviceUser;
	
	@Autowired
	MessageSource _messageSource;
	
	/**
	 * show menu
	 */
	@RequestMapping(value =  { "/" }, method = RequestMethod.GET)
	public String home(Model model) {

		return "home";
	}
	
	/**
	 * get station list data
	 * @param model
	 * @return
	 */
	@RequestMapping(value ={ "/listStation" }, method = RequestMethod.GET)
	public String listStation(ModelMap model) {
		List<Station> station = _service.findAllStation();
		model.addAttribute("station",station);
				
		return "allStation";
	}

	/**
	 * get station model
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/newStation" }, method = RequestMethod.GET)
	public String newStation(ModelMap model) {
		Station station = new Station();
		model.addAttribute("station", station);
		return "regStation";
	}
	
	/**
	 * save station
	 * @param station
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/newStation" }, method = RequestMethod.POST)
	public String saveStation(@Valid Station station, BindingResult result, ModelMap model){
		
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return "regStation";
		}
		
		if(!_service.isStationNameUnique(station.getStationName())){
			FieldError ssnError =new FieldError("station","StationName",_messageSource.getMessage("non.unique.stationName", new String[]{station.getStationName()}, Locale.getDefault()));
		    result.addError(ssnError);
		    return "regStation";
		}
		_service.saveStation(station);
		
		model.addAttribute("msg","Station: "+station.getStationName()+ " registered successfully");
		
		return "regStation";
	}
	
	/**
	 * get station
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/view-{id}-station" }, method = RequestMethod.GET)
	public String viewStation(@PathVariable int id, ModelMap model){
		Station station = _service.findById(id);
		model.addAttribute("station", station);
		
		List<User> user = _serviceUser.findUserByStation(id);
		model.addAttribute("user", user);
		
		return "viewStation";
	}
	
	/**
	 * delete station
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { "/del-{id}-station" }, method = RequestMethod.GET)
	public String deleteStation(@PathVariable int id) {
		_service.deleteStationById(id);
		return "redirect:/listStation";
	}
	
	/**
	 * update station
	 * @param station
	 * @param result
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { "/view-{id}-station" }, method = RequestMethod.POST)
	public String updateStation(@Valid Station station, BindingResult result, ModelMap model, @PathVariable int id) {
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return "viewStation";
		}
		
		_service.updateStation(station);

		List<User> user = _serviceUser.findUserByStation(station.getId());//get user by station id
		model.addAttribute("user", user);
		model.addAttribute("msg","Station: "+station.getStationName()+ " updated successfully");
		return "viewStation";
	}
	
	@ModelAttribute("stationList")
	public Map<Integer,String> getStationList(){
		Map<Integer, String> stationMap = new HashMap<Integer, String>();
		List<Station> stationList =_service.findAllStation();
		for(Station s:stationList){
			stationMap.put(s.getId(), s.getStationName());
		}
		return stationMap;
	}

	//--User --------------------------------------
	
	/**
	 * get user model
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/newUser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		return "regUser";
	}
	
	/**
	 * save user
	 * @param user
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/newUser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, ModelMap model){
		
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return "regUser";
		}
		//check unique key of employee id
		if(!_serviceUser.isEmpIDUnique(user.getEmployeeID())){
			FieldError ssnError =new FieldError("user","employeeID",_messageSource.getMessage("non.unique.EmployeeID", new String[]{user.getEmployeeID()}, Locale.getDefault()));
		    result.addError(ssnError);
		    return "regUser";
		}
		
		_serviceUser.saveUser(user);
		
		model.addAttribute("msg","User: "+user.getName()+ " registered successfully");
		
		return "regUser";
	}

	/**
	 * get user list data
	 * @param model
	 * @return
	 */
	@RequestMapping(value ={ "/listUser" }, method = RequestMethod.GET)
	public String listUser(ModelMap model) {
		List<User> user = _serviceUser.findAllUser();
		model.addAttribute("user",user);
				
		return "allUser";
	}
	
	/**
	 * get user data
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/view-{id}-user" }, method = RequestMethod.GET)
	public String viewUser(@PathVariable int id, ModelMap model){
		User user = _serviceUser.findByID(id);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		
		return "regUser";
	}
	

	/**
	 * delete user
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { "/del-{id}-user" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id) {
		_serviceUser.deleteUserByID(id);
		return "redirect:/listUser";
	}
	
	/**
	 * update user
	 * @param user
	 * @param result
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { "/view-{id}-user" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result, ModelMap model, @PathVariable int id) {
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return "regUser";
		}
		
		_serviceUser.updateUser(user);
		
		model.addAttribute("msg","User: "+user.getName()+ " updated successfully");
		model.addAttribute("edit", true);
		
		return "regUser";
	}
	
}
