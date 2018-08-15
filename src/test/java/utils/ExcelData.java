package utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
public class ExcelData {

		private static XSSFSheet ExcelWSheet;
		private static XSSFWorkbook ExcelWBook;
		private static XSSFCell Cell;
		private static XSSFRow Row;
		private static MissingCellPolicy xRow;
		//Setting the excel file path and name to access
		public static void setExcelFile(String Path,String SheetName) throws Exception {
			try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			} catch (Exception e){
				throw (e);
			}
		}
		//Perform write operation to the Excel file
		public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{
			try{
				Row = ExcelWSheet.getRow(RowNum);
				Cell = Row.getCell(ColNum, xRow.RETURN_BLANK_AS_NULL);
				if(Cell == null) {
					Cell = Row.createCell(ColNum);
					Cell.setCellValue(Result);
				}
				else {
					Cell.setCellValue(Result);
				}
				FileOutputStream fileOut = new FileOutputStream(Constants.excelPath+Constants.excelName);
  				ExcelWBook.write(fileOut);
  				fileOut.flush();
				fileOut.close();
				}
			catch(Exception e){
					throw (e);
			}
		}
}
