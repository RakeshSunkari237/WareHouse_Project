package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.util.OrderMethodUtil;
import com.app.view.OrderMethodExcelView;
import com.app.view.OrderMethodPdfView;

@Controller
@RequestMapping("/order")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private OrderMethodUtil util;
	
	//1.show Register page
	@RequestMapping("/register")
	public String showRegister(@ModelAttribute OrderMethod orderMethod,ModelMap map) {
		map.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}
	
	//2.save OrderMethod
	@RequestMapping("/insert")
	public String saveOrderMethod(@ModelAttribute OrderMethod orderMethod,ModelMap map) {
		//call service to save OrderMethod
		Integer orderMethodId = service.saveOrderMethod(orderMethod);
		map.addAttribute("message", "OrderMethod saved with id : "+orderMethodId);
		//clean form
		map.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}
	
	// 3.view all OrderMethods
	@RequestMapping("/viewAll")
	public String viewAllOrderMethods(ModelMap map) {
		//call service to get data
		map.addAttribute("orderMethods", service.getAllOrderMethods());
		return "OrderMethodData";
	}
	
	//4.view One OrderMethod
	@RequestMapping("/view")
	public String viewOneOrderMethod(@RequestParam Integer orderMethodId,ModelMap map) {
		//call service to get One OrderMethod and send UI
		map.addAttribute("orderMethod", service.getOneOrderMethod(orderMethodId));
		return "OrderMethodViewOne";
	}
	
	//5.Delete One OrderMethod
	@RequestMapping("/delete")
	public String deleteOrderMethod(@RequestParam Integer orderMethodId,ModelMap map) {
		// call service to delete OrderMethod and send to UI
		service.deleteOrderMethod(orderMethodId);
		map.addAttribute("message","OrderMethod details are deleted with id : "+orderMethodId);
		map.addAttribute("orderMethods", service.getAllOrderMethods());
		return "OrderMethodData";
	}
	
	//6.show Edit page
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam Integer orderMethodId,ModelMap map) {
		// get one OrderMethod By id
		map.addAttribute("orderMethod", service.getOneOrderMethod(orderMethodId));
		return "OrderMethodEdit";
	}
	
	//7.doUpdate
	@RequestMapping("/update")
	public String doUpdate(@ModelAttribute OrderMethod orderMethod,ModelMap map) {
		service.updateOrderMethod(orderMethod);
		map.addAttribute("message", "Order Method id :"+orderMethod.getOrderMethodId()+" is successfully Updated");
		map.addAttribute("orderMethods", service.getAllOrderMethods());
		return "OrderMethodData";
	}
	
	//8.Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="orderMethodId",required=false)Integer orderMethodId) {
		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodExcelView());
		
		if(orderMethodId != null) {
			//Exactly one row
			OrderMethod orderMethod = service.getOneOrderMethod(orderMethodId);
			List<OrderMethod> orderMethods = Arrays.asList(orderMethod);
			m.addObject("orderMethods", orderMethods);
		}
		else {
			// all rows
			m.addObject("orderMethods", service.getAllOrderMethods());
			
		}
		return m;
	}
	
	
	//9.pdf export
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="orderMethodId",required=false)Integer orderMethodId) {
		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodPdfView());
		
		if(orderMethodId != null) {
			//Exactly one  row
			m.addObject("orderMethods", Arrays.asList(service.getOneOrderMethod(orderMethodId)));
			
		}
		else {
			//all rows
			m.addObject("orderMethods", service.getAllOrderMethods());
			
		}
		return m;
	}
	
	//10.charts (pieCharts and barchart)
	@RequestMapping("/charts")
	public String pieChart() {

		String path = context.getRealPath("/");
		List<Object[]> orderModes=service.getOrderMethodModeCount();
		util.generatePieChart(path, orderModes);
		util.generateBarChart(path, orderModes);

		return "OrderMethodCharts";
	}


}
