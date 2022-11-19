package ppe.projet.site.helper;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ppe.projet.site.entites.Rubrique;

public class RubriqueExeclExporter {

	private XSSFWorkbook workbook ;
	private XSSFSheet sheet;
	
	private List <Rubrique> ListRubriques ;
	
	
	
	public RubriqueExeclExporter(List<Rubrique> listRubriques) {
		super();
		ListRubriques = listRubriques;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Rubriques");
	}

	private void writeHeaderRow() {
	
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Rubrique ID");
		
		
	
	}
	
	private void writeDataRows() {
		
	}
	public void export (HttpServletResponse response) throws IOException {
	
		writeHeaderRow();
		writeDataRows();
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
		
	}
}
