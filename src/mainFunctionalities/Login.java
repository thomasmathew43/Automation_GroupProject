package mainFunctionalities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new FirefoxDriver();
		driver.get("https://bookcart.azurewebsites.net/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(3000);

		Login lo = new Login();
		lo.clickbtn(driver);

		Actions act = new Actions(driver);

		WebElement element11 = driver.findElement(By.xpath("//form/mat-form-field[1]/div/div[1]"));
		WebElement element22 = driver.findElement(By.xpath("//form/mat-form-field[2]/div/div[1]"));

		lo.login(driver, element11, element22, act);
		lo.clickbtn(driver);
	}

	public void login(WebDriver driver, WebElement element11, WebElement element22, Actions act) {
		act.sendKeys(element11, "group123").build().perform();
		act.sendKeys(element22, "Group@123").build().perform();
	}

	public void clickbtn(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//mat-toolbar/mat-toolbar-row/div[3]/button[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//mat-card-actions/button")).click();
	}
}
