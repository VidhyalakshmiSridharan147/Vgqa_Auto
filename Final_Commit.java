package vgqa;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Final_Commit{
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	@BeforeMethod
	public void open() throws InterruptedException {
		driver = new ChromeDriver(); 
		
		driver.manage().window().maximize();
		
   		driver.get("https://app.vgqa.glint.cloud-dev.microsoft/session/auth");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("qatester@glintinc.com");
		driver.findElement(By.xpath("//button[@class='btnCta glintButton']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("clientUuid")).sendKeys("qa20231201");
		driver.findElement(By.xpath("//button[@class='btnCta glintButton']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("Dem0@pass2");
		driver.findElement(By.xpath("//button[@class='btnCta glintButton']")).click();
		Thread.sleep(30000);
	}

	@AfterMethod
	public void close() {
		//driver.quit();
	}

	@Test(priority=0)	
	public void TC_001_overall() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		driver.findElement(By.linkText("Reports")).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='Rec. R78 VI']")).click();
		Thread.sleep(100);
		//js.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.xpath("//div[@class='header overallResultsReport']")).click();
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	//	driver.close();
	}
	@Test(priority=1)	
	public void TC_002_savereport() throws InterruptedException {
		driver.findElement(By.linkText("Reports")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='Magic ORR']")).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//div[@class=\"header overallResultsReport\"]")).click();
		js.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.xpath("(//div[@class='menuButton glintButton btnCta btnSlim'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"option4\"]")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='btnCta glintButton']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.close();
	}
	@Test(priority=2)	
	public void TC_003_SaveAsreport() throws InterruptedException {
		driver.findElement(By.linkText("Reports")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='Magic ORR']")).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//div[@class=\"header overallResultsReport\"]")).click();
		js.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.xpath("(//div[@class='menuButton glintButton btnCta btnSlim'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"option5\"]")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("saveDialogTitle")).sendKeys("saitest");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='btnCta glintButton']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.close();
	}
	@Test(priority=3)	
	public void TC_004_Exportreport() throws InterruptedException {
		driver.findElement(By.linkText("Reports")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='Magic ORR']")).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//div[@class=\"header overallResultsReport\"]")).click();
		js.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.xpath("(//div[@class='menuButton glintButton btnCta btnSlim'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"option5\"]")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
}}
