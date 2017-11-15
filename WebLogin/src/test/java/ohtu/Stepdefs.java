package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Stepdefs {

    WebDriver driver = new ChromeDriver();
    String baseUrl = "http://localhost:4567";

    @Given("^login is selected$")
    public void login_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
    }

    @Given("^new user is selected$")
    public void new_user_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }

    @Given("^user with username \"([^\"]*)\" with password \"([^\"]*)\" is succesfully created$")
    public void new_user_created(String username, String password) throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        createUser(username, password);
        element.findElement(By.linkText("continue to application mainpage"));
        element.click();
        element.findElement(By.linkText("logout"));
        element.click();
    }

    @Given("^user with username \"([^\"]*)\" and password \"([^\"]*)\" is tried to be created$")
    public void invalid_username_invalid_password(String username, String password) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        createUser(username, password);
        element = driver.findElement(By.linkText("back to home"));
        element.click();
    }

    @When("^valid username \"([^\"]*)\" and password \"([^\"]*)\" and matching password confirmation are entered$")
    public void new_user_correct_name_password_and_confirmation(String username, String password) throws Throwable {
        createUser(username, password);
    }

    @When("^an invalid username \"([^\"]*)\" and password \"([^\"]*)\" are entered$")
    public void invalid_username_correct_password(String username, String password) throws Throwable {
        createUser(username, password);
    }

    @When("^a valid username \"([^\"]*)\" and invalid password  \"([^\"]*)\" are entered$")
    public void valid_username_invalid_password(String username, String password) throws Throwable {
        createUser(username, password);
    }

    @When("^a username in use \"([^\"]*)\" and password \"([^\"]*)\" are entered$")
    public void username_in_use(String username, String password) throws Throwable {
        createUser(username, password);
    }

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" and password confirmation \"([^\"]*)\" are entered$")
    public void password_and_confirmation_password_different(String username, String password, String confirmation) throws Throwable {
        createUser(username, password, confirmation);
    }

    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" are given")
    public void username_correct_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^correct username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given")
    public void username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^incorrect username \"([^\"]*)\" and password \"([^\"]*)\" are given")
    public void incorrect_username_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        pageHasContent("Ohtu Application main page");
    }

    @Then("^user is not logged in and error message is given$")
    public void user_is_not_logged_in_and_error_message_is_given() throws Throwable {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @Then("^a new user is created$")
    public void new_user_is_created() throws Throwable {
        pageHasContent("Welcome to Ohtu Application!");
    }

    @Then("^user is not created and error \"username should have at least 3 characters\" is reported$")
    public void error_message_username_too_short() throws Throwable {
        pageHasContent("username should have at least 3 characters");
    }

    @Then("^user is not created and error \"password should have at least 8 characters\" is reported$")
    public void error_message_password_too_short() throws Throwable {
        pageHasContent("password should have at least 8 characters");
    }

    @Then("^user is not created and error \"username is already taken\" is reported$")
    public void error_message_user_taken() throws Throwable {
        pageHasContent("username is already taken");
    }

    @Then("^user is not created and error \"password and password confirmation do not match\" is reported$")
    public void error_message_passwords_dont_match() throws Throwable {
        pageHasContent("password and password confirmation do not match");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /* helper methods */
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    private void createUser(String username, String password) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }

    private void createUser(String username, String password, String confirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(confirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }
}
