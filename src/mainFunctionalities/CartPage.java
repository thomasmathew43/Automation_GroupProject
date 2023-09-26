package mainFunctionalities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CartPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new FirefoxDriver();
		driver.get("https://bookcart.azurewebsites.net/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		CartPage cart = new CartPage();

		System.out.println("It's completed");
		JavascriptExecutor executor22 = (JavascriptExecutor) driver;
		WebElement ele22 = driver.findElement(By.xpath("//mat-toolbar/mat-toolbar-row/div[3]/button[2]/span[3]"));
		cart.cartclickbtn(driver, ele22, executor22);
	}

	public void cartclickbtn(WebDriver driver, WebElement ele22, JavascriptExecutor executor22)
			throws InterruptedException {
		executor22.executeScript("arguments[0].click();", ele22);
	}
}
