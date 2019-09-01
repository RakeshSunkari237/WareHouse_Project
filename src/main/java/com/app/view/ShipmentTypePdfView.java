package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class ShipmentTypePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//set file name
		response.addHeader("Content-Disposition", "attachment;filename=Shipments.pdf");
		
		//read data from model
		@SuppressWarnings("unchecked")
		List<ShipmentType> shipmentTypes = (List<ShipmentType>) model.get("shipmentType");
		
		//create any element
		document.add(new Paragraph("All ShipmentTypes"));
		
		PdfPTable p=new PdfPTable(6);
		p.addCell("ID");
		p.addCell("Mode");
		p.addCell("Code");
		p.addCell("status");
		p.addCell("Grade");
		p.addCell("note");
		
		for(ShipmentType s:shipmentTypes) {
			p.addCell(s.getShipmentTypeId().toString());
			p.addCell(s.getShipmentTypeMode());
			p.addCell(s.getShipmentTypeCode());
			p.addCell(s.getEnableShipment());
			p.addCell(s.getShipmentTypeGrade());
			p.addCell(s.getDescrpition());
			
		}
		document.add(p);
		document.add(new Paragraph(new Date().toString()));
	}

}
