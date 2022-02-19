package w4.d2.assignment4;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesLeafground {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.xpath("//iframe[@src = 'default.html']"));
		driver.switchTo().frame(element);
		WebElement element2 = driver.findElement(By.id("Click"));
		File source = element2.getScreenshotAs(OutputType.FILE);
		File dest = new File(".src/main/resources/snaps/Img05.jpg");
		FileUtils.copyFile(source, dest);
		List<WebElement> Frames = driver.findElements(By.tagName("iframe"));
		driver.switchTo().defaultContent();
		List<WebElement> Frames1 = driver.findElements(By.tagName("iframe"));
		WebElement element3 = driver.findElement(By.xpath("//iframe[@src = 'page.html']"));
		driver.switchTo().frame(element3);
		List<WebElement> Frames2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().defaultContent();
		WebElement element4 = driver.findElement(By.xpath("//iframe[@src = 'countframes.html']"));
		driver.switchTo().frame(element4);
		List<WebElement> Frames3 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().defaultContent();
		int NumFrames = Frames.size() + Frames1.size() + Frames2.size() + Frames3.size();
		System.out.println("Total number of Frames in this page " + NumFrames);

	}
}