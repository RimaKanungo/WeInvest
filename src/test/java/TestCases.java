import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestCases {

	WebDriver wbdv = null;
	public static ChromeDriver driver = null;
	EventFiringWebDriver eventdriver = null;


	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		wbdv = new ChromeDriver();
		eventdriver = new EventFiringWebDriver(wbdv);
	}

	@Test
	public void testA() throws InterruptedException 
	{

		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		wbdv = new ChromeDriver();
		eventdriver = new EventFiringWebDriver(wbdv);

		//Navigating to weInvest web
		eventdriver.navigate().to("https://sfo-demo.herokuapp.com/model-portfolio");
		System.out.println("Successfully navigated to the test url");

		// Maximizing browser window
		eventdriver.manage().window().maximize();
		System.out.println("Successfully Maximised the website");

		//Clicking on the “Explore Investment Ideas” Under “All Weather Strategy”
		eventdriver.findElement(By.id("btn-explore79")).click();
		System.out.println("Successfully clicked on the Explore Investment Ideas button ");

		// Implicitly wait for 30 seconds
		eventdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Clicking on on button “Customize Portfolio”
		eventdriver.findElement(By.xpath("//a[contains(text(),'Customize Portfolio')]")).click();
		System.out.println("Successfully clicked on the Customize Portfolio button ");

		//Clicking on “Customise” button
		eventdriver.findElement(By.xpath("//a[contains(text(),'Customise')]")).click();
		System.out.println("Successfully clicked on the Customise button ");

		// Scrolling Webpage down
		eventdriver.executeScript("scroll(" + 300 + "," + 300 + ")");
		System.out.println("Successfully Scrolled the page down");

		//Changing slider of “ SPDR S&P 500 ETF TRUST SPY US EQUITY ” to 50%
		WebElement Slider = eventdriver.findElement(By.xpath("(//*[contains(@class,'row constituent-row vertical-align')])[1]//input"));
		Thread.sleep(3000);
		Actions moveSlider = new Actions(eventdriver);
		Action action = moveSlider.dragAndDropBy(Slider, 3,0).build();
		action.perform();
		System.out.println("Successfully changed the slider to 50% ");

		//Clicking on Rebalance button
		eventdriver.findElement(By.xpath("//a[contains(text(),'Rebalance')]")).click();
		System.out.println("Successfully Clicked on Rebalanced Button ");

		//Clicking on Invest Now button
		eventdriver.findElement(By.xpath("//a[contains(text(),'Invest Now')]")).click();
		System.out.println("Successfully Clicked on Invest Now button ");

		//Verifying the SPDR portfolio is 50% or not.
		String ExpectedString = "50%";
		WebElement txt = eventdriver.findElement(By.xpath("//div[@class='panel portfolio-constituent-card']//li[1]//div[1]//div[1]//div[3]"));
		String ActualString = txt.getText();
		System.out.println("ExpectedString is " +ExpectedString);
		System.out.println("ActualString is " +ActualString);

		//Asserting the Expected SPDR% and Actual SPDR%
		Assert.assertEquals(ActualString,ExpectedString);
		System.out.println("Successfully asserted whether SPDR portfolio is 50% or not");

		// Close window
		wbdv.close();

	}

	@Test
	public void testB() throws InterruptedException {

		//Navigating to weInvest web
		eventdriver.navigate().to("https://sfo-demo.herokuapp.com/model-portfolio");
		System.out.println("Successfully navigated to the test url");

		// Implicitly wait for 50 seconds
		//eventdriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		// Maximizing browser window
		eventdriver.manage().window().maximize();
		System.out.println("Successfully Maximised the website");


		//Clicking on the “Explore Investment Ideas” Under “All Weather Strategy”
		eventdriver.findElement(By.id("btn-explore79")).click();
		System.out.println("Successfully clicked on the Explore Investment Ideas button ");

		// Implicitly wait for 30 seconds
		eventdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Clicking on on button “Customize Portfolio”
		eventdriver.findElement(By.xpath("//a[contains(text(),'Customize Portfolio')]")).click();
		System.out.println("Successfully clicked on the Customize Portfolio button ");

		//Clicking on “Customise” button
		eventdriver.findElement(By.xpath("//a[contains(text(),'Customise')]")).click();
		System.out.println("Successfully clicked on the Customise button ");

		//Verifying the text changed to "Reset" Button or not.
		String ExpectedText = "Reset";
		WebElement Text = eventdriver.findElement(By.xpath("//a[contains(text(),'Reset')]"));
		String ActualText = Text.getText();
		System.out.println("ExpectedText is " +ExpectedText);
		System.out.println("ActualText is " +ActualText);

		//Asserting the text changed to "Reset" Button or not
		Assert.assertEquals(ActualText,ExpectedText);
		System.out.println("Successfully asserted whether text changed to Reset Button or not");

		//Clicking on “+Add Stock” Link
		eventdriver.findElement(By.xpath("//a[contains(text(),'Add Stock')]")).click();
		System.out.println("Successfully clicked on Add Stock");


		Thread.sleep(3000l);

		//Clicking on “Add Stock” in “BT Group plc” row.
		eventdriver.findElement(By.xpath("//*[text()='BT Group plc']//ancestor::div[@class='row stock-row vertical-align']//button[@data-allocation-name='US EQUITIES']")).click();
		System.out.println("Successfully clicked on Add Stock in “BT Group plc” row.");

		Thread.sleep(3000l);

		//Clicking on Done Button.
		eventdriver.findElement(By.xpath("(//div[@class='modal-footer']//button)[1]")).click();
		System.out.println("Successfully clicked on Done Button");

		if(eventdriver.findElement(By.xpath("(//div[contains(@class,'row constituent-category vertical')]//*[text()='US EQUITIES']//ancestor::div[contains(@class,'row constituent-category-list')]//*[text()='BT Group plc'])[1]")).isDisplayed())
			System.out.println("Pass: BT Group plc” is added to the portfolio ");
		else
			System.out.println("False: BT Group plc” is not added to the portfolio");

		//closing the window
		eventdriver.close(); 

	}
}














