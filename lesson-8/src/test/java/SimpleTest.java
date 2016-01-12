
/**
 * Created by Jacek on 2015-08-01.
 */

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class SimpleTest {

	private static WebDriver driver;

	private static final String URL = "http://localhost:8080/registrationform/";

	@Before
	public void openBrowser() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void shouldShowWrongAnswerPopupWhenAsnwerIsIncorrect() {

		driver.get(URL);
		String title = driver.getTitle();
		assertEquals("Rule Financial Registration Form", title);

		driver.findElement(By.name("firstName")).clear();
		driver.findElement(By.name("firstName")).sendKeys("Krzysztof");
		driver.findElement(By.name("lastName")).clear();
		driver.findElement(By.name("lastName")).sendKeys("Kosek");

		String email = new String("abcdefghijklm@o2.pl");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("repeatEmail")).clear();
		driver.findElement(By.name("repeatEmail")).sendKeys(email);
		driver.findElement(By.xpath("//*[@class='gwt-Button' and text()='SQL']")).click();
		driver.findElement(By.xpath("//*[@id='gwt-uid-22']")).click();
		driver.findElement(By.xpath("//*[@id='gwt-uid-26']")).click();
		assertEquals(checkAnswer(), false);
	}

	@Test
	public void shouldShowWrongAnswerPopupWhenAsnwerIsCorrect() {

		driver.get(URL);
		String title = driver.getTitle();
		assertEquals("Rule Financial Registration Form", title);

		driver.findElement(By.name("firstName")).clear();
		driver.findElement(By.name("firstName")).sendKeys("Krzysztof");
		driver.findElement(By.name("lastName")).clear();
		driver.findElement(By.name("lastName")).sendKeys("Kosek");

		String email = new String("ko@o2.pl");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("repeatEmail")).clear();
		driver.findElement(By.name("repeatEmail")).sendKeys(email);
		driver.findElement(By.xpath("//*[@class='gwt-Button' and text()='SQL']")).click();
		driver.findElement(By.xpath("//*[@id='gwt-uid-23']")).click();
		driver.findElement(By.xpath("//*[@id='gwt-uid-26']")).click();
		assertEquals(checkAnswer(), true);
	}

	private Object checkAnswer() {
		if (driver.findElement(By.xpath("//*[@class='GOFRIDJCEI' and text()='Congratulations! You've won:']"))
				.isDisplayed())
			return true;
		else
			return false;
	}

	@Test
	public void shouldNotifyWhenRepeatedEmailIsDifferentFromYourEmail() {
		driver.get(URL);
		String title = driver.getTitle();
		assertEquals("Rule Financial Registration Form", title);

		driver.findElement(By.name("firstName")).clear();
		driver.findElement(By.name("firstName")).sendKeys("Krzysztof");
		driver.findElement(By.name("lastName")).clear();
		driver.findElement(By.name("lastName")).sendKeys("Kosek");

		String email = new String("ko@o2.pl");
		String emailRepeat = new String("ko@o2.pl");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(email);

		driver.findElement(By.name("repeatEmail")).clear();
		driver.findElement(By.name("repeatEmail")).sendKeys(emailRepeat);

		assertEquals("Please provide an identical email as you have written above.",
				driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/div[5]/div/div")).getText());
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}
}
