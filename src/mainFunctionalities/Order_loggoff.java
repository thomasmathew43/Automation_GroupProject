package mainFunctionalities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Order_loggoff {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
    	//WebDriver driver = new FirefoxDriver();
        driver.get("https://bookcart.azurewebsites.net/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Actions act = new Actions(driver);
        Order_loggoff logff = new Order_loggoff();

        logff.calogoff(driver);

        WebElement na = driver.findElement(By.xpath("//mat-card/mat-card-content/form/mat-form-field[1]/div/div[1]"));
        WebElement na1 = driver.findElement(By.xpath("//mat-card/mat-card-content/form/mat-form-field[2]/div/div[1]"));
        WebElement na2 = driver.findElement(By.xpath("//mat-card/mat-card-content/form/mat-form-field[3]/div/div[1]"));
        WebElement na3 = driver.findElement(By.xpath("//mat-card/mat-card-content/form/mat-form-field[4]/div/div[1]"));
        WebElement na4 = driver.findElement(By.xpath("//mat-card/mat-card-content/form/mat-form-field[5]/div/div[1]"));

        logff.sendke(driver, na, na1, na2, na3, na4, act);

        logff.calogooff2(driver);
    }

    public void calogoff(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'CheckOut')]")).click();
    }
    public void calogooff2(WebDriver driver) throws InterruptedException {
    	Thread.sleep(2000);
		driver.findElement(By.xpath("//mat-card/mat-card-content/form/mat-card-actions/button[1]")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//mat-toolbar-row/div[3]/button[3]/span[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//body/div[3]/div[2]/div/div/div/button[2]")).click();
    	
    }

    public void sendke(WebDriver driver, WebElement na, WebElement na1, WebElement na2, WebElement na3, WebElement na4, Actions act) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//mat-card/mat-card-content/form/mat-form-field[1]"));
        act.sendKeys(na, "group1").build().perform();
        driver.findElement(By.xpath("//mat-card/mat-card-content/form/mat-form-field[2]"));
        act.sendKeys(na1, "bangalore").build().perform();
        driver.findElement(By.xpath("//mat-card/mat-card-content/form/mat-form-field[3]"));
        act.sendKeys(na2, "bangalore2").build().perform();
        driver.findElement(By.xpath("//mat-card/mat-card-content/form/mat-form-field[4]"));
        act.sendKeys(na3, "562206").build().perform();
        driver.findElement(By.xpath("//mat-card/mat-card-content/form/mat-form-field[5]"));
        act.sendKeys(na4, "Karnataka").build().perform();
    }
}
