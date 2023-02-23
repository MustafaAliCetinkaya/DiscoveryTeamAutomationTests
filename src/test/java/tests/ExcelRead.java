package tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*In Apache POI column==Cell
* workbook > sheet > row > cell*/
public class ExcelRead {
    @Test
    public void readFromExcelFile() throws IOException {
        String path = "SampleData.xlsx";

        File file=new File(path);

        //To read excel, we need to load it to FileInputStream
        FileInputStream fileInputStream=new FileInputStream(file);

        //Create a workbook
        XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);

        //We need to get specific sheet from currently opened workbook
        XSSFSheet sheet=workbook.getSheet("Employees");

        //Write all first names
        for (int i = 0; i < 8; i++) {
            System.out.println(sheet.getRow(i).getCell(0));
            System.out.println("--------------------");

        }

        for (int i = 0; i < 3; i++) {
            System.out.print(sheet.getRow(1).getCell(i)+" ");
        }

        //Count of used cells, starts counting from 1, do not count the empty ones
        int usedRows=sheet.getPhysicalNumberOfRows();
        System.out.println("usedRows = " + usedRows);

        //Starts counting from 0,counts the empty ones, eligible for loop usage
        int lastUsedRow=sheet.getLastRowNum();
        System.out.println("lastUsedRow = " + lastUsedRow);

        //Smart logic for finding specific name
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Bünyamin")){
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }
        }

        //Smart logic for finding someone's job_ID
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Merve")){
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }
        }


    }
}
