package com.report.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.report.entity.CitizenPlan;
import com.report.repository.CitizenPlanRepository;
import com.report.request.SearchRequest;
import com.report.util.EmailUtils;
import com.report.util.ExcelGenerator;
import com.report.util.PdfGendereator;

@Service("CitizenPlanServiceImpl")

public class CitizenPlanServiceImpl implements CitizenPlanService {
	@Autowired
	 CitizenPlanRepository citizenPlanRepo;
	@Autowired
	private ExcelGenerator excelGeneator;
	@Autowired
	private PdfGendereator pdfGendereator;
	@Autowired
	EmailUtils emailUtils;
	

	@Override
	public List<String> getPlanNames() {
		return citizenPlanRepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		return citizenPlanRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity=new CitizenPlan();
		if(null!=request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if(null!=request.getPlanStatus() &&!"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if(null!=request.getGender() &&!"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if(null!=request.getStartDate() &&!"".equals(request.getStartDate())) {
			String startDate=request.getStartDate();
			System.out.println(startDate);
			DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate=LocalDate.parse(startDate,format);
			entity.setPlanStartDate(localDate);
		}
		if(null!=request.getEndDate() &&!"".equals(request.getEndDate())) {
			String endDate=request.getEndDate();
			System.out.println(endDate);
			DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate=LocalDate.parse(endDate,format);
			entity.setPlanEndDate(localDate);
		}
			
		
		return citizenPlanRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		File f=new File("Plans.xls");

		List<CitizenPlan> plan=citizenPlanRepo.findAll();
		excelGeneator.generate(response, plan,f);
		String  subject="Test mail subject";
		String body="<h1>Test Mail body</h1>";
		String to="manonmani.pandukumar@gmail.com";
		
		emailUtils.sendMail(subject, body, to,f);
		f.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		File f=new File("Plans.pdf");

		List<CitizenPlan> plans=citizenPlanRepo.findAll();
		pdfGendereator.generate(response, plans,f);
		String  subject="Test mail subject";
		String body="<h1>Test Mail body</h1>";
		String to="manonmani.pandukumar@gmail.com";

		emailUtils.sendMail(subject, body, to,f);
		f.delete();
		return true;
	}

	}
