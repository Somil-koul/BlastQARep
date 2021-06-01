package com.disney.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

@SuppressWarnings("deprecation")
public class Excel {
	private static XSSFSheet xlsxWorkSheet;
	private static XSSFWorkbook xlsxWorkBook;
	private static XSSFCell xlsxCell;
	@SuppressWarnings("unused")
	private static XSSFRow xlsxRow;

	private static HSSFSheet xlsWorkSheet;
	private static HSSFWorkbook xlsWorkBook;
	private static HSSFCell xlsCell;
	@SuppressWarnings("unused")
	private static HSSFRow xlsRow;

	private static FileInputStream fileInputStream;
	private static XSSFWorkbook workbookTestData;
	private static XSSFSheet worksheetTestData;
	private static XSSFSheet worksheetOutputData;
	private static XSSFRow rowHeader;
	private static XSSFRow rowCurrent;
	private static Integer intCurrentRow;
	private static Integer intTotalRows;
	private static Integer intTotalColumns;
	private static LinkedHashMap<String, String> testData;

	/**
	 * Method to set fetch input data for each test cases id
	 * 
	 * @param TestCaseId {@String} TestCaseId
	 */
	@DataProvider(name = "multiSheetExcelRead")
	public static Object[][] multiSheetExcelRead(Method method) throws Exception {
		File file = new File(
				System.getProperty("user.dir") + "/src/main/resources/Test Data/Excel Files/TestData.xlsx");
		String SheetName = method.getName();
		System.out.println(SheetName);
		Object testObjArray[][] = Excel.getTableArray(file.getAbsolutePath(), SheetName);
		return testObjArray;
	}

	/** Method to Load Single Sheet */
	@DataProvider(name = "excelSheetNameAsMethodName")
	public static Object[][] excelSheetNameAsMethodName(Method method) throws Exception {
		File file = new File("System.getProperty(\"user.dir\") + \"/src/main/resources/Test Data/Excel Files/"
				+ method.getName() + ".xls");
		System.out.println("Opening Excel File:" + file.getAbsolutePath());
		Object testObjArray[][] = Excel.getTableArray(file.getAbsolutePath());
		return testObjArray;
	}

