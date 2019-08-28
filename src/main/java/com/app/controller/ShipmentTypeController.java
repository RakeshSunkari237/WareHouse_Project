package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	
	@Autowired
	private IShipmentTypeService service;

	// 1.show Register page
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		map.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}
	
	//2.Insert data in DB
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String save(@ModelAttribute ShipmentType shipmentType,ModelMap map) {
		
		// call save method in service layer
		Integer shipmentTypeId = service.saveShipmentType(shipmentType);
	
		//construct msg
		String msg="ShipmentType saved with "+shipmentTypeId+" successfully";
		
		// send to UI
		map.addAttribute("message", msg);
		map.addAttribute("shipmentType",new ShipmentType());
		
		return "ShipmentTypeRegister";
	}
}
