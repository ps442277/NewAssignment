package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Homepage {
	WebDriver driver;
	By selectList = By.id("searchDropdownBox");
	By searchInput = By.id("twotabsearchtextbox");
	//Constructor for accessing the Driver class
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}
	//For filtering the Category
	public void searchCatalog(String value) {
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		Select select = new Select(driver.findElement(selectList));
		select.selectByVisibleText(value);
	}
	//For searching the result via input parameter
	public void searchBox(String search) {
		driver.findElement(searchInput).sendKeys(search);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}
}