	/** Method to Load Data from Sheet Row Wise */
	public static synchronized LinkedHashMap<String, String> getTestData(String TestCaseId, String sheetname) {
		try {
			String currentDir = System.getProperty("user.dir");
			fileInputStream = new FileInputStream(currentDir + File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "TestData" + File.separator + "Excel Files"
					+ File.separator + "TestData.xlsx");
			workbookTestData = new XSSFWorkbook(fileInputStream);
			worksheetTestData = workbookTestData.getSheet(sheetname);
			testData = new LinkedHashMap<String, String>();

			intTotalRows = worksheetTestData.getLastRowNum();

			for (int intRow = 1; intRow < intTotalRows; intRow++) {
				rowCurrent = worksheetTestData.getRow(intRow);
				if (rowCurrent.getCell(0).getStringCellValue().equalsIgnoreCase(TestCaseId)) {
					intCurrentRow = intRow;
					rowHeader = worksheetTestData.getRow(intCurrentRow - 1);
					intTotalColumns = worksheetTestData.getRow(intRow).getPhysicalNumberOfCells();
					break;
				}
			}

			rowCurrent = worksheetTestData.getRow(intCurrentRow);
			for (int intCol = 0; intCol < intTotalColumns; intCol++) {
				Cell cell = rowCurrent.getCell(intCol);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				String value = cell.getStringCellValue();
				if (value.equalsIgnoreCase("END"))
					break;
				else
					testData.put(rowHeader.getCell(intCol).getStringCellValue(), value);
				    //testData.put(rowHeader.getCell(intCol).getStringCellValue().toString(), value);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			workbookTestData.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testData;

	}

	/**
	 * Method to to get Test Case Id
	 */
	public static String getTestCaseId(String strClassName) {
		String[] strParts = strClassName.split("_");
		return strParts[1];
	}

	public static void updateTestData(String cellName, String ValueToUpdate) throws InvalidFormatException {
		String currentDir = System.getProperty("user.dir");
		String excelFilePath = currentDir + File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "TestData" + File.separator + "Excel Files" + File.separator
				+ "TestData.xlsx";

		try {
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = WorkbookFactory.create(inputStream);

			Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator(); // Traversing over each row of XLSX file
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next(); // For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.toString().contentEquals(cellName)) {
						sheet.getRow(cell.getRowIndex() + 1).getCell(cell.getColumnIndex()).setCellValue(ValueToUpdate);
					}
				}
			}

			inputStream.close();

			FileOutputStream outputStream = new FileOutputStream(currentDir + File.separator + "src" + File.separator
					+ "test" + File.separator + "resources" + File.separator + "TestData" + File.separator
					+ "Excel Files" + File.separator + "TestData.xlsx");
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();

		} catch (IOException | EncryptedDocumentException ex) {
			ex.printStackTrace();
		}
	}

	/** To get the Excel-XLSX File with Path and SheetName */
	public static void getExcelFile(String Path, String SheetName) throws Exception {
		try {
			File file = new File(Path);
			if (file.getAbsolutePath().endsWith(".xlsx")) {
				FileInputStream fis = new FileInputStream(file);
				xlsxWorkBook = new XSSFWorkbook(fis);
				xlsxWorkSheet = xlsxWorkBook.getSheet(SheetName);
			} else if (file.getAbsolutePath().endsWith(".xls")) {
				FileInputStream fis = new FileInputStream(file);
				xlsWorkBook = new HSSFWorkbook(fis);
				xlsWorkSheet = xlsWorkBook.getSheet(SheetName);
			}
		} catch (Exception e) {
			throw (e);
		}
	}

	/** To Return the Excel-XLSX Values given Path to the File and Sheet Name */
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {
		Object[][] tabArray = null;
		try {
			File file = new File(FilePath);
			if (file.getAbsolutePath().endsWith(".xlsx")) {
				FileInputStream ExcelFile = new FileInputStream(file);
				xlsxWorkBook = new XSSFWorkbook(ExcelFile);
				xlsxWorkSheet = xlsxWorkBook.getSheet(SheetName);

				int startRow = 1;
				int startCol = 0;
				int ci, cj;
				int totalRows = Excel.xlsxRowCount();
				int totalCols = Excel.xlsxColumnCount();
				tabArray = new Object[totalRows - 1][totalCols];
				ci = 0;
				for (int i = startRow; i < totalRows; i++) {
					cj = 0;
					for (int j = startCol; j < totalCols; j++) {
						tabArray[ci][cj] = getCellData_XLSX(i, j);
						cj++;
					}
					ci++;
				}
			} else if (file.getAbsolutePath().endsWith(".xls")) {
				FileInputStream ExcelFile = new FileInputStream(file);
				xlsWorkBook = new HSSFWorkbook(ExcelFile);
				xlsWorkSheet = xlsWorkBook.getSheet(SheetName);

				int startRow = 1;
				int startCol = 0;
				int ci, cj;
				int totalRows = Excel.xlsRowCount();
				int totalCols = Excel.xlsColumnCount();
				tabArray = new Object[totalRows - 1][totalCols];
				ci = 0;
				for (int i = startRow; i < totalRows; i++) {
					cj = 0;
					for (int j = startCol; j < totalCols; j++) {
						tabArray[ci][cj] = getCellData_XLS(i, j);
						cj++;
					}
					ci++;
				}
			}
		} catch (FileNotFoundException e) {
			throw new Exception("Could not Find the Excel File/Sheet");
		} catch (Exception e) {
			throw new Exception("Could not Open the Excel File");
		}
		return (tabArray);
	}

	/** To Return the Excel-XLSX Values given Path to the File */
	public static Object[][] getTableArray(String FilePath) throws Exception {
		Object[][] tabArray = null;
		try {
			File file = new File(FilePath);
			if (file.getAbsolutePath().endsWith(".xlsx")) {
				FileInputStream ExcelFile = new FileInputStream(file);
				xlsxWorkBook = new XSSFWorkbook(ExcelFile);
				xlsxWorkSheet = xlsxWorkBook.getSheetAt(0);

				int startRow = 1;
				int startCol = 0;
				int ci, cj;
				int totalRows = Excel.xlsxRowCount();
				int totalCols = Excel.xlsxColumnCount();
				tabArray = new Object[totalRows - 1][totalCols];
				ci = 0;
				for (int i = startRow; i < totalRows; i++) {
					cj = 0;
					for (int j = startCol; j < totalCols; j++) {
						tabArray[ci][cj] = getCellData_XLSX(i, j);
						cj++;
					}
					ci++;
				}
			} else if (file.getAbsolutePath().endsWith(".xls")) {
				FileInputStream ExcelFile = new FileInputStream(file);
				xlsWorkBook = new HSSFWorkbook(ExcelFile);
				xlsWorkSheet = xlsWorkBook.getSheetAt(0);

				int startRow = 1;
				int startCol = 0;
				int ci, cj;
				int totalRows = Excel.xlsRowCount();
				int totalCols = Excel.xlsColumnCount();
				tabArray = new Object[totalRows - 1][totalCols];
				ci = 0;
				for (int i = startRow; i < totalRows; i++) {
					cj = 0;
					for (int j = startCol; j < totalCols; j++) {
						tabArray[ci][cj] = getCellData_XLS(i, j);
						cj++;
					}
					ci++;
				}
			}
		} catch (FileNotFoundException e) {
			throw new Exception("Could not Find the Excel File/Sheet");
		} catch (Exception e) {
			throw new Exception("Could not Open the Excel File");
		}
		return (tabArray);
	}

	/** To get cell data from Excel-XLSX */
	public static Object getCellData_XLSX(int RowNum, int ColNum) throws Exception {
		Object CellData = null;
		try {
			xlsxCell = xlsxWorkSheet.getRow(RowNum).getCell(ColNum);
			if (xlsxCell.getCellType() == Cell.CELL_TYPE_STRING) {
				String stringCellData = xlsxCell.getStringCellValue();
				CellData = stringCellData;
			}

			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	/** To get cell data from Excel-XLS */
	public static Object getCellData_XLS(int RowNum, int ColNum) throws Exception {
		Object CellData = null;
		try {
			xlsCell = xlsWorkSheet.getRow(RowNum).getCell(ColNum);
			if (xlsCell.getCellType() == Cell.CELL_TYPE_STRING) {
				String stringCellData = xlsCell.getStringCellValue();
				CellData = stringCellData;
			}
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	/** To get Excel-XLSX Row Count */
	public static int xlsxRowCount() {
		int rowNum = xlsxWorkSheet.getLastRowNum() + 1;
		return rowNum;
	}

	/** To get Excel-XLS Row Count */
	public static int xlsRowCount() {
		int rowNum = xlsWorkSheet.getLastRowNum() + 1;
		return rowNum;
	}

	/** To get Excel-XLSX Column Count */
	public static int xlsxColumnCount() {
		int rowNum = xlsxWorkSheet.getRow(0).getLastCellNum();
		return rowNum;
	}

	/** To get Excel-XLS Column Count */
	public static int xlsColumnCount() {
		int rowNum = xlsWorkSheet.getRow(0).getLastCellNum();
		return rowNum;
	}
}