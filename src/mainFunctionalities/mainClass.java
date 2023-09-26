package mainFunctionalities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;  // Import for FileUtils

public class mainClass {

    public static void main(String[] args) throws InterruptedException, IOException {
    	
        WebDriver driver = new ChromeDriver();
    	//WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://bookcart.azurewebsites.net/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Register
        takeScreenshot(driver, "registerpage.png");
        Actions act = new Actions(driver);
        Register reg = new Register();
        
        driver.findElement(By.xpath("//mat-toolbar/mat-toolbar-row/div[3]/button[2]")).click();
        driver.findElement(By.xpath("//app-login/div/div[1]/div/div/button")).click();
        reg.waiting(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));

        WebElement element1 = driver.findElement(By.xpath("//form/mat-form-field[1]/div/div[1]"));
        WebElement element2 = driver.findElement(By.xpath("//form/mat-form-field[2]/div/div[1]"));
        WebElement element3 = driver.findElement(By.xpath("//form/mat-form-field[3]"));
        WebElement element4 = driver.findElement(By.xpath("//form/mat-form-field[4]"));
        WebElement element5 = driver.findElement(By.xpath("//form/mat-form-field[5]"));

        reg.sendKeysE1(act, element1, "group1");
        reg.sendKeysE2(act, element2, "group2");
        reg.sendKeysE3(act, element3, "group123");
        reg.sendKeysE4(act, element4, "Group@123");
        reg.sendKeysE5(act, element5, "Group@123");

        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        WebElement ele2 = driver.findElement(By.xpath("//mat-radio-button[1]/label/span[1]/span[1]"));
        reg.btnclick(driver, executor2, ele2);

        // Login
        Thread.sleep(3000);
        Login lo = new Login();
    	
    	
        lo.clickbtn(driver);
        WebElement element11 = driver.findElement(By.xpath("//form/mat-form-field[1]/div/div[1]"));
		WebElement element22 = driver.findElement(By.xpath("//form/mat-form-field[2]/div/div[1]"));

        lo.login(driver, element11, element22, act);
        lo.clickbtn(driver);

        // ProductsPage
        takeScreenshot(driver, "product.png");
        String[] items = { "HP2", "HP5", "Slayer", "Catching Fire", "The Fault in Our Stars", "11/22/63" };
        ProductsPage product = new ProductsPage();
        product.filterProducts(driver);
        product.addToCartMatchingItems(driver, items);
        Thread.sleep(3000);

        // CartPage
        takeScreenshot(driver, "cartpage.png");
        CartPage cart = new CartPage();
        System.out.println("Cart is Added");
        JavascriptExecutor executor22 = (JavascriptExecutor) driver;
        WebElement ele22 = driver.findElement(By.xpath("//mat-toolbar/mat-toolbar-row/div[3]/button[2]/span[3]"));
        cart.cartclickbtn(driver, ele22, executor22);
        
        
        // Order_loggoff
        takeScreenshot(driver, "orderlogg.png");
        Order_loggoff logff = new Order_loggoff();
       

        logff.calogoff(driver);

        WebElement na = driver.findElement(By.xpath("//mat-card/mat-card-content/form/mat-form-field[1]/div/div[1]"));
        WebElement na1 = driver.findElement(By.xpath("//mat-card/mat-card-content/form/mat-form-field[2]/div/div[1]"));
        WebElement na2 = driver.findElement(By.xpath("//mat-card/mat-card-content/form/mat-form-field[3]/div/div[1]"));
        WebElement na3 = driver.findElement(By.xpath("//mat-card/mat-card-content/form/mat-form-field[4]/div/div[1]"));
        WebElement na4 = driver.findElement(By.xpath("//mat-card/mat-card-content/form/mat-form-field[5]/div/div[1]"));

        logff.sendke(driver, na, na1, na2, na3, na4, act);

        logff.calogooff2(driver);

        // Take a screenshot of the completed process
        //takeScreenshot(driver, "Login.png");

        System.out.println("Process completed.");
        Thread.sleep(3000);
       
        // Close the browser
        driver.quit();
       
    }

    // Helper method to take screenshots
    private static void takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        // Convert WebDriver to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture screenshot as File
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        // Define destination path for the screenshot
        String destPath = "./screenshots/" + screenshotName;

        // Copy the screenshot to the destination
        FileUtils.copyFile(srcFile, new File(destPath));

        System.out.println("Screenshot saved: " + destPath);
    }
}
