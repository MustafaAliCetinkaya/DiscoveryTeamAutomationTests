package tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.cydeoPages.VyTrackDashboardPage;
import pages.cydeoPages.VyTrackLoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackDDTTest {
    VyTrackLoginPage vyTrackLoginPage = new VyTrackLoginPage();
    VyTrackDashboardPage vyTrackDashboardPage = new VyTrackDashboardPage();

    @Test
    public void loginDDTTest() throws IOException {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack"));
        String path = "VyTrackQa2Users.xlsx";

        File file = new File(path);

        //To read excel, we need to load it to FileInputStream
        FileInputStream fileInputStream = new FileInputStream(file);

        //Create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //We need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("data");

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            String userName = sheet.getRow(i).getCell(0).toString();
            String password = sheet.getRow(i).getCell(1).toString();
            String firstName = sheet.getRow(i).getCell(2).toString();
            String lastName = sheet.getRow(i).getCell(3).toString();

            vyTrackLoginPage.login(userName, password);

            WebElement loaderMask=Driver.getDriver().findElement(By.cssSelector("div.loader-mask"));

            String actualFullName = vyTrackDashboardPage.usernameDropdown.getText();
            String expectedFullName = firstName + " " + lastName;

            XSSFCell resultCell = sheet.getRow(i).getCell(4);
            if (actualFullName.equals(expectedFullName)) {
                resultCell.setCellValue("PASSES");
            } else {
                resultCell.setCellValue("FAILED");
            }

            vyTrackDashboardPage.logout();
        }

        //Save the changes, otherwise it will break the file and not write
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();

        Driver.closeDriver();
    }
}
