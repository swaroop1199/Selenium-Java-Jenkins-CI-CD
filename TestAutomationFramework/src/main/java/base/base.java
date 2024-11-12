package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	
	public static WebDriver driver;
	public static Properties pr = new Properties();
	public static FileReader f;
	protected Logger log;
	
	//Creating Report with ExtentReport Maven Dependency 3.1.5 
	public ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ExtentReportTest.html");
	public ExtentReports ExtentReportTest = new ExtentReports();
	//ExtentReportTest2.attachReporter(htmlReporter);

	
	@BeforeMethod(alwaysRun = true)
	public void setup(ITestContext cmt) throws IOException {
		
		//Setup for Log4js2 to Log Messages
		String testname = cmt.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testname);
		ExtentReportTest.attachReporter(htmlReporter);

		if (driver == null) {
			FileReader fr = new FileReader("C:\\Users\\hirem\\Desktop\\QA Assignment\\TestAutomationFramework\\src\\test\\resources\\configfiles\\config.properties");
			pr.load(fr);
		}

		if (pr.getProperty("browser").equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver","F:\\QA\\Chromedriver Path\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(co);
			driver.get(pr.getProperty("applicationurl"));
			log.info("SetUp Successful");
		}

		else if (pr.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(pr.getProperty("applicationurl"));
			log.info("SetUp Successful");
		}

		else if (pr.getProperty("browser").equalsIgnoreCase("msedge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(pr.getProperty("applicationurl"));
			log.info("SetUp Successful");
		}

	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {

		driver.quit();
		log.info("Teardown Successful");
		ExtentReportTest.flush();
		log.info("ExtentReport Flush Successful");
	}
	
	

}
