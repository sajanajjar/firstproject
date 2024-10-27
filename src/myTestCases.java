import static org.testng.Assert.assertEquals;

import java.nio.channels.Selector;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class myTestCases {
	WebDriver driver = new ChromeDriver();
	String googlewebsite = "www.google.com";
	String WebSiteURL= "https://automationteststore.com/";
	String[] FirstNames = { "Saja", "maram", "alaa", "sara", "saba" };
	String[] LastNames = { "ayman", "jamal", "ah" };
	String GlobalFirstName ="";
	String GlobalPassword = "SSaja1234@@";
	String GlobalUserName ="";
	Random rand = new Random ();
	
	
	@BeforeTest 
	public void setUp() {
		//update
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(WebSiteURL);
		
	}
	
	@Test (priority =1 , enabled = false)
	public void signUp() throws InterruptedException {
		int RandomIndexForTheFirstNames = rand.nextInt(FirstNames.length);
		int RandomIndexForTheLastNames = rand.nextInt(LastNames.length);
		String FirstName = FirstNames [RandomIndexForTheFirstNames];
		GlobalFirstName = FirstName;
		String LastName = LastNames [RandomIndexForTheLastNames];
		int RandomNumberForTheEmail = rand.nextInt(84890);
		String EmailDomain= "@gmail.com";
		String LocalUserName = FirstName+LastName+RandomNumberForTheEmail;
		GlobalUserName = LocalUserName;
		String Email= LocalUserName+EmailDomain;
		driver.findElement(By.partialLinkText("Login or register")).click();
		WebElement SignUpButton = driver.findElement(By.xpath("//button[@title='Continue']"));
		SignUpButton.click();
		Thread.sleep(2000);
		WebElement FirstNameInput = driver.findElement(By.id("AccountFrm_firstname"));
		FirstNameInput.sendKeys(FirstName);
		WebElement LastNameInput = driver.findElement(By.id("AccountFrm_lastname"));
		LastNameInput.sendKeys(LastName);
		WebElement EmailInput = driver.findElement(By.id("AccountFrm_email"));
		EmailInput.sendKeys(Email);
		WebElement AddressInput = driver.findElement(By.id("AccountFrm_address_1"));
		AddressInput.sendKeys("Amman-tlaa al ali");
		WebElement CityInput = driver.findElement(By.id("AccountFrm_city"));
		CityInput.sendKeys("Capital City");
		WebElement CountryInput = driver.findElement(By.id("AccountFrm_country_id"));
		Select Selector = new Select(CountryInput);
		int RandomCountryIndex = rand.nextInt(1, 240);
		Selector.selectByIndex(RandomCountryIndex);
		Thread.sleep(5000);
		WebElement ZoneIDInput = driver.findElement(By.id("AccountFrm_zone_id"));
		Select Selector2 = new Select(ZoneIDInput);
		int RandomZoneIndex = rand.nextInt(1,6);
		Selector2.selectByIndex(RandomZoneIndex);
		WebElement PostalCodeInput = driver.findElement(By.id("AccountFrm_postcode"));
		PostalCodeInput.sendKeys("13310");
		WebElement LoginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		LoginNameInput.sendKeys(FirstName+LastName+RandomNumberForTheEmail);
		WebElement PasswordInput = driver.findElement(By.id("AccountFrm_password"));
		PasswordInput.sendKeys(GlobalPassword);
		WebElement ConfirmPasswordInput = driver.findElement(By.id("AccountFrm_confirm"));
		ConfirmPasswordInput.sendKeys(GlobalPassword);
		WebElement AgreeCheckBox = driver.findElement(By.id("AccountFrm_agree"));
		AgreeCheckBox.click();
		WebElement CountinueButton = driver.findElement(By.xpath("//button[@title='Continue']"));
		CountinueButton.click();
		
		
		
	}
	
	@Test (priority =2 , enabled = false )
	public void logOut() throws InterruptedException {
		Thread.sleep(3000);
		WebElement UserNav = driver.findElement(By.id("customernav"));
		Actions action = new Actions (driver);
		action.moveToElement(UserNav).perform();
		Thread.sleep(2000);
		WebElement LogOutButton = driver.findElement(By.linkText("Not "+GlobalFirstName+"? Logoff"));
		LogOutButton.click();
//		String LogOutURL= "https://automationteststore.com/index.php?rt=account/logout";
//		driver.get(LogOutURL);

}
	@Test (priority =3 , enabled = false )
	public void logIn() throws InterruptedException {
		System.out.println(GlobalUserName);
		driver.findElement(By.partialLinkText("Login or register")).click();
		WebElement LoginInput = driver.findElement(By.id("loginFrm_loginname"));
		LoginInput.sendKeys(GlobalUserName);
		Thread.sleep(5000);
		WebElement PasswordInput = driver.findElement(By.id("loginFrm_password"));
		PasswordInput.sendKeys(GlobalPassword);
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@title ='Login']"));
		loginButton.click();
}
	
	@Test (priority = 4)
	public void AddItemToTheCart() throws InterruptedException
{
	String [] WebSiteForTheItems = {"https://automationteststore.com/index.php?rt=product/category&path=68",
			"https://automationteststore.com/index.php?rt=product/category&path=36",
			"https://automationteststore.com/index.php?rt=product/category&path=43",
			"https://automationteststore.com/index.php?rt=product/category&path=49",
			"https://automationteststore.com/index.php?rt=product/category&path=58",
			"https://automationteststore.com/index.php?rt=product/category&path=52",
			"https://automationteststore.com/index.php?rt=product/category&path=65"};
	 int randomIndex = rand.nextInt(WebSiteForTheItems.length);
	 driver.get(WebSiteForTheItems[randomIndex]);
	 
	 WebElement ListOfItems = driver.findElement(By.cssSelector(".thumbnails.row"));
	 int TotalNumberOfItems = ListOfItems.findElements(By.tagName("li")).size();
	 
	 int randomIndexForTheItem = rand.nextInt(TotalNumberOfItems);
	 Thread.sleep(3000);
	 ListOfItems.findElements(By.tagName("li")).get(randomIndexForTheItem).click();
	 WebElement container = driver.findElement(By.className("contentpanel"));
	 //WebElement container = driver.findElement(By.cssSelector(".thumbnails.grid.row.list-inline"));
	 
	 int NumberOfProduct = container.findElements(By.cssSelector(".col-md-3.col-sm-6.col-xs-12")).size();
	 int randomIndexForTheProduct = rand.nextInt(NumberOfProduct);
	 container.findElements(By.cssSelector(".col-md-3.col-sm-6.col-xs-12")).get(randomIndexForTheProduct).click();
	Thread.sleep(5000);;
	WebElement UlList = driver.findElement(By.className("productpagecart"));
	int LiList = UlList.findElements(By.tagName("li")).get(0).findElements(By.tagName("a")).size();
	
	if (LiList>0) {
		
		driver.findElement(By.className("cart")).click();
		Thread.sleep(5000);
		String ActualValue = driver.findElement(By.className("heading1")).getText();
		String ExpectedValue = "Shopping Cart";
		boolean actualValueForCheck = driver.findElement(By.id("cart_checkout1")).isDisplayed();
		boolean expectedValueForCheck = true;
		assertEquals(actualValueForCheck, expectedValueForCheck,"hi");
	
		assertEquals(ActualValue, ExpectedValue.toUpperCase());
		
	} else {
	driver.get(WebSiteURL);
		
		System.out.println("out of the stock");
		String ExpectedValue= "https://automationteststore.com/";
		String ActualValue = driver.getCurrentUrl();
		assertEquals(ActualValue,ExpectedValue);
	
		
	}
	}
		
}
