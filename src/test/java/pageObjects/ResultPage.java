package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ResultPage {
	WebDriver driver;
	By getTitle;
	By getPublish;
	By getPaperback;
	By getHardcover;
	By getKindleEdition;
	By getPaperbackINR;
	By getHardcoverINR;
	By getKindleEditionINR;
	
	public ResultPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void listNumber(int num) throws Exception {
		getTitle = By.xpath("//*[@id='s-results-list-atf']//li["+num+"]//h2");
		getPublish = By.xpath("//*[@id='s-results-list-atf']//li["+num+"]//span[contains(text(),'by')]/following-sibling::span");
		getPaperback = By.xpath("//*[@id='s-results-list-atf']//li["+num+"]//h3[@data-attribute = 'Paperback']");
		getHardcover = By.xpath("//*[@id='s-results-list-atf']//li["+num+"]//h3[@data-attribute = 'Hardcover']");
		getKindleEdition = By.xpath("//*[@id='s-results-list-atf']//li["+num+"]//h3[@data-attribute = 'Kindle Edition']");
		getPaperbackINR = By.xpath("//*[@id='s-results-list-atf']//li["+num+"]//h3[@data-attribute = 'Paperback']/parent::a/parent::div/following-sibling::div//span[2]");
		getHardcoverINR = By.xpath("//*[@id='s-results-list-atf']//li["+num+"]//h3[@data-attribute = 'Hardcover']/parent::a/parent::div/following-sibling::div//span[2]");
		getKindleEditionINR = By.xpath("//*[@id='s-results-list-atf']//li["+num+"]//h3[@data-attribute = 'Kindle Edition']/parent::a/parent::div/following-sibling::div//span[2]");
	}
	
	public String getBookTitle() {
		try {
			Assert.assertEquals(true, driver.findElement(getTitle).isDisplayed());
			WebElement get = driver.findElement(getTitle);
			String getValue = get.getText();
			return getValue;
		}
		catch(NoSuchElementException e) {
			return "No Result found";
		}
	}
	public String getBookPublish() {
		try {
			Assert.assertEquals(true, driver.findElement(getPublish).isDisplayed());
			WebElement get = driver.findElement(getPublish);
			String getValue = get.getText();
			return getValue;
		}
		catch(NoSuchElementException e) {
			return "No Result found";
		}
	}
	public String getBookPaperback() {
		try {
			Assert.assertEquals(true, driver.findElement(getPaperback).isDisplayed());
			WebElement get = driver.findElement(getPaperback);
			String getValue = get.getText();
			return getValue + " Available";
		}
		catch(NoSuchElementException e) {
			return "No Result found";
		}
	}
	public String getBookHardcover() {
		try {
			Assert.assertEquals(true, driver.findElement(getHardcover).isDisplayed());
			WebElement get = driver.findElement(getHardcover);
			String getValue = get.getText();
			return getValue + " Available";
		}
		catch(NoSuchElementException e) {
			return "No Result found";
		}
	}
	public String getBookKindleEdition() {
		try {
			Assert.assertEquals(true, driver.findElement(getKindleEdition).isDisplayed());
			WebElement get = driver.findElement(getKindleEdition);
			String getValue = get.getText();
			return getValue + " Available";
		}
		catch(NoSuchElementException e) {
			return "No Result found";
		}
	}
	public String getBookPaperbackINR() {
		try {
			Assert.assertEquals(true, driver.findElement(getPaperbackINR).isDisplayed());
			WebElement get = driver.findElement(getPaperbackINR);
			String getValue = get.getText();
			return getValue;
		}
		catch(NoSuchElementException e) {
			return "No Result found";
		}
	}
	public String getBookHardcoverINR() {
		try {
			Assert.assertEquals(true, driver.findElement(getHardcoverINR).isDisplayed());
			WebElement get = driver.findElement(getHardcoverINR);
			String getValue = get.getText();
			return getValue;
		}
		catch(NoSuchElementException e) {
			return "No Result found";
		}
	}
	public String getBookKindleEditionINR() {
		try {
			Assert.assertEquals(true, driver.findElement(getKindleEditionINR).isDisplayed());
			WebElement get = driver.findElement(getKindleEditionINR);
			String getValue = get.getText();
			return getValue;
		}
		catch(NoSuchElementException e) {
			return "No Result found";
		}
	}
}
