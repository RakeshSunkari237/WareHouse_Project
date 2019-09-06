package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		//set filename
		response.addHeader("Content-Disposition", "attachment;filename=OrderMethods.pdf");
		
		//get data from the model
		@SuppressWarnings("unchecked")
		List<OrderMethod> orderMethods = (List<OrderMethod>) model.get("orderMethods");
		
		//create document
		document.add(new Paragraph("Order Method Details"));
		
		PdfPTable p=new PdfPTable(6);
		p.addCell("OrderMethod Id");
		p.addCell("Order Mode");
		p.addCell("Order Code");
		p.addCell("Execute Type");
		p.addCell("Order Accept");
		p.addCell("description");
		
		
		for(OrderMethod om:orderMethods) {
			p.addCell(om.getOrderMethodId().toString());
			p.addCell(om.getOrderMethodMode());
			p.addCell(om.getOrderMethodCode());
			p.addCell(om.getExcuteType());
			p.addCell(om.getOrderMethodAccept().toString());
			p.addCell(om.getDescrpition());
			
		}
		
		document.add(p);
		document.add(new Paragraph(new Date().toString()));
		
	}

}
