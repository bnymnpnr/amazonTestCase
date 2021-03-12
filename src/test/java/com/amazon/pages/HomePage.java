package com.amazon.pages;

import com.amazon.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "#searchDropdownBox")
    public WebElement searchDropdownBox;

    @FindBy(xpath = "//option[contains(text(), 'Books')]")
    public WebElement books;

    @FindBy(css = "#twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(css = "#nav-search-submit-button")
    public WebElement searchBoxButton;

    @FindBy(className = "a-badge-text")
    public WebElement isBestSeller;

    @FindBy(xpath = "(//a[@class='a-size-base a-link-normal a-text-bold'])[2]")
    public WebElement isKindleEditionFormat;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
    public WebElement clickBook;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToChartButton;

    @FindBy(id = "hlb-ptc-btn")
    public WebElement proceedBtn;

    @FindBy(id = "createAccountSubmit")
    public WebElement createAccount;

    @FindBy(id = "sp-cc-accept")
    public WebElement acceptCookies;

    @FindBy(id = "ap_customer_name")
    public WebElement yourNameBox;

    @FindBy(id = "ap_email")
    public WebElement emailBox;

    @FindBy(id = "ap_password")
    public WebElement passBox;

    @FindBy(id = "ap_password_check")
    public WebElement rePassBox;

    @FindBy(id = "a-autoid-0")
    public WebElement LastCreateAccountBtn;


    public int getSearchResult() {
        String searchResultAsString = Driver.get().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]")).getText();
        String[] searchResultArr = searchResultAsString.split("of");
        String[] searchResultArr1 = searchResultArr[1].split("results");
        String strRes = searchResultArr1[0].trim();
        int result = Integer.parseInt(strRes);
        return result;

    }

}
