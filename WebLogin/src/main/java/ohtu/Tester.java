package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class Tester {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/keolli/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        ChromeDriverManager.getInstance().setup();

        sleep(2);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        vaaraSalasana(driver);
        eiOlemassaOlevaKayttaja(driver);
        uusiKayttajatunnus(driver);
        uusiKayttajatunnusUlos(driver);

        driver.quit();
    }

    private static void vaaraSalasana(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");

        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("login"));

        sleep(3);

        element.submit();
    }

    private static void eiOlemassaOlevaKayttaja(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("akkep");

        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("login"));

        sleep(3);

        element.submit();

    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }

    private static void uusiKayttajatunnus(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");

        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");

        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("pekka");

        element = driver.findElement(By.name("signup"));

        sleep(3);

        element.submit();
    }

    private static void uusiKayttajatunnusUlos(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();
    }
}
