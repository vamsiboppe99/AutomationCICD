package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import rahulshettyacademy.AbstractComponents.AbstractComponents;


public class OrderPage extends AbstractComponents {
	WebDriver driver;

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> productNamesInTheTable;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public Boolean VerifyOrderDisplay(String productName) {
		Boolean match = productNamesInTheTable.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;

	}

}