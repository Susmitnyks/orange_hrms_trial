package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.basepage;
import pages.driver_factory;
import pages.loginpage;
import pages.myinfopage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MyStepdefs extends driver_factory {

    WebDriver driver=driver_factory.getdriver(); // add classname
    loginpage lp = new loginpage(driver);
    myinfopage info = new myinfopage(driver);

    public MyStepdefs() throws IOException {
    }


    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        lp.launch();
    }

    @When("User enters username and password")
    public void userEntersUsernameAndPassword() throws IOException {
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
    }

    @When("User clicks on the profile picture and clicks on + icon and Upload profile picture")
    public void userClicksOnTheProfilePictureAndClicksOnIconAndUploadProfilePicture() throws InterruptedException, IOException {
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
    public void profilePictureUploadedShouldGetSaveAndShowOnApplication() throws InterruptedException {
        //System.out.println("success");
        info.verify_success_msg();
    }


    @Then("User details should be saved succesfully")
    public void userDetailsShouldBeSavedSuccesfully() throws InterruptedException {
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

    @Then("verify logged username")
    public void verifyLoggedUsername() {
        info.get_username();
    }

    @Given("User is on the test login page")
    public void userIsOnTheTestLoginPage() {
        System.out.println("background given");
    }

    @When("User enters username and pincode.")
    public void userEntersUsernameAndPincode(DataTable usercredentials) {
        System.out.println("background when");
        List<List<String>> data = usercredentials.asLists();
        System.out.println(data.get(0).get(0));
        System.out.println(data.get(0).get(1));
    }

    @And("user click on submit button.")
    public void userClickOnSubmitButton() {
        System.out.println("background and");
    }

    @Then("User will land on homepage.")
    public void userWillLandOnHomepage() {
        System.out.println("background then");
    }

    @Given("user on home page")
    public void userOnHomePage() {
        System.out.println("scenario one given");
    }

    @When("user click on product one")
    public void userClickOnProductOne() {
        System.out.println("scenario one when");
    }

    @And("user click on add to cart")
    public void userClickOnAddToCart() {
        System.out.println("scenario one and");
    }

    @Then("product one is added")
    public void productOneIsAdded() {
        System.out.println("scenario one then");
    }

    @When("user click on product two")
    public void userClickOnProductTwo() {
        System.out.println("scenario two when");
    }

    @Then("product two is added")
    public void productTwoIsAdded() {
        System.out.println("scenario two then");
    }

    @Before
    public void setUp()
    {
        System.out.println("this is hook before");
    }
    @After
    public void tearDown()
    {
        System.out.println("this is hook after");
    }
}
