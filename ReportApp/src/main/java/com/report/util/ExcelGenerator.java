package com.report.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.report.entity.CitizenPlan;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {
	public void generate(HttpServletResponse response,List<CitizenPlan> plan,File f) throws Exception {
		Workbook workbook=new HSSFWorkbook();
	
		Sheet sheet=workbook.createSheet("plans-data");
		Row headerRow=sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("Plan Start Date");
		headerRow.createCell(5).setCellValue("Plan End Date");
		headerRow.createCell(6).setCellValue("Benefit Amt");
		int datarowIndex=1;
		for(CitizenPlan pla:plan)
		{
			Row dataRow =sheet.createRow(datarowIndex);
			dataRow.createCell(0).setCellValue(pla.getCitizenId());
			dataRow.createCell(1).setCellValue(pla.getCitizenName());
			dataRow.createCell(2).setCellValue(pla.getPlanName());
			dataRow.createCell(3).setCellValue(pla.getPlanStatus());
			if(null!=pla.getPlanStartDate())
				dataRow.createCell(4).setCellValue(pla.getPlanStartDate());
			else
					dataRow.createCell(4).setCellValue("N/A");
			if(null!=pla.getPlanEndDate())
				dataRow.createCell(5).setCellValue(pla.getPlanEndDate());
			else
					dataRow.createCell(5).setCellValue("N/A");
			if(null!=pla.getBenefitAmt())
			dataRow.createCell(6).setCellValue(pla.getBenefitAmt());
			else
				dataRow.createCell(6).setCellValue("N/A");

			datarowIndex++;

		}
		FileOutputStream fos=new FileOutputStream(f);
		workbook.write(fos);
		ServletOutputStream stream=response.getOutputStream();
		workbook.write(stream);
		workbook.close();
	}

}
