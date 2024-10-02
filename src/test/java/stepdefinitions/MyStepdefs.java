package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import pages.loginpage;
import pages.myinfopage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyStepdefs {
    WebDriver driver = new ChromeDriver();
    loginpage lp = new loginpage(driver);
    myinfopage info = new myinfopage(driver);

    public MyStepdefs() throws IOException {
    }

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        lp.launch();
    }

    @When("User enters username and password")
    public void userEntersUsernameAndPassword() {
        lp.usr_pass();
    }

    @And("User clicks on the submit button")
    public void userClicksOnTheSubmitButton() {
        lp.submit_btn();
    }

    @Then("User is navigated to home page")
    public void userIsNavigatedToHomePage() throws InterruptedException, IOException {
        lp.verifyHomepage_login();
    }

    @Given("User is logged in into application")
    public void userIsLoggedInIntoApplication() throws InterruptedException, IOException {
        lp.launch();
        lp.usr_pass();
        lp.submit_btn();
        lp.verifyHomepage_login();
    }

    @When("User clicks on logout button")
    public void userUserClicksOnLogoutButton() {
        lp.log_out();
    }

    @Then("User is navigated back to login screen")
    public void userIsNavigatedBackToLoginScreen() {
        lp.verify_homepage_logout();
    }

    @Given("User is on the My info page")
    public void userIsOnTheMyInfoPage() throws InterruptedException, IOException {
        lp.launch();
        lp.usr_pass();
        lp.submit_btn();
        info.myinfo_click();
        //System.out.println(lp.getcell(1,1));
    }

    @When("User clicks on the profile picture and clicks on + icon and Upload profile picture")
    public void userClicksOnTheProfilePictureAndClicksOnIconAndUploadProfilePicture() throws InterruptedException, FindFailed, IOException {
     info.upload_pic();
    }


    @When("User will enters {string} and {string}")
    public void userWillEntersAnd(String username, String password) {
     lp.usr_pass_outline(username,password);
    }

    @Then("User lands on the homepage")
    public void userLandsOnTheHomepage() throws IOException, InterruptedException {
        lp.verifyHomepage_login();
    }

    @And("User do logout")
    public void userDoLogout() {
        lp.log_out();
    }

    @Then("Profile picture uploaded should get save and show on application")
    public void profilePictureUploadedShouldGetSaveAndShowOnApplication() {
        System.out.println("success");
    }


    @Then("User details should be saved succesfully")
    public void userDetailsShouldBeSavedSuccesfully() {
        info.verify_success_msg();

    }


    @And("User update his birthdate")
    public void userUpdateHisBirthdate() throws InterruptedException, IOException {
        info.birth_date();

    }


    @When("User enter Fname and Lname")
    public void userEnterFnameAndLname() throws IOException, InterruptedException {
        info.update_details();
    }

    @And("User selects his nationality and click on save button")
    public void userSelectsHisNationalityAndClickOnSaveButton() throws IOException, InterruptedException {
        info.nation();
    }
}
