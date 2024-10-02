package pages;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.antlr.ast.Str;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class basepage {
    WebDriver driver;

    public basepage(WebDriver driver) { // basepage constructor
        this.driver = driver;
    }

    // common sendkeys method
    public void sendKeys(String text,String xp)
    {
        driver.findElement(By.xpath(xp)).sendKeys(text);
    }

    // Common Click method
    public void click(String xp)
    {
        driver.findElement(By.xpath(xp)).click();
    }

    // common explicit wait
    public static void explicitWait(WebDriver driver, String xpath, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Timed out waiting for element with XPath: " + xpath);
        }
    }

    // Takes screenshots
    public String screenShot() throws IOException, InterruptedException, IOException {
        File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest= new File("C:\\Users\\SusmitSurwade\\IdeaProjects\\Orange_hrms\\test-output\\Screenshots/screenshot_"+timestamp()+".png");
        FileUtils.copyFile(scr, dest);
        String fail="Test case fail";
        return fail;
        //driver: This is assumed to be an instance of the Selenium WebDriver.
        //((TakesScreenshot) driver): It is casting the WebDriver instance to TakesScreenshot. The TakesScreenshot interface is implemented by WebDriver classes that support taking screenshots.
        //.getScreenshotAs(OutputType.FILE): This method captures a screenshot of the current state of the WebDriver instance and returns it as a FILE type. The screenshot is stored in the File object referenced by the variable scr.
        // dest is new file created on the given path in which timestamp fumction is used to get current date and time file name
    }

    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public String getcell(int row_no, int cell_no) throws IOException {
        FileInputStream fs = new FileInputStream("C:\\Users\\SusmitSurwade\\Documents\\selenium\\test.xlsx");
        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String value= String.valueOf(sheet.getRow(row_no).getCell(cell_no));
        return value;
    }

    public void explicit_wait(String xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void dropdown_list(String xpath_element,String xpath_value)
    {
        driver.findElement(By.xpath(xpath_element)).click();
        driver.findElement(By.xpath(xpath_value)).click();
    }

}

