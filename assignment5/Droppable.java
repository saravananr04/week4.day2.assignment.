package w4.d2.assignment5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(0);
		WebElement element = driver.findElement(By.xpath("//div[@id = 'draggable']"));
		WebElement element1 = driver.findElement(By.xpath("//div[@id = 'droppable']"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(element, element1).perform();
		String text = driver.findElement(By.xpath("//div[@id = 'droppable']")).getText();
		System.out.println(text);

	}
}
