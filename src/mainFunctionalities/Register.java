package mainFunctionalities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {

    public static void main(String[] args) throws InterruptedException {
    	WebDriver driver = new ChromeDriver();
    	//WebDriver driver = new FirefoxDriver();
        driver.get("https://bookcart.azurewebsites.net/");
        Actions act = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//mat-toolbar/mat-toolbar-row/div[3]/button[2]")).click();
        driver.findElement(By.xpath("//app-login/div/div[1]/div/div/button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Register reg = new Register();

        reg.waiting(driver, wait);

        WebElement element1 = driver.findElement(By.xpath("//form/mat-form-field[1]/div/div[1]"));
        WebElement element2 = driver.findElement(By.xpath("//form/mat-form-field[2]/div/div[1]"));
        WebElement element3 = driver.findElement(By.xpath("//form/mat-form-field[3]"));
        WebElement element4 = driver.findElement(By.xpath("//form/mat-form-field[4]"));
        WebElement element5 = driver.findElement(By.xpath("//form/mat-form-field[5]"));

        reg.sendKeysE1(act, element1, "Groupf1");
        reg.sendKeysE2(act, element2, "Groupl2");
        reg.sendKeysE3(act, element3, "group123");
        reg.sendKeysE4(act, element4, "Group@123");
        reg.sendKeysE5(act, element5, "Group@123");

        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        WebElement ele2 = driver.findElement(By.xpath("//mat-radio-button[1]/label/span[1]/span[1]"));
        reg.btnclick(driver, executor2, ele2);
    }

    public void waiting(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/mat-form-field[1]")));
    }

    public void sendKeysE1(Actions act, WebElement element, String value) {
        act.sendKeys(element, value).build().perform();
    }

    public void sendKeysE2(Actions act, WebElement element, String value) {
        act.sendKeys(element, value).build().perform();
    }

    public void sendKeysE3(Actions act, WebElement element, String value) {
        act.sendKeys(element, value).build().perform();
    }

    public void sendKeysE4(Actions act, WebElement element, String value) {
        act.sendKeys(element, value).build().perform();
    }

    public void sendKeysE5(Actions act, WebElement element, String value) {
        act.sendKeys(element, value).build().perform();
    }

    public void btnclick(WebDriver driver, JavascriptExecutor executor2, WebElement ele2) throws InterruptedException {
        driver.findElement(By.xpath("//mat-radio-button[1]/label/span[1]/span[1]"));
        executor2.executeScript("arguments[0].click();", ele2);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
    }
}
