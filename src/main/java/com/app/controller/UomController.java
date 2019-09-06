package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.UomUtil;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;
	
	@Autowired
	private UomUtil util;

	@Autowired
	private ServletContext context;
	
	// 1.show Register page
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		map.addAttribute("uom", new Uom());
		return "UomRegister";
	}

	//2.save data
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String save(@ModelAttribute Uom uom,ModelMap map) {

		//call service to insert data
		Integer uomId = service.saveUom(uom);
		//Construct success msg and send to UI
		String msg="Uom saved with Id : "+uomId;
		map.addAttribute("message", msg);
		map.addAttribute("uom", new Uom());
		return "UomRegister";
	}
	
	
	
	//3.viewAll Records
	@RequestMapping("/viewAll")
	public String  viewAll(ModelMap map) {

		//call service to get all records
		List<Uom> uoms = service.getAllUoms();
		map.addAttribute("uoms", uoms);
		return "UomData";
	}
	
	//4.delete record by Id
		@RequestMapping("delete")
		public String delete(@RequestParam Integer uomId,ModelMap map) {
			//call service to delete record
			service.deleteUom(uomId);
			map.addAttribute("message", "One Uom details with id : "+ uomId+" is deleted");
			map.addAttribute("uoms", service.getAllUoms());
			return "UomData";
		}

	
	// 5.view one row or Object
	@RequestMapping("/view")
	public String viewOne(@RequestParam Integer uomId,ModelMap map) {
		
		//call service to get one record
		Uom uom = service.getOneUom(uomId);
		map.addAttribute("uom", uom);
		return "UomViewOne";
	}
	
	// 6.show Edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam Integer uomId,ModelMap map) {
		
		//call service to get one Object and send to UI
		Uom uom = service.getOneUom(uomId);
		map.addAttribute("uom", uom);

		return "UomEdit";
	}
	
	// 7.do Update
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute Uom uom,ModelMap map) {
		
		//call service for  update Record
		service.updateUom(uom);
		
		//get the all data and send to UI
		List<Uom> uoms = service.getAllUoms();
		map.addAttribute("uoms", uoms);
		map.addAttribute("message", "Uom Id "+uom.getUomId()+" is successfully updated ");
		return "UomData";
	}
	
	//8.Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="uomId",required=false)Integer uomId,ModelMap map) {
	ModelAndView m=new ModelAndView();
	m.setView(new UomExcelView());
	if(uomId != null) {
		//Exactly one row
		Uom uom = service.getOneUom(uomId);
		List<Uom> uoms = Arrays.asList(uom);
		map.addAttribute("uoms", uoms);
	}else {
		//all rows
		List<Uom> uoms = service.getAllUoms();
		map.addAttribute("uoms", uoms);
	}
	return m;
	}
	
	//9.pdf Export
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="uomId",required=false)Integer uomId,ModelMap map) {
		ModelAndView m=new ModelAndView();
		m.setView(new UomPdfView());
		
		if(uomId != null) {
			Uom uom = service.getOneUom(uomId);
			List<Uom> uoms = Arrays.asList(uom);
			m.addObject("uoms", uoms);
		}else {
			List<Uom> uoms = service.getAllUoms();
			m.addObject("uoms", uoms);
		}
		return m;
	}
	
	// 10.Charts pieChart and BarChart
	@RequestMapping("/charts")
	public String showCharts() {
		String path = context.getRealPath("/");
		List<Object[]> uoms = service.getUomTypeCount();
		util.generatePieChart(path, uoms);
		util.generateBarChart(path, uoms);
		return "UomCharts";
	}
}
