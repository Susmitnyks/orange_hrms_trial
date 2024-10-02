package pages;

import org.junit.Assert;
import org.openqa.selenium.*;


import java.io.IOException;
import java.time.Duration;

public class myinfopage extends basepage{
 public myinfopage(WebDriver driver) throws IOException {
     super(driver); // calls constructor of super class.

  }
    String fname_field="//input[@class='oxd-input oxd-input--focus oxd-input--error orangehrm-firstname']";
    String fname_focus="//input[@class='oxd-input oxd-input--focus orangehrm-firstname']";
    String fname="//input[@class='oxd-input oxd-input--active orangehrm-firstname']";
    String lname="//input[@class='oxd-input oxd-input--active orangehrm-lastname']";
    String lname_focus="//input[@class='oxd-input oxd-input--focus orangehrm-lastname']";
    String lname_field="//input[@class='oxd-input oxd-input--focus oxd-input--error orangehrm-lastname']";
    String fname_value=getcell(1,1);
    String lname_value=getcell(1,2);
    String succes_msg="//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']";

    String Prof_img="//img[@alt='profile picture' and @class='employee-image']";
    String plus_button="//button[@class='oxd-icon-button oxd-icon-button--solid-main employee-image-action']";
    String save_btn="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']";
    String country=getcell(1,3);
    String country_xpath="//div[@class='oxd-select-option' and span[text()='"+country+"']]";
    String birthdate_field="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[1]/div/div[2]/div/div/input";
    String DOB=getcell(1,4);
    String myinfo_menu="//*[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\" and text()='My Info']";

    String nationality_drp="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[2]/i";



    public void myinfo_click() throws InterruptedException {
        implicit_wait();
        driver.findElement(By.xpath(myinfo_menu)).click();
    }

    public void upload_pic() throws InterruptedException, IOException {
        implicit_wait();
        driver.findElement(By.xpath(Prof_img)).click();
        implicit_wait();
        WebElement addfile= driver.findElement(By.xpath(plus_button));
        addfile.click();
        Runtime.getRuntime().exec("C:\\Users\\SusmitSurwade\\Documents\\file.exe");
        Thread.sleep(4000);
        driver.findElement(By.xpath(save_btn)).click();
    }

    public void update_details() throws IOException, InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath(fname)).click();
        driver.findElement(By.xpath(fname_focus)).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(By.xpath(fname_field)).sendKeys(fname_value);
        driver.findElement(By.xpath(lname)).click();
        driver.findElement(By.xpath(lname_focus)).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        //implicit_wait();
        driver.findElement(By.xpath(lname_field)).sendKeys(lname_value);
    }

    public void verify_success_msg() throws InterruptedException {

        explicitWait(driver,succes_msg, Duration.ofSeconds(10));
        WebElement msg=driver.findElement(By.xpath(succes_msg));
        Assert.assertTrue(msg.isDisplayed());
    }

    public void birth_date() throws InterruptedException, IOException {
        implicit_wait();
        driver.findElement(By.xpath(birthdate_field)).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(By.xpath(birthdate_field)).sendKeys(DOB);
    }

    public void nation() throws InterruptedException, IOException {
        implicit_wait();
        dropdown_list(nationality_drp,country_xpath);
        driver.findElement(By.xpath(save_btn)).click();
    }

}
