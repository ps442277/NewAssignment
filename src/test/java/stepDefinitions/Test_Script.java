package stepDefinitions;
import utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import pageObjects.*;
import utils.ExcelData;
public class Test_Script implements Constants{
	WebDriver driver;
	Homepage amazonHome;
	ResultPage amazonResult;
	
	@Given("^User is on Homepage \"(.*)\"$")
	public void user_is_on_Search_result_page(String url) throws Throwable {
		System.setProperty(Constants.driverName, Constants.driverPath);
		ExcelData.setExcelFile(excelPath+excelName, sheetName);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@When("^User Filter \"(.*)\" and search for \"(.*)\"$")
	public void user_filter_category_and_search_for(String category, String input) throws Throwable {
		  amazonHome = new Homepage(driver);
		  amazonHome.searchCatalog(category);
		  amazonHome.searchBox(input);
	}

	@When("^Choose the \"(.*)\" product from the list$")
	public void choose_the_First_product_from_the_list(int iList) throws Throwable,Exception {
		amazonResult = new ResultPage(driver);
		amazonResult.listNumber(iList);
	}
	@Then("^Get required information from the product into \"(.*)\" row$")
	public void get_required_information_from_the_product(int i) throws Throwable {
		  ExcelData.setCellData(amazonResult.getBookTitle(),i,0);
		  ExcelData.setCellData(amazonResult.getBookPublish(),i,1);
		  ExcelData.setCellData(amazonResult.getBookHardcover(),i,2);
		  ExcelData.setCellData(amazonResult.getBookHardcoverINR(),i,3);
		  ExcelData.setCellData(amazonResult.getBookPaperback(),i,4);
		  ExcelData.setCellData(amazonResult.getBookPaperbackINR(),i,5);
		  ExcelData.setCellData(amazonResult.getBookKindleEdition(),i,6);
		  ExcelData.setCellData(amazonResult.getBookKindleEditionINR(),i,7);
		  ExcelData.setCellData("Passed",i,8);
		  driver.close();
	}
}
