package vgqa;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Overall_VGQA_Mig {

	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeMethod
	public void open() throws InterruptedException {
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://app.vgqa.glint.cloud-dev.microsoft/session/auth");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("qatester@glintinc.com");
		driver.findElement(By.xpath("/html/body/glint-session-root/div/glint-session-auth/form/section/footer/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("clientUuid")).sendKeys("qa20220429");
		driver.findElement(By.xpath("/html/body/glint-session-root/div/glint-session-client/form/section/footer/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("Dem0@pass2");
		driver.findElement(By.xpath("/html/body/glint-session-root/div/glint-session-login/form/section/footer")).click();
		Thread.sleep(20000);
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

	
	  @Test (priority=1)
	  public void TC_001_ExportReport() throws InterruptedException {
	  driver.findElement(By.linkText("Reports")).click();
	  Thread.sleep(3000);
	  Assert.assertEquals(driver.findElement(By.xpath("/html/body/glint-root/div/div/main/glint-report-landing/glint-reports/glint-panel/div/header/div[1]/h1")).getText(), "Reports");
	  driver.findElement(By.xpath("//div[@class=\"header overallResultsReport\"]")).click(); 
	  Thread.sleep(10000);
	  Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='reportTitle']")).getText(), "Overall Results");
	  driver.findElement(By.xpath("(//div[@class='menuButton glintButton'])[1]")).click(); 
	  Thread.sleep(2000); 
	  String parentwid = driver.getWindowHandle();
	  System.out.println("Parent ID" + parentwid);
	  driver.findElement(By.xpath("//*[@id=\"option1\"]")).click(); 
	  Set<String> allID = driver.getWindowHandles(); 
	  List<String> l = new  ArrayList<String>(allID);
	  driver.switchTo().window(l.get(1));
	  Thread.sleep(20000);
	  String parentwid2 = driver.getWindowHandle();
	  System.out.println("Parent ID2" + parentwid2); 
	  Set<String> allID2 =driver.getWindowHandles();
	  List<String> l2 = new ArrayList<String>(allID2);
	  driver.switchTo().window(l2.get(1)); 
	  Thread.sleep(2000); 
	  driver.close();
	  
	  }
	 
	
	  @Test (priority=2)
	  public void TC_SaveReport_002() throws InterruptedException {
		  driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class=\"header overallResultsReport\"]")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//div[@class='menuButton glintButton'])[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"option4\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"reportDetailHeader\"]/glint-report-header/div/div[1]/div/glint-report-template-tools/glint-report-save-dialog/glint-dialog/div/div[2]/div/section/glint-use-latest-data-toggle/glint-toggle/div/label")).click();
			driver.findElement(By.xpath("//button[@class='btnCta glintButton']")).click();
			Thread.sleep(20000);
			
			driver.close();
			}
	  @Test (priority=3)
	  public void TC_SaveAsReport_003() throws InterruptedException {
		  driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class=\"header overallResultsReport\"]")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//div[@class='menuButton glintButton'])[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"option5\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"reportDetailHeader\"]/glint-report-header/div/div[1]/div/glint-report-template-tools/glint-report-save-dialog/glint-dialog/div/div[2]/div/section/glint-use-latest-data-toggle/glint-toggle/div/label")).click();
			driver.findElement(By.xpath("//button[@class='btnCta glintButton']")).click();
			Thread.sleep(20000);
			
			driver.close();
			}
	
	@Test(priority=3)
	public void TC_AddSection_003() throws InterruptedException {
		driver.findElement(By.linkText("Reports")).click();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/glint-root/div/div/main/glint-report-landing/glint-reports/glint-panel/div/header/div[1]/h1")).getText(), "Reports");
		driver.findElement(By.xpath("//div[@class=\"header overallResultsReport\"]")).click();
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='reportTitle']")).getText(), "Overall Results");
		driver.findElement(By.xpath("(//div[@class='menuButton glintButton'])[2]")).click();
		Thread.sleep(4000);
	//	Assert.assertEquals(driver.findElement(By.xpath("/html/body/glint-root/div/div/main/glint-engagement-report/glint-report-detail/glint-report-section-add-slidey/glint-slidey/div/div[3]/div/header/div/div/h1")).getText(), "Add section");
		driver.findElement(By.xpath("//li[@id='option0']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"reportDetailSectionAddSlidey\"]/glint-slidey/div/div[3]/div/div/section/div/glint-report-section-add-list/ul/li[1]/glint-report-section-add-item/div/button/i\r\n"+ "")).click();
		Thread.sleep(4000);
		driver.close();
		
}
	@Test
	public void TC_004_005_NewReport_Dropdown() throws InterruptedException {
		driver.findElement(By.linkText("Reports")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/glint-root/div/div/main/glint-report-landing/glint-reports/glint-panel/div/header/div[1]/h1")).getText(), "Reports");
		
		  driver.findElement(By.xpath("//button[@class='btnCta btnWithIcon glintButton ng-star-inserted']")).click(); 
		  Thread.sleep(3000); 
		  driver.findElement(By.xpath("//div[@class='menuButton text small glintButton']")).click();
		 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@id='option3']")).click();
		Thread.sleep(3000);
		
		driver.close();

	}
	
}