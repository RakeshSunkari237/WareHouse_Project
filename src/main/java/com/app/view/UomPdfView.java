package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class UomPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//set file name
		response.addHeader("Content-Dosiposition", "attachment;filename=uom.pdf");
		
		//get the data from the model
		@SuppressWarnings("unchecked")
		List<Uom> uoms = (List<Uom>) model.get("uoms");
		
		
		//create document
		document.add(new Paragraph("Uoms"));
		
		PdfPTable p=new PdfPTable(4);
		p.addCell("uomId");
		p.addCell("uomType");
		p.addCell("Model");
		p.addCell("descrpition");
		
		for(Uom u:uoms) {
			p.addCell(u.getUomId().toString());
			p.addCell(u.getUomType());
			p.addCell(u.getUomModel());
			p.addCell(u.getUomDescrpition());
			
		}
		
		document.add(p);
		document.add(new Paragraph(new Date().toString()));
	}

	
}
