package com.merck.sda.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.merck.sda.domain.Historical;
import com.merck.sda.domain.Ownership;
import com.merck.sda.domain.Snapshot;
import com.merck.sda.domain.UserAccess;
import com.merck.sda.dto.HistoricalDTO;
import com.merck.sda.dto.OwnershipDTO;
import com.merck.sda.dto.SnapshotDTO;
import com.merck.sda.dto.UserAccessDTO;
import com.merck.sda.service.ReportService;
import com.merck.sda.utils.Utills;

@Controller("reportcontroller")
@Path("/report")
public class ReportController extends BaseController {

	private static final Log log = LogFactory.getLog(ReportController.class);

	@Autowired
	private ReportService reportService;

	@POST
	@Path("/historicalreport")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
	public Response historicalReport(HistoricalDTO historicaldto) {
		try {
			Date dFrom = Utills.stringToDateConv(historicaldto.getStartdate());
			Date dTo = Utills.stringToDateConv(historicaldto.getEnddate());
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet detSheet = workbook.createSheet("HISTORICAL");
			XSSFCellStyle style = workbook.createCellStyle();
			style.setBorderBottom((short) 1);
			XSSFFont font = workbook.createFont();
			font.setFontHeightInPoints((short) 9);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);

			Row detSheetheader = detSheet.createRow(0);
			detSheetheader.createCell(0).setCellValue("Server Name");
			detSheetheader.createCell(1).setCellValue("Folder Name");
			detSheetheader.createCell(2).setCellValue("User ISID");
			detSheetheader.createCell(3).setCellValue("Date Status");
			detSheetheader.createCell(4).setCellValue("Type");

			for (int j = 0; j <= 4; j++)
				detSheetheader.getCell(j).setCellStyle(style);

			List<Historical> hisListData = reportService.getHistoricalDetails(historicaldto, dFrom, dTo);
			int rownum = 1;
			for (Historical hstDet : hisListData) {
				Row row1 = detSheet.createRow(rownum++);
				int cellnum = 0;
				for (Object obj : getHistoricalDetails(hstDet)) {
					Cell cell = row1.createCell(cellnum++);
					if (obj instanceof String) {
						cell.setCellValue((String) obj);
					}
					if (obj instanceof Integer) {
						cell.setCellValue((Integer) obj);
					}
					if (obj instanceof Date) {
						SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
						String cellvalue = dateformat.format(obj);
						cell.setCellValue((String) cellvalue);
					}
					if (obj instanceof BigDecimal) {
						double d = ((BigDecimal) obj).doubleValue();
						cell.setCellValue((Double) d);
					}
				}
			}

			File file = new File("HISTORICAL report File");
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.close();
			return Response.ok((Object) file).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}

	}

	@POST
	@Path("/ownershipreport")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
	public Response ownershipReport(OwnershipDTO ownershipDTO) {
		try {
			Date dFrom = Utills.stringToDateConv(ownershipDTO.getStartdate());
			Date dTo = Utills.stringToDateConv(ownershipDTO.getEnddate());
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet detSheet = workbook.createSheet("Ownership");

			XSSFCellStyle style = workbook.createCellStyle();
			style.setBorderBottom((short) 1);

			XSSFFont font = workbook.createFont();
			font.setFontHeightInPoints((short) 9);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);

			Row detSheetheader = detSheet.createRow(0);
			detSheetheader.createCell(0).setCellValue("Type id");
			detSheetheader.createCell(1).setCellValue("Server Name");
			detSheetheader.createCell(2).setCellValue("Folder Name");
			detSheetheader.createCell(3).setCellValue("Owner ISID");
			detSheetheader.createCell(4).setCellValue("Ownership Type");

			for (int j = 0; j <= 4; j++)
				detSheetheader.getCell(j).setCellStyle(style);

			List<Ownership> hisListData = reportService.getOwnershipDetails(ownershipDTO, dFrom, dTo);
			int rownum = 1;
			for (Ownership hstDet : hisListData) {
				Row row1 = detSheet.createRow(rownum++);
				int cellnum = 0;
				for (Object obj : getOwnershipDetails(hstDet)) {
					Cell cell = row1.createCell(cellnum++);
					if (obj instanceof String) {
						cell.setCellValue((String) obj);
					}
					if (obj instanceof Integer) {
						cell.setCellValue((Integer) obj);
					}
					if (obj instanceof Date) {
						SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
						String cellvalue = dateformat.format(obj);
						cell.setCellValue((String) cellvalue);
					}
					if (obj instanceof BigDecimal) {
						double d = ((BigDecimal) obj).doubleValue();
						cell.setCellValue((Double) d);
					}
				}
			}

			File file = new File("Ownership report File");
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.close();
			return Response.ok((Object) file).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}

	}

	@POST
	@Path("/snapshotreport")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
	public Response snapshotReport(SnapshotDTO snapshotDTO) {
		try {
			Date dFrom = Utills.stringToDateConv(snapshotDTO.getStartdate());
			Date dTo = Utills.stringToDateConv(snapshotDTO.getEnddate());
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet detSheet = workbook.createSheet("Snapshot");

			XSSFCellStyle style = workbook.createCellStyle();
			style.setBorderBottom((short) 1);

			XSSFFont font = workbook.createFont();
			font.setFontHeightInPoints((short) 9);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);

			Row detSheetheader = detSheet.createRow(0);
			detSheetheader.createCell(0).setCellValue("Type ID");
			detSheetheader.createCell(1).setCellValue("Server Name");
			detSheetheader.createCell(2).setCellValue("Folder Name");
			detSheetheader.createCell(3).setCellValue("User ISID");
			detSheetheader.createCell(4).setCellValue("Type");
			detSheetheader.createCell(5).setCellValue("Date User Added");
			detSheetheader.createCell(6).setCellValue("User Added CPI");
			detSheetheader.createCell(7).setCellValue("Username");
			detSheetheader.createCell(8).setCellValue("Email Address");
			detSheetheader.createCell(9).setCellValue("Title");
			detSheetheader.createCell(10).setCellValue("Department");
			detSheetheader.createCell(11).setCellValue("Manager");

			for (int j = 0; j <= 11; j++)
				detSheetheader.getCell(j).setCellStyle(style);

			List<Snapshot> hisListData = reportService.getSnapshotDetails(snapshotDTO, dFrom, dTo);
			int rownum = 1;
			for (Snapshot hstDet : hisListData) {
				Row row1 = detSheet.createRow(rownum++);
				int cellnum = 0;
				for (Object obj : getSnapshotDetails(hstDet)) {
					Cell cell = row1.createCell(cellnum++);
					if (obj instanceof String) {
						cell.setCellValue((String) obj);
					}
					if (obj instanceof Integer) {
						cell.setCellValue((Integer) obj);
					}
					if (obj instanceof Date) {
						SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
						String cellvalue = dateformat.format(obj);
						cell.setCellValue((String) cellvalue);
					}
					if (obj instanceof BigDecimal) {
						double d = ((BigDecimal) obj).doubleValue();
						cell.setCellValue((Double) d);
					}
				}
			}

			File file = new File("Snapshot report File");
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.close();
			return Response.ok((Object) file).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}

	}

	@POST
	@Path("/useraccessreport")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
	public Response userAccessReport(UserAccessDTO userAccessDTO) {

		try {
			Date dFrom = Utills.stringToDateConv(userAccessDTO.getStartdate());
			Date dTo = Utills.stringToDateConv(userAccessDTO.getEnddate());
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet detSheet = workbook.createSheet("USERACCESS");

			XSSFCellStyle style = workbook.createCellStyle();
			style.setBorderBottom((short) 1);

			XSSFFont font = workbook.createFont();
			font.setFontHeightInPoints((short) 9);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);

			Row detSheetheader = detSheet.createRow(0);
			detSheetheader.createCell(0).setCellValue("Server Name");
			detSheetheader.createCell(1).setCellValue("Folder Name");
			detSheetheader.createCell(2).setCellValue("Read Type & ISID");
			detSheetheader.createCell(3).setCellValue("Read/Write Type & ISID");

			for (int j = 0; j <= 3; j++)
				detSheetheader.getCell(j).setCellStyle(style);

			List<UserAccess> hisListData = reportService.getUserAccessDetails(userAccessDTO, dFrom, dTo);
			int rownum = 1;
			for (UserAccess hstDet : hisListData) {
				Row row1 = detSheet.createRow(rownum++);
				int cellnum = 0;
				for (Object obj : getUserAccessDetails(hstDet)) {
					Cell cell = row1.createCell(cellnum++);
					if (obj instanceof String) {
						cell.setCellValue((String) obj);
					}
					if (obj instanceof Integer) {
						cell.setCellValue((Integer) obj);
					}
					if (obj instanceof Date) {
						SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
						String cellvalue = dateformat.format(obj);
						cell.setCellValue((String) cellvalue);
					}
					if (obj instanceof BigDecimal) {
						double d = ((BigDecimal) obj).doubleValue();
						cell.setCellValue((Double) d);
					}
				}
			}

			File file = new File("USERACCESS report File");
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.close();
			return Response.ok((Object) file).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}

	}

	private List<Object> getHistoricalDetails(Historical hist) {
		List<Object> objArr = new ArrayList<Object>();
		objArr.add(hist.getServername());
		objArr.add(hist.getFoldername());
		objArr.add(hist.getUserISID());
		objArr.add(hist.getDateStatus());
		objArr.add(hist.getType());

		return objArr;
	}

	private List<Object> getOwnershipDetails(Ownership own) {
		List<Object> objArr = new ArrayList<Object>();
		objArr.add(own.getTypeid());
		objArr.add(own.getServername());
		objArr.add(own.getFoldername());
		objArr.add(own.getOwnerISID());
		objArr.add(own.getOwnershiptype());
		return objArr;
	}

	private List<Object> getSnapshotDetails(Snapshot snap) {
		List<Object> objArr = new ArrayList<Object>();
		objArr.add(snap.getTypeid());
		objArr.add(snap.getServername());
		objArr.add(snap.getFoldername());
		objArr.add(snap.getUserISID());
		objArr.add(snap.getType());
		objArr.add(snap.getDateuseradded());
		objArr.add(snap.getUseraddedCPI());
		objArr.add(snap.getUsername());
		objArr.add(snap.getEmailaddress());
		objArr.add(snap.getTitle());
		objArr.add(snap.getDepartment());
		objArr.add(snap.getManager());
		return objArr;
	}

	private List<Object> getUserAccessDetails(UserAccess usracs) {
		List<Object> objArr = new ArrayList<Object>();
		objArr.add(usracs.getServername());
		objArr.add(usracs.getFoldername());
		objArr.add(usracs.getReadtypeandisid());
		objArr.add(usracs.getReadwritetypeandisid());
		return objArr;
	}

}
