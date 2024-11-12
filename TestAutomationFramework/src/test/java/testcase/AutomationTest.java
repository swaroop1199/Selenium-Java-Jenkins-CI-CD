package testcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationTest {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ExtentReportTest.html");
		ExtentReports ExtentReportTest = new ExtentReports();
		ExtentReportTest.attachReporter(htmlReporter);
		ExtentTest Test1 = ExtentReportTest.createTest("Add Customer with Tariff Plan", "User should able to use application and add customer and tariff plan");
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.get("https://demo.guru99.com/telecom/index.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String name = "Rakesh";
		String surname = "Sharma";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actualtitle = driver.getTitle();
		String exptitle = "Guru99 Telecom"; 
		Assert.assertEquals(actualtitle, exptitle);
		System.out.println("Assertion Passed - Home Page is Loaded");
		Test1.pass("Page is Loaded");
		driver.findElement(By.linkText("Add Customer")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement selenium = driver.findElement(By.className("dropdown-toggle"));
		Actions act = new Actions(driver);
		act.doubleClick(selenium).build().perform();
		Thread.sleep(3000);
		String expected = driver.getCurrentUrl();
		String actual = "https://demo.guru99.com/telecom/addcustomer.php";
		Assert.assertEquals(expected, actual);
		System.out.println("Assertion Passed - URL is Correct");
		JavascriptExecutor   j  =  (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		j.executeScript("window.scrollBy(0,300)");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div/input[@id='done']/following-sibling::label")).click();
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='lname']")).sendKeys(surname);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rakeshsharma@gmail.com");
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Pune Baner Maharashtra");
		j.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//input[@id='telephoneno']")).sendKeys("1234567899");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement e = driver.findElement(By.xpath("//header[@class='align-center']"));
		String actuallogintext = "Access Details to Guru99 Telecom";
		String expectedlogintext = e.getText();
		System.out.println("Customer is Added: " +e.getText());
		Assert.assertEquals(actuallogintext, expectedlogintext);
		System.out.println("Login is Successful");
		Test1.pass("Customer Added Successfully");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement a = driver.findElement(By.xpath("//td[@align='center']/following-sibling::td"));
		String customerID = a.getText();
		int stringcustomerID = Integer.parseInt(customerID);
		System.out.println("Customer ID is: "+ stringcustomerID);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='button']")).click();
		String actualtitle2 = driver.getTitle();
		String exptitle2 = "Guru99 Telecom"; 
		Assert.assertEquals(actualtitle2, exptitle2);
		System.out.println("Assertion Passed - Back to Home Page");
		driver.findElement(By.linkText("Add Tariff Plan to Customer")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action2 = new Actions(driver);
		Robot robot2 = new Robot();
		robot2.mouseMove(100, 700);
		action2.click().build().perform();
		WebElement b = driver.findElement(By.xpath("//header[@class='align-center']"));
		String actualtitle3 = "Add Tariff Plan to Customer";
		String exptitle3 = b.getText();
		Assert.assertEquals(actualtitle3, exptitle3);
		System.out.println("Assertion Passed - Add Tariff Plan Loaded Successfully");
		Test1.pass("Tariff Plan Added");
		driver.findElement(By.xpath("//input[@name='customer_id']")).sendKeys(customerID);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		WebElement d = driver.findElement(By.xpath("//marquee"));
		String actuallogintext4 = "Welcome to add customer tariff plan Rakesh";
		String expectedlogintext4 = d.getText();
		Assert.assertEquals(actuallogintext4, expectedlogintext4);
		System.out.println("Assertion Passed - Tariff Plan Home Page Successful");
		j.executeScript("window.scrollBy(0,400)");
		WebElement text = driver.findElement(By.xpath("//h2[1]"));
		String actuallogintext5 = "Approved Tariff Plans";
		String expectedlogintext5 = text.getText();
		Assert.assertEquals(actuallogintext5, expectedlogintext5);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement f = driver.findElement(By.xpath("//td/input[@id='sele']/following-sibling::label"));
		j.executeScript("arguments[0].click();", f);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		WebElement finaltext = driver.findElement(By.xpath("//div[@class='inner']/h2"));
		String actualtitle6 = "Congratulation Tariff Plan assigned";
		String exptitle6 = finaltext.getText();
		Assert.assertEquals(actualtitle6, exptitle6);
		System.out.println("Assertion Passed - Tariff Plan Assigned Succesfully to Customer");
		//Test1.pass("Tariff Plan Assigned Successfully to Customer");
		Test1.pass("Test Case Passed");
		driver.quit();
		ExtentReportTest.flush();
		}


	}

