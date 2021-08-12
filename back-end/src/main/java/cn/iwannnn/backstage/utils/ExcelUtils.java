package cn.iwannnn.backstage.utils;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelUtils<T> {

	public List<T> getData(MultipartFile file) throws IOException {

		List<T> res = null;
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		int numberOfSheets = workbook.getNumberOfSheets();
		for (int i = 0; i < numberOfSheets; i++) {
			XSSFSheet sheet = workbook.getSheetAt(i);
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			for (int j = 1; j < physicalNumberOfRows; j++) {
				XSSFRow row = sheet.getRow(j);
				int physicalNumberOfCells = row.getPhysicalNumberOfCells();
				for (int k = 0; k < physicalNumberOfCells; k++) {
					XSSFCell cell = row.getCell(k);
					System.out.print(cell + " ");
				}
				System.out.println();
			}
		}
		workbook.close();
		return res;
	}
}
