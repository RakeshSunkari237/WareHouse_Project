package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

@Component
public class OrderMethodExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		//set filename
		response.addHeader("Content-Dispositoin", "attachment;filename=OrderMethod.xlsx");
		
		//get data from the model
		@SuppressWarnings("unchecked")
		List<OrderMethod> orderMethods = (List<OrderMethod>) model.get("orderMethods");
		
		
		//create one sheet
		Sheet sheet = workbook.createSheet("Order Methods");
		
		
		//set Header
		setHeader(sheet);
		
		//set Body
		setBody(sheet,orderMethods);
		
	}

	private void setHeader(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("Mode");
		row.createCell(2).setCellValue("Code");
		row.createCell(3).setCellValue("executeType");
		row.createCell(4).setCellValue("Accept");
		row.createCell(5).setCellValue("desc");
		
	}
	
	private void setBody(Sheet sheet,List<OrderMethod> orderMethods) {
		
		int rowNum = 1;
		 
		for(OrderMethod om:orderMethods) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(om.getOrderMethodId());
			row.createCell(1).setCellValue(om.getOrderMethodMode());
			row.createCell(2).setCellValue(om.getOrderMethodCode());
			row.createCell(3).setCellValue(om.getExcuteType());
			row.createCell(4).setCellValue(om.getOrderMethodAccept().toString());
			row.createCell(5).setCellValue(om.getDescrpition());
			
		}
		
	}
	
}
