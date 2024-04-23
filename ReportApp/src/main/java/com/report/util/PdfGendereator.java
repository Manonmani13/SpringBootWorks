package com.report.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.report.entity.CitizenPlan;
import com.report.repository.CitizenPlanRepository;

import jakarta.servlet.http.HttpServletResponse;
@Component
public class PdfGendereator {
	@Autowired
	private CitizenPlanRepository planRepo;
	
	public void generate(HttpServletResponse response,List<CitizenPlan> plans,File f) throws  IOException
	{
		Document document =new Document(PageSize.A4);
//		PdfWriter pdfWriter= PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();
		Font fonttitle=FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fonttitle.setSize(20);
		Paragraph p=new Paragraph("Citizen Plans Info",fonttitle);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(p);
		PdfPTable table=new PdfPTable(6);
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date");
		for(CitizenPlan plan:plans)
		{
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(String.valueOf(plan.getCitizenName()));
			table.addCell(String.valueOf(plan.getPlanName()));
			table.addCell(String.valueOf(plan.getPlanStatus()));
			table.addCell(String.valueOf(plan.getPlanStartDate())+"");
			table.addCell(String.valueOf(plan.getPlanEndDate())+"");
		}
		document.add(table);
		document.close();
	}
}
