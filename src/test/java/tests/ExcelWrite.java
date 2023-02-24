package tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import utilities.BrowserUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {
    String path = "SampleData.xlsx";
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    @Test
    public void excelWrite() throws IOException {
        File file = new File(path);

        //To read excel, we need to load it to FileInputStream
        FileInputStream fileInputStream = new FileInputStream(file);

        //Create a workbook
        workbook = new XSSFWorkbook(fileInputStream);

        //We need to get specific sheet from currently opened workbook
        sheet = workbook.getSheet("Employees");

        //Above written codes are same for reading and writing

        //Define a cell (column)  for writing data
        XSSFCell salaryCell=sheet.getRow(0).createCell(3);
        salaryCell.setCellValue("Salary");

        //Write each staff's salary
        for (int i = 1; i < 8; i++) {
            XSSFCell staffSalary=sheet.getRow(i).createCell(3);
            staffSalary.setCellValue(80000*i);
        }

        //Add new data by using faker
        for (int j = 8; j < 13; j++) {
            XSSFCell newStaffName=sheet.createRow(j).createCell(0);//create both row and column
            newStaffName.setCellValue(BrowserUtilities.getFaker().name().firstName());

            XSSFCell newStaffSurname=sheet.getRow(j).createCell(1);//row is already created, only the column will be created.
            newStaffSurname.setCellValue(BrowserUtilities.getFaker().name().lastName());
        }

        //Change a value (surname of Ekrem)
        for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Ekrem")){
                sheet.getRow(rowNum).getCell(1).setCellValue("Andy");
            }
        }

        //Save the changes, otherwise it will break the file and not write
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();
    }

}
