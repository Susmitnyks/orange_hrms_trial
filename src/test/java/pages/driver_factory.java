package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
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
    public static WebDriver driver = null;


    public static String getcell_value(int row_no, int cell_no) throws IOException {
        FileInputStream fs = new FileInputStream("utility/test.xlsx");
        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String value = String.valueOf(sheet.getRow(row_no).getCell(cell_no));
        return value;
    }

    public static WebDriver getdriver() throws IOException {
        Dotenv dotenv = Dotenv.load();
        String browser = getcell_value(1, 0); // Get the browser value from Excel
        String headlessMode = dotenv.get("HEADLESS_MODE");  // Access GitHub secret as environment variable

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();

                if (headlessMode != null && headlessMode.equals("true")) {
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("--disable-gpu");
                }

                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless=old");
                driver = new FirefoxDriver(firefoxOptions);
                break;
        }
        return driver;
    }
}
