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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.util.WhUserTypeUtil;
import com.app.view.WhUserExcelView;
import com.app.view.WhUserTypePdfView;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private WhUserTypeUtil util;
	
	// 1.show Register page
	@RequestMapping("/register")
	public String showRegister(ModelMap map) {
		map.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeRegister";
	}
	
	// 2.insert data in DB
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String save(@ModelAttribute WhUserType whUserType,ModelMap map) {
		//call service to save data and send to UI
		Integer whUserTypeId = service.saveWhUserType(whUserType);
		map.addAttribute("message", "WhUser saved with id : "+whUserTypeId+" successfully ");
		map.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeRegister";
	}
	
	//3. view All user Types
	@RequestMapping("/viewAll")
	public String viewAllWhUserTypes(ModelMap map) {
		//call service to get all Records and send to UI
		map.addAttribute("whUserTypes", service.getAllWhUserTypes());
		return "WhUserTypeData";
	}
	
	//4.delete WhUserType By Id
	
	@RequestMapping("/delete")
	public String deleteOneWhUser(@RequestParam Integer whUserTypeId,ModelMap map) {
		// cal service to delete one user 
		service.deleteWhUserType(whUserTypeId);
		map.addAttribute("message", "One WhUser with Id : "+whUserTypeId+" is deleted successfully ");
		map.addAttribute("whUserTypes", service.getAllWhUserTypes());
		return "WhUserTypeData";
	}
	
	// 5. view one User 
	@RequestMapping("/view")
	public String viewOneUser(@RequestParam Integer whUserTypeId,ModelMap map) {
		//call service to get one user
		map.addAttribute("whUserType", service.getOneWhUserType(whUserTypeId));
		return "WhUserTypeViewOne";
	}
	
	// 6. show Edit page
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam Integer whUserTypeId,ModelMap map) {
		map.addAttribute("whUserType", service.getOneWhUserType(whUserTypeId));
		return "WhUseTypeEdit";
	}
	
	//7. do Update
	@RequestMapping("/update")
	public String updateOneWhUser(@ModelAttribute WhUserType whUserType,ModelMap map) {
		//call service to update the user
		service.updateWhUserType(whUserType);
		map.addAttribute("message", "WhUserType with Id : "+whUserType.getWhUserTypeId()+" successfully updated");
		map.addAttribute("whUserTypes", service.getAllWhUserTypes());
		return "WhUserTypeData";
	}
	
	//8 Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="whUserTypeId",required=false)Integer whUserTypeId) {
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserExcelView());
		if(whUserTypeId != null) {
			//exactly one row
			WhUserType whUserType = service.getOneWhUserType(whUserTypeId);
			List<WhUserType> whUserTypes = Arrays.asList(whUserType);
			m.addObject("whUserTypes", whUserTypes);
		}
		else {
			// all rows
			List<WhUserType> whUserTypes = service.getAllWhUserTypes();
			m.addObject("whUserTypes", whUserTypes);
		}
		return m;
	}
	
	// 9.pdf export
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="whUserTypeId",required=false)Integer whUserTypeId,ModelMap map) {
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypePdfView());
		if(whUserTypeId != null) {
			//Exactly one row
			WhUserType whUserType = service.getOneWhUserType(whUserTypeId);
			List<WhUserType> whUserTypes = Arrays.asList(whUserType);
			m.addObject("whUserTypes", whUserTypes);
		}else {
			//all rows
			List<WhUserType> whUserTypes = service.getAllWhUserTypes();
			m.addObject("whUserTypes", whUserTypes);
		}
		return m;
	}
	
	@RequestMapping("/charts")
	public String generateCharts() {

		String path = context.getRealPath("/");
		List<Object[]> whUserTypes = service.getWhUserTypeCount();
		util.generatePieChart(path, whUserTypes);
		util.generateBarChart(path, whUserTypes);
		return "WhUserTypeCharts";
	}
}
