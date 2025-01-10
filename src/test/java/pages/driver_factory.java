
package pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;

public class driver_factory {
    public static WebDriver driver =null; // new added

    public static String getcell_value(int row_no, int cell_no) throws IOException {
        FileInputStream fs = new FileInputStream("utility/test.xlsx");
        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String value= String.valueOf(sheet.getRow(row_no).getCell(cell_no));
        return value;
    }
    public static WebDriver getdriver() throws IOException { // made static
        String browser = getcell_value(1, 0); // removed this
        //WebDriver driver=null;
        //driver_factory=new ChromeDriver();
        //return driver_factory;
        switch (browser) {
            case "chrome":
                // Set ChromeOptions for headless mode
                /*WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=old");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--disable-gpu");
                driver = new ChromeDriver(chromeOptions);*/
                driver=new ChromeDriver();
                break;

            case "firefox":
                // Set FirefoxOptions for headless mode
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless=old");
                driver = new FirefoxDriver(firefoxOptions);
                //driver=new FirefoxDriver();
                break;
        }
        return driver;
    }

}


 /*   public String getcell(int row_no, int cell_no) throws IOException {
        FileInputStream fs = new FileInputStream("C:\\Users\\SusmitSurwade\\Documents\\selenium\\test.xlsx");
        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String value= String.valueOf(sheet.getRow(row_no).getCell(cell_no));
        return value;
    }*/

