package seleniumbasic;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class Phantom_js {

	@Test
	public void verifyFb_title() {

		File src = new File("E:\\softwares\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
		WebDriver driver = new PhantomJSDriver();
		driver.get("http://www.facebook.com");
		System.out.println(driver.getTitle());

	}

}
