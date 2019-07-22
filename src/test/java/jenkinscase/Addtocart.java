package jenkinscase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Addtocart {
	public static WebDriver driver;
	public static WebDriverWait wait;
	@Given("the user has to signin")
	public void the_user_has_to_signin() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\test\\Desktop\\Calvin\\JAR folder\\chromedriver.exe");
		driver=new ChromeDriver();
	   driver.get("http://192.168.40.4:8083/TestMeApp1/fetchcat.htm");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   driver.findElement(By.xpath(".//a[@href='login.htm']")).click();
	}

	@Given("the user provides {string} and {string}")
	public void the_user_provides_and(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.name("userName")).sendKeys(string);
		    driver.findElement(By.name("password")).sendKeys(string2);
	}

	@Then("the user clicks the signin button")
	public void the_user_clicks_the_signin_button() {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.name("Login")).click();
	}

	@Given("Alex has registered into testmeapp")
	public void alex_has_registered_into_testmeapp() {
	    // Write code here that turns the phrase above into concrete actions
	   }

	@When("alex searches for headphone")
	public void alex_searches_for_headphone() {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(By.xpath(".//input[@name='products']")).sendKeys("Headphone");
	   driver.findElement(By.xpath(".//input[@value='FIND DETAILS']")).click();
	}

	@When("try to proceed without adding any items to the cart")
	public void try_to_proceed_without_adding_any_items_to_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
		 if (driver.findElements(By.cssSelector("i.fa.fa-shopping-cart")).size()!=0) {
				driver.findElement(By.cssSelector("i.fa.fa-shopping-cart")).click();
			}
		 else
		 {
			 System.out.println("ICON NOT FOUND");
		 }
		 
	  }

	@Then("TestMeApp doesn't display the icon")
	public void testmeapp_doesn_t_display_the_icon() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	 
	  driver.findElement(By.xpath(".//a[@href='logout.htm']")).click();
	  Thread.sleep(3000);
	  driver.close();
	}
}
