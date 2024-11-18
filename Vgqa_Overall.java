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
public class Vgqa_Overall {
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	@BeforeMethod
	public void open() throws InterruptedException {
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		//js = (JavascriptExecutor) driver;
        
		driver.get("https://app.vgqa.glint.cloud-dev.microsoft/session/auth");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("qatester@glintinc.com");
		driver.findElement(By.xpath("//button[@class='btnCta glintButton']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("clientUuid")).sendKeys("qa20220429");
		driver.findElement(By.xpath("//button[@class='btnCta glintButton']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("Dem0@pass2");
		driver.findElement(By.xpath("//button[@class='btnCta glintButton']")).click();
		Thread.sleep(40000);
	}

	@AfterMethod
	public void close() {
		//driver.quit();
	}

	@Test(priority=0)	
	public void TC_001_overall() throws InterruptedException {
		driver.findElement(By.linkText("Reports")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='Magic ORR']")).click();
		Thread.sleep(3000);
		//js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//div[@class=\"header overallResultsReport\"]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript( "window.scrollBy(0,150)");
		driver.close();
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
		driver.close();
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
		driver.close();
	}
	@Test(priority=3)	
	public void TC_003_NewReport() throws InterruptedException {
		driver.findElement(By.linkText("Reports")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btnCta btnWithVgIcon glintButton ng-star-inserted']")).click();
		Thread.sleep(3000);
		driver.close();

	}
	
	
	@Test(priority=4)	
	public void TC_003_ViewQuestion() throws InterruptedException {
		driver.findElement(By.linkText("Reports")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("comments");  
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='comments']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btnCta btnWithVgIcon glintButton ng-star-inserted']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='menuButton text small glintButton']")).click();
		Thread.sleep(3000);;
		driver.findElement(By.id("option3")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='inlineBtn glintButton']")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='View Questions']")).getText(),"View Questions");			
		System.out.println(driver.findElement(By.xpath("//h1[text()='View Questions']")).getText());
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

	}
	@Test (priority=5)	
	  public void TC_004_ExportReport() throws InterruptedException {
		driver.findElement(By.linkText("Reports")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("comments");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='comments']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='header overallResultsReport']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='menuButton glintButton btnCta btnSlim']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String parentwid=driver.getWindowHandle();
		System.out.println("Parent ID"+parentwid);
		driver.findElement(By.xpath("//*[@id=\"option1\"]")).click();
		Set<String> allID=driver.getWindowHandles();
		List<String> l=new ArrayList<String>(allID);
		driver.switchTo().window(l.get(1));
		Thread.sleep(20000);
		String parentwid2=driver.getWindowHandle();
		System.out.println("Parent ID2"+parentwid2);
		Set<String> allID2=driver.getWindowHandles();
		List<String> l2=new ArrayList<String>(allID2);
		driver.switchTo().window(l2.get(1));
		Thread.sleep(10000);
		 
	  
	  }
	 
