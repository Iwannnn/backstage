package cn.iwannnn.backstage.utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ExcelUtils {
	private static FormulaEvaluator evaluator;

	public static <T> List<T> importData(MultipartFile file, Class<T> clazz)
			throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {

		List<T> res = new ArrayList<>();
		List<String> valueList = new ArrayList<>();
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		XSSFSheet sheet = null;
		XSSFRow tittleRow = null, row = null;
		XSSFCell cell = null;
		int numberOfSheets = workbook.getNumberOfSheets();
		for (int i = 0; i < numberOfSheets; i++) {
			sheet = workbook.getSheetAt(i);
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			tittleRow = sheet.getRow(0);
			int physicalNumberOfCells = tittleRow.getPhysicalNumberOfCells();
			for (int j = 0; j < physicalNumberOfCells; j++) {
				String tittle = tittleRow.getCell(j).toString();
				tittle = "set" + tittle.substring(0, 1).toUpperCase() + tittle.substring(1);
				valueList.add(tittle);
			}
			log.info(valueList);
			for (int j = 1; j < physicalNumberOfRows; j++) {
				row = sheet.getRow(j);
				physicalNumberOfCells = row.getPhysicalNumberOfCells();
				T t = clazz.newInstance();
				for (int k = 0; k < physicalNumberOfCells; k++) {
					// cell.setCellType(CellType.STRING);
					cell = row.getCell(k);
					String cellValue = getCellValueByCell(cell);
					t.getClass().getMethod(valueList.get(k), new Class[] { String.class }).invoke(t,
							new Object[] { cellValue });
				}
				res.add(t);
			}
		}
		workbook.close();
		return res;
	}

	public static String getCellValueByCell(XSSFCell cell) {
		NumberFormat nf = NumberFormat.getInstance();
		if (cell == null || cell.toString().trim().equals(""))
			return "";
		String cellValue = "";
		CellType cellType = cell.getCellType();
		if (cellType == CellType.FORMULA) {
			cellType = evaluator.evaluate(cell).getCellType();
		}
		if (cellType == CellType.STRING) {
			cellValue = cell.getStringCellValue().trim();
			cellValue = StringUtils.isEmpty(cellValue) ? "" : cellValue;
			return cellValue;
		}
		if (cellType == CellType.NUMERIC) {
			cellValue = String.valueOf(nf.format(cell.getNumericCellValue()));
			// 去除NumberFormat生成的,符号
			cellValue = cellValue.replace(",", "");
			cellValue = StringUtils.isEmpty(cellValue) ? "" : cellValue;
			return cellValue;
		}
		return cellValue;
	}
}
