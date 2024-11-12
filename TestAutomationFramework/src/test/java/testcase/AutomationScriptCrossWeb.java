package testcase;
import java.awt.AWTException;
import java.awt.Robot;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.base;

public class AutomationScriptCrossWeb extends base {
	
	//public int stringcustomerID; 
	
	@Test
	public void addcustomer() throws InterruptedException, AWTException {
	String name = "Rakesh";
	String surname = "Sharma";
	driver.manage().window().maximize();
	Thread.sleep(4000);
	String actualtitle = driver.getTitle();
	String exptitle = "Guru99 Telecom"; 
	Assert.assertEquals(actualtitle, exptitle);
	System.out.println("Assertion Passed - Home Page is Loaded");
	driver.findElement(By.linkText("Add Customer")).click();
	Thread.sleep(10000);
	Actions action = new Actions(driver);
	Robot robot = new Robot();
	robot.mouseMove(100, 700);
	action.click().build().perform();
	Thread.sleep(3000);
	String expected = driver.getCurrentUrl();
	String actual = "https://demo.guru99.com/telecom/addcustomer.php";
	Assert.assertEquals(expected, actual);
	System.out.println("Assertion Passed - URL is Correct");
	JavascriptExecutor   j  =  (JavascriptExecutor)driver;
	//j.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(2000);
	j.executeScript("window.scrollBy(0,300)");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div/input[@id='done']/following-sibling::label")).click();
	driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(name);
	driver.findElement(By.xpath("//input[@id='lname']")).sendKeys(surname);
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rakeshsharma@gmail.com");
	driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Pune Baner Maharashtra");
	j.executeScript("window.scrollBy(0,300)");
	driver.findElement(By.xpath("//input[@id='telephoneno']")).sendKeys("1234567899");
	driver.findElement(By.xpath("//input[@name='submit']")).click();
	Thread.sleep(2000);
	WebElement e = driver.findElement(By.xpath("//header[@class='align-center']"));
	String actuallogintext = "Access Details to Guru99 Telecom";
	String expectedlogintext = e.getText();
	System.out.println(e.getText());
	Assert.assertEquals(actuallogintext, expectedlogintext);
	System.out.println("Login is Successfull");
	Thread.sleep(2000);
	WebElement a = driver.findElement(By.xpath("//td[@align='center']/following-sibling::td"));
	String customerID = a.getText();
	System.out.println(a.getText());
	int stringcustomerID = Integer.parseInt(customerID);
	System.out.println("Customer ID is: "+ stringcustomerID);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@class='button']")).click();
	String actualtitle2 = driver.getTitle();
	String exptitle2 = "Guru99 Telecom"; 
	Assert.assertEquals(actualtitle2, exptitle2);
	System.out.println("Assertion Passed - Back to Home Page");
	driver.findElement(By.linkText("Add Tariff Plan to Customer")).click();
	Thread.sleep(10000);
	Actions action2 = new Actions(driver);
	Robot robot2 = new Robot();
	robot2.mouseMove(100, 700);
	action2.click().build().perform();
	WebElement b = driver.findElement(By.xpath("//header[@class='align-center']"));
	String actualtitle3 = "Add Tariff Plan to Customer";
	String exptitle3 = b.getText();
	Assert.assertEquals(actualtitle3, exptitle3);
	System.out.println("Assertion Passed - Add Tariff Plan Loaded Successfully");
	driver.findElement(By.xpath("//input[@name='customer_id']")).sendKeys(customerID);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='submit']")).click();
	WebElement d = driver.findElement(By.xpath("//marquee"));
	String actuallogintext4 = "Welcome to add customer tariff plan Rakesh";
	String expectedlogintext4 = d.getText();
	Assert.assertEquals(actuallogintext4, expectedlogintext4);
	System.out.println("Assertion Passed - Tariff Plan Home Page Successfull");
	j.executeScript("window.scrollBy(0,400)");
	WebElement text = driver.findElement(By.xpath("//h2[1]"));
	String actuallogintext5 = "Approved Tariff Plans";
	String expectedlogintext5 = text.getText();
	Assert.assertEquals(actuallogintext5, expectedlogintext5);
	Thread.sleep(5000);
	//WebElement f = driver.findElement(By.xpath("//td/input[@id='sele']/following-sibling::label"));
	//Actions ac = new Actions(driver);
	//ac.click(f).build().perform();
	//j.executeScript("window.getComputedStyle(document.querySelector('.alt'),'::before').click()");
	//driver.findElement(By.xpath("//label")).click();
	//Thread.sleep(4000);
	//window.getComputedStyle(document.getElementById('sele'),'::before').getPropertyValue('content')
	//window.getComputedStyle(document:$0,'::before').getPropertyValue('content')
	//driver.findElement(By.xpath("//td[@align='center']/input/following-sibling::label")).click();
	driver.findElement(By.xpath("//input[@name='submit']")).click();
	WebElement finaltext = driver.findElement(By.xpath("//div[@class='inner']/h2"));
	String actualtitle6 = "Congratulation Tariff Plan assigned";
	String exptitle6 = finaltext.getText();
	Assert.assertEquals(actualtitle6, exptitle6);
	System.out.println("Assertion Passed - Tariff Plan Assigned Succesfully to Customer");
	}

}
