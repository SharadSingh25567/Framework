package ECommerce24;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Endtoend {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productname = "ADIDAS ORIGINAL";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("SnghSha@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Singh@1234");
		driver.findElement(By.id("login")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> li = driver.findElements(By.cssSelector(".mb-3"));
		WebElement firstitem = li.stream().filter(l -> l.findElement(By.cssSelector("b")).getText().equals(productname))
				.findFirst().orElse(null);
		firstitem.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		// w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@style=\\\"margin-top:
		// -10px; margin-right: -40px;\\")));

		WebDriverWait wi = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));
		driver.findElement(By.xpath("//button[@routerlink=\"/dashboard/cart\"]")).click();
		// driver.findElement(By.xpath("//button[@style=\"margin-top: -10px;
		// margin-right: -40px;\"]")).click();
		// WebElement
		// anotheritem=li.stream().filter(l->l.findElement(By.cssSelector("b")).getText().equals("ZARA
		// COAT 3")).findFirst().orElse(null);
		// anotheritem.findElement(By.cssSelector(".card-body
		// button:last-of-type")).click();
		List<WebElement> cartitems = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartitems.stream().anyMatch(cartitem -> cartitem.getText().equalsIgnoreCase(productname));
		// Assert.assertTrue(match);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".subtotal.cf.ng-star-inserted button")));
		driver.findElement(By.cssSelector(".subtotal.cf.ng-star-inserted button")).click();
		driver.findElement(By.cssSelector(".field.small input:nth-child(2)")).sendKeys("244");
		driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")).sendKeys("Ind");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section/button[2]")));
		driver.findElement(By.xpath("//section/button[2]")).click();
		Thread.sleep(2000);
		// w.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));
		// WebElement element=driver.findElement(By.cssSelector(".action__submit"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(1049, 652)");
		driver.findElement(By.cssSelector(".action__submit")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
		Boolean m = driver.findElement(By.cssSelector(".hero-primary")).getText()
				.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
		Assert.assertTrue(m);
		System.out.println( driver.findElement(By.cssSelector(".hero-primary")).getText());

	}

}
