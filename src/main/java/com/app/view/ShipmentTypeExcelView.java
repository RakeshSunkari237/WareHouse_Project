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

import com.app.model.ShipmentType;

@Component
public class ShipmentTypeExcelView extends AbstractXlsxView {


	protected void buildExcelDocument(Map<String, Object> model, 
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//set file name
		response.addHeader("Content-Disposition", "attachment;filename=Shipments.xlsx");
		
		//read data from the model
		@SuppressWarnings({ "unused", "unchecked" })
		 List<ShipmentType> shipmentTypes=(List<ShipmentType>) model.get("shipmentType");
		
		//create one new sheet
		Sheet sheet = workbook.createSheet("Shipments");
		
		//create Header
		setHeader(sheet);
		
		//create Body
		setbody(sheet,shipmentTypes);
		
	}

	private void setHeader(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("Shipment Id");
		row.createCell(1).setCellValue("Shipment Mode");
		row.createCell(2).setCellValue("Shipment Code");
		row.createCell(3).setCellValue("Enable Shipment ");
		row.createCell(4).setCellValue("Shipment Grade");
		row.createCell(5).setCellValue("description");
	}
	
	private void setbody(Sheet sheet, List<ShipmentType> shipmentTypes) {
		int rowNum=1;
		for(ShipmentType s:shipmentTypes) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(s.getShipmentTypeId());
			row.createCell(1).setCellValue(s.getShipmentTypeMode());
			row.createCell(2).setCellValue(s.getShipmentTypeCode());
			row.createCell(3).setCellValue(s.getEnableShipment());
			row.createCell(4).setCellValue(s.getShipmentTypeGrade());
			row.createCell(5).setCellValue(s.getDescrpition());
			
		}
	}


}
