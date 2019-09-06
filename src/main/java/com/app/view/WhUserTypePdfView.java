package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class WhUserTypePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//set file name
		response.addHeader("Content-Disposition", "attachment;filename=WhUserType.pdf");
		
		//read data from the model
		@SuppressWarnings("unchecked")
		List<WhUserType> whUserTypes = (List<WhUserType>) model.get("whUserTypes");
		
		//create document
		document.add(new Paragraph("WhUserTypes"));
		PdfPTable p=new PdfPTable(8);
		p.addCell("WhUser Id");
		p.addCell("WhUser Type");
		p.addCell("WhUser Code");
		p.addCell("WhUser For");
		p.addCell("WhUser Email");
		p.addCell("WhUser Contact");
		p.addCell("WhUser Id Type");
		p.addCell("WhUser Id Number");
	
		for(WhUserType wh:whUserTypes) {
			p.addCell(wh.getWhUserTypeId().toString());
			p.addCell(wh.getUserType());
			p.addCell(wh.getWhUserCode());
			p.addCell(wh.getWhUserFor());
			p.addCell(wh.getWhUserEmail());
			p.addCell(wh.getWhUserContact());
			p.addCell(wh.getWhUserIdType());
			p.addCell(wh.getWhUserIdNumber());
			
		}
		
		document.add(p);
		document.add(new Paragraph(new Date().toString()));
	}

}
