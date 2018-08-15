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
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}
	public void searchCatalog(String value) {
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		Select select = new Select(driver.findElement(selectList));
		select.selectByVisibleText(value);
	}
	public void searchBox(String search) {
		driver.findElement(searchInput).sendKeys(search);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}
}
