package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyfile {

	public static void main(String[] args) throws IOException {
		
		FileReader file = new FileReader("C:\\Users\\hirem\\Desktop\\QA Assignment\\TestAutomationFramework\\src\\test\\resources\\configfiles\\config.properties");

		Properties p = new Properties();

		p.load(file);

		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("applicationurl"));

	}

}
