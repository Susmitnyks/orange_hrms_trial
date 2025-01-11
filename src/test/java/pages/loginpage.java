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
    String log_out="//*[@id=\"navbar-logout\"]/a/span";
    String hrm_url="https://testsusmit-trials714.orangehrmlive.com";
    String username="//*[@id=\"txtUsername\"]";
    String password="//*[@id=\"txtPassword\"]";
    String submit="//*[@id=\"frmLogin\"]/div[4]/button";
    String dashboard="//*[@id=\"topbar\"]/ul[1]/li[2]/div";


    public void launch()
    {
        driver.manage().window().maximize();
        driver.get(hrm_url);
    }

   public void usr_pass() throws IOException {
        explicitWait(driver,username, Duration.ofSeconds(15));
        sendKeys(getcell(1,5),username);
        sendKeys(getcell(1,6),password);
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
        System.out.println("success now here updated today now");
        System.out.println("success now here updated today now on susmit test");
    }

    public void verifyHomepage_login() throws InterruptedException, IOException {
        explicitWait(driver,dashboard,Duration.ofSeconds(4));
        String db=driver.findElement(By.xpath(dashboard)).getText();
        Assert.assertEquals(screenShot(),"Employee Management",db);
        //driver.quit();
        //driver.close();
    }
    public void log_out()
    {
        explicitWait(driver,drop_down, Duration.ofSeconds(10));
        //driver.findElement(By.xpath(drop_down)).click();
        driver.findElement(By.xpath(log_out)).click();
    }
    public void verify_homepage_logout()
    {
        String exp="OrangeHRM";
        String title=driver.getTitle();
        Assert.assertEquals("Test case fails",exp,title);
        driver.quit();
        //driver.close();
    }


}
