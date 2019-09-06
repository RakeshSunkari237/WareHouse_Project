package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.util.ShipmentTypeUtil;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private ShipmentTypeUtil util;
	
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
	
	//3.View All Records
	@RequestMapping("/viewAll")
	public String viewAll(ModelMap map) {
		
		//call service layer getAllShipmentTypes
		List<ShipmentType> shipmentTypes = service.getAllShipmentTypes();
		
		//send to UI
		map.addAttribute("list", shipmentTypes);
		//
		return "ShipmentTypeData";
	}
	
	// 4.Delete Recored
	@RequestMapping("/delete")
	public String deleteShipmentType(@RequestParam Integer shipmentTypeId,ModelMap map) {
		
		try{
		// row delete
		service.deleteShipmentType(shipmentTypeId);
		//construct msg and send to UI
		String msg="One Shipment details are deleted with id "+shipmentTypeId;
		map.addAttribute("message", msg);
		}catch(Exception e) {
			map.addAttribute("message", "Shipment details are not found with id "+shipmentTypeId);
		}
		//new data
		List<ShipmentType> shipmentTypes = service.getAllShipmentTypes();
		
		//send to UI
		map.addAttribute("list", shipmentTypes);
		return "ShipmentTypeData";
	}
	
	// 5.show Edit page
	@RequestMapping("/edit")
	public String viewOneObject(@RequestParam Integer shipmentTypeId,ModelMap map) {
		
		//call service layer get deatils based on Id and send to UI
		ShipmentType shipmentType = service.getOneShipmentType(shipmentTypeId);
		map.addAttribute("shipmentType", shipmentType);
		return "ShipmentTypeEdit";
	}
	
	// 6.Do update
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute ShipmentType shipmentType,ModelMap map) {
		
		// call service layer to do Update
		service.updateShipmentType(shipmentType);
		
		//success messages
		map.addAttribute("message", "Shipment id "+shipmentType.getShipmentTypeId()+" is successfully updated ");
		
		//get new data and send to UI
		List<ShipmentType> shipmentTypes = service.getAllShipmentTypes();
		map.addAttribute("list", shipmentTypes);
		
		//return data.jsp page
		return "ShipmentTypeData";
	}
	
	// 7.view one object or row
	@RequestMapping("/view")
	public String viewOne(@RequestParam Integer shipmentTypeId,ModelMap map) {
		
		//call service to get details based on Id and send to UI
		ShipmentType shipmentType = service.getOneShipmentType(shipmentTypeId);
		map.addAttribute("shipmentType", shipmentType);
		
		return "ShipmentTypeViewOne";
	}
	
	//8.Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="shipmentTypeId",required=false)Integer shipmentTypeId) {
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		if(shipmentTypeId != null) {
			//exactly one row
			ShipmentType shipmentType = service.getOneShipmentType(shipmentTypeId);
			List<ShipmentType> shipmentTypes = Arrays.asList(shipmentType);
			m.addObject("shipmentType", shipmentTypes);
		}else {
			//read all DB rows
			List<ShipmentType> shipmentTypes = service.getAllShipmentTypes();
			m.addObject("shipmentType", shipmentTypes);
		}
		return m;
	}
	
	//9.pdf Export
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="shipmentTypeId",required=false)Integer shipmentTypeId) {
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypePdfView());
		if(shipmentTypeId != null) {
			//exactly one row
			ShipmentType shipmentType = service.getOneShipmentType(shipmentTypeId);
			List<ShipmentType> shipmentTypes = Arrays.asList(shipmentType);
			m.addObject("shipmentType", shipmentTypes);
		}else {
			//all rows
			List<ShipmentType> shipmentTypes = service.getAllShipmentTypes();
			m.addObject("shipmentType", shipmentTypes);
		}
		return m;
	}
	
	// 10. Charts pieChart and BarChart
	@RequestMapping("/charts")
	public String generateCharts() {
		String path = context.getRealPath("/");
		System.out.println(path);
		List<Object[]> shipmentTypes = service.getShipmentTypeModeCount();
		util.generatePie(path, shipmentTypes);
		util.generateBarChart(path, shipmentTypes);
		
		return "ShipmentTypeCharts";
	}
}
