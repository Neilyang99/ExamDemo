package com.mvc.exam.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.exam.model.Station;
import com.mvc.exam.service.StationService;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	StationService service;
	
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

}
