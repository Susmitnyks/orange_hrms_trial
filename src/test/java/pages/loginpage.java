package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class loginpage extends basepage{

    public loginpage(WebDriver driver) {
        super(driver);  //calls constructor of super class.
    }

    String drop_down="//*[@class=\"oxd-userdropdown-img\"]";
    String log_out="//a[@class='oxd-userdropdown-link' and text()='Logout']";
    String hrm_url="https://opensource-demo.orangehrmlive.com";
    String username="//input[@name='username']";
    String password="//input[@name='password']";
    String submit="//button[text()=' Login ']";
    String dashboard="//*[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]";

    public WebDriver get_driver()
    {
        return driver;
    }
    public void launch()
    {
        driver.manage().window().maximize();
        driver.get(hrm_url);
    }

   public void usr_pass()
    {
        explicitWait(driver,username, Duration.ofSeconds(10));
        sendKeys("Admin",username);
        sendKeys("admin123",password);
    }

    public void usr_pass_outline(String user_name,String pass_word)
    {
        explicitWait(driver,username, Duration.ofSeconds(10));
        sendKeys(user_name,username);
        sendKeys(pass_word,password);
    }

    public void submit_btn()
    {
        click(submit);
    }

    public void verifyHomepage_login() throws InterruptedException, IOException {
        explicitWait(driver,dashboard,Duration.ofSeconds(4));
        String db=driver.findElement(By.xpath(dashboard)).getText();
        Assert.assertEquals(screenShot(),"Dashboard",db);
        //driver.quit();
    }
    public void log_out()
    {
        explicitWait(driver,drop_down, Duration.ofSeconds(10));
        driver.findElement(By.xpath(drop_down)).click();
        driver.findElement(By.xpath(log_out)).click();
        driver.quit();
    }
    public void verify_homepage_logout()
    {
        String exp="OrangeHRM";
        String title=driver.getTitle();
        Assert.assertEquals("Test case fails",exp,title);
        driver.quit();
    }


}