	//
	@Test (priority=6)	
	  public void TC_005_006_AddCloseFilter() throws InterruptedException {
		driver.findElement(By.linkText("Reports")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("comments");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='comments']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btnCta btnWithVgIcon glintButton ng-star-inserted']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='menuButton text small glintButton']")).click();
		Thread.sleep(3000);;
		driver.findElement(By.id("option3")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Add Filters']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='input ng-pristine ng-valid ng-touched']")).sendKeys("gender");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//em[text()='Gender']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='ng-pristine ng-valid ng-touched']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btnSm btnCta glintButton ng-star-inserted']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='deleteFilterButton btnIcon glintButton ng-star-inserted']")).click();
		Thread.sleep(1000);
		
	}
	@Test (priority=7)	
	  public void TC_007_VerifyDefaultSection() throws InterruptedException {
		driver.findElement(By.linkText("Reports")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Magic ORR");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='Magic ORR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btnCta btnWithVgIcon glintButton ng-star-inserted']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='menuButton text small glintButton']")).click();
		Thread.sleep(3000);;
		driver.findElement(By.id("option3")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btnWithVgIcon subtleBtn footerButton glintButton ng-star-inserted']")).click();
		Thread.sleep(3000);
		
		//To verify Survey Overview Section
		String SO= driver.findElement(By.xpath("//p[text()='Survey Overview']")).getText();
		System.out.println(SO);
		Assert.assertEquals(SO,"Survey Overview");
		
		//To verify Scores Section
	Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Scores']")).getText(),"Scores");
				
				
		//To verify Location Section
		//		Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='menuButton text smallHeaderText glintButton'])[1]")).getText(),"Workspace");
				
				
				
		//To verify Top and Bottom Scores Section
				//Assert.assertEquals(driver.findElement(By.xpath("//th[text()='Top Scores']")).getText(),"Top Scores");
				//Assert.assertEquals(driver.findElement(By.xpath("//th[text()='Bottom Scores']")).getText(),"Bottom Scores");
				
				
}
	@Test(priority=8)	
	public void TC_008_ShowSubsetQuestion() throws InterruptedException {
		driver.findElement(By.linkText("Reports")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("comments"); 
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='comments']")).click();
			
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btnCta btnWithVgIcon glintButton ng-star-inserted']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='menuButton text small glintButton']")).click();
		//driver.findElement(By.xpath("//div[@class='menuButton text small glintButton']")).click();
		
		Thread.sleep(3000);;
		driver.findElement(By.id("option3")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='inlineBtn glintButton']")).click();
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(5000);
	
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='View Questions']")).getText(),"View Questions");
				
		System.out.println(driver.findElement(By.xpath("//h1[text()='View Questions']")).getText());
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		

		driver.findElement(By.xpath("//input[@class='showSubset']")).click();
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//input[@class='input ng-pristine ng-valid ng-touched']")).click();
		
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("(//input[@type='search'])[3]")).click();
		//Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//li[@id='option1']")).click();
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//Thread.sleep(2000);
}
	

	@Test(priority=1)	
	public void TC_009_AdvFilter_QuestionRsponse() throws InterruptedException {
		driver.findElement(By.linkText("Reports")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Magic ORR");  
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='Magic ORR']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript( "window.scrollBy(0,150)");
		driver.findElement(By.xpath("//div[@class='header overallResultsReport']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class=\"addFilterButtonPanel ng-star-inserted\"]")).click();
		Thread.sleep(3000);
		//button[@class="inlineBtnLink advancedToggle glintButton"]
		driver.findElement(By.xpath("//button[@class=\"inlineBtnLink advancedToggle glintButton\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class=\"btnCta glintButton\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()=\"Add Filters\"])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id=\"tab-QUESTION_RESPONSE\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[text()=\"Acceptance\"])[1]")).click();
		Thread.sleep(3000);
		String Fav1=driver.findElement(By.xpath("//*[@id=\"filterPanelMain\"]/div[1]/div/div[2]/div/glint-survey-filters-list/glint-advanced-survey-filters/div/div/glint-survey-filters/glint-add-filter/glint-filter-editor/div/glint-filter-editor-filter-values/fieldset/div[1]/label")).getText();
		String neut=driver.findElement(By.xpath("//*[@id=\"filterPanelMain\"]/div[1]/div/div[2]/div/glint-survey-filters-list/glint-advanced-survey-filters/div/div/glint-survey-filters/glint-add-filter/glint-filter-editor/div/glint-filter-editor-filter-values/fieldset/div[2]/label")).getText();
		String UFav=driver.findElement(By.xpath("//*[@id=\"filterPanelMain\"]/div[1]/div/div[2]/div/glint-survey-filters-list/glint-advanced-survey-filters/div/div/glint-survey-filters/glint-add-filter/glint-filter-editor/div/glint-filter-editor-filter-values/fieldset/div[3]/label")).getText();
		System.out.println("Fv1" +Fav1);
		System.out.println("Neu" +neut);
		System.out.println("UFv1" +UFav);
	    Assert.assertEquals(Fav1,"Favorable"); 
	    Assert.assertEquals(neut,"Neutral");
	    Assert.assertEquals(UFav,"Unfavorable");
	    driver.close();

	}




}
