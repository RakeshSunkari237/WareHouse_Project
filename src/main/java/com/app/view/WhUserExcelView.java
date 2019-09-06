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

import com.app.model.WhUserType;

@Component
public class WhUserExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//set the file name
		response.addHeader("Content-Disposition", "attachment;filename=WhUserExcel.xlsx");
		
		//read data from the model
		@SuppressWarnings("unchecked")
		List<WhUserType> whUserTypes = (List<WhUserType>) model.get("whUserTypes");
		
		//create sheet
		Sheet sheet = workbook.createSheet("whUserTypes");
		
		//setHeader
		setHeader(sheet);
		
		//setBody
		setBody(sheet,whUserTypes);
		
	}

	private void setHeader(Sheet sheet) {
		
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("User Id");
		row.createCell(1).setCellValue("Type");
		row.createCell(2).setCellValue("Code");
		row.createCell(3).setCellValue("For");
		row.createCell(4).setCellValue("Email");
		row.createCell(5).setCellValue("Contact");
		row.createCell(6).setCellValue("Id Type");
		row.createCell(7).setCellValue("Id Number");
	}
	
	private void setBody(Sheet sheet,List<WhUserType> whUserTypes) {
		int rowNum = 1;
		for(WhUserType wh:whUserTypes) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(wh.getWhUserTypeId());
			row.createCell(1).setCellValue(wh.getUserType());
			row.createCell(2).setCellValue(wh.getWhUserCode());
			row.createCell(3).setCellValue(wh.getWhUserFor());
			row.createCell(4).setCellValue(wh.getWhUserEmail());
			row.createCell(5).setCellValue(wh.getWhUserContact());
			row.createCell(6).setCellValue(wh.getWhUserIdType());
			row.createCell(7).setCellValue(wh.getWhUserIdNumber());
			
		}
		
		
	}
}
