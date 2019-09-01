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

import com.app.model.Uom;
@Component
public class UomExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//set file name
		response.addHeader("Content-Dosiposition", "attachment;filename=uom.xlsx");
		
		//read data from the model
		@SuppressWarnings("unchecked")
		List<Uom> uoms = (List<Uom>) model.get("uoms");
		
		//create one sheet
		Sheet sheet = workbook.createSheet("uoms");
		
		//set Header
		setHeader(sheet);
		
		//set body
		setBody(sheet,uoms);
		
	}
	
	private void setHeader(Sheet sheet) {
		
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("Type");
		row.createCell(2).setCellValue("Model");
		row.createCell(3).setCellValue("descrpition");
	}

	private void setBody(Sheet sheet,List<Uom> uoms) {
		int rowNum = 1;
		for(Uom u:uoms) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(u.getUomId());
			row.createCell(1).setCellValue(u.getUomType());
			row.createCell(2).setCellValue(u.getUomModel());
			row.createCell(3).setCellValue(u.getUomDescrpition());
		}
		
	}
}
