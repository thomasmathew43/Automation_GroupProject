package mainFunctionalities;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProductsPage {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
    	//WebDriver driver = new FirefoxDriver();
        driver.get("https://bookcart.azurewebsites.net/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String[] items = { "HP2", "HP5", "Slayer","Catching Fire","The Fault in Our Stars", "11/22/63" };

        ProductsPage product = new ProductsPage();
        product.filterProducts(driver);
        product.addToCartMatchingItems(driver, items);

        Thread.sleep(3000);
        System.out.println("Items Added into the cart");
    }

    public void filterProducts(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//app-book-filter/mat-nav-list/mat-list-item[4]")).click();
        Thread.sleep(3000);
    }

    public void addToCartMatchingItems(WebDriver driver, String[] items) {
        List<WebElement> productTitles = driver.findElements(By.xpath("//div[@class='card-title']"));
        int itemCount = 0;

        for (int i = 0; i < productTitles.size(); i++) {
            String name = productTitles.get(i).getText();
            List<String> itemsNeededList = Arrays.asList(items);
            
            if (itemsNeededList.contains(name)) {
                itemCount++;
                driver.findElements(By.xpath("//app-addtocart/button")).get(i).click();
               
                if (itemCount == items.length) {
                    break;
                }
            }
        }
    }


}
