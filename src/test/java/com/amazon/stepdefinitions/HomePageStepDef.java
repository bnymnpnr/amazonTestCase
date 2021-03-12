package com.amazon.stepdefinitions;

import com.amazon.pages.CreateAccountPage;
import com.amazon.pages.HomePage;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class HomePageStepDef {

    @When("user Navigate to Amazon Website")
    public void userNavigateToAmazonWebsite() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Driver.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Then("Users should be able to select Books options from drop down")
    public void users_should_be_able_to_select_book_options_from_drop_down() throws InterruptedException {
        HomePage homePage = new HomePage();
        Thread.sleep(3000);
        homePage.acceptCookies.click();
        homePage.searchDropdownBox.click();
        homePage.books.click();
        Thread.sleep(2000);
    }

    @Then("search for the book named Harry Potter and the Philosopher's Stone")
    public void search_for_the_book_named_Harry_Potter_and_the_Philosopher_s_Stone() throws InterruptedException {
        
        HomePage homePage = new HomePage();
        homePage.searchBox.sendKeys("Harry Potter and the Philosopher's Stone");
        Thread.sleep(2000);
        homePage.searchBoxButton.click();
        Thread.sleep(2000);
    }


    @And("Check if Book is a Best Seller or Not")
    public void checkIfBookIsABestSellerOrNot() {
        HomePage homePage = new HomePage();
        String actual = homePage.isBestSeller.getText();
        System.out.println("actual = " + actual);
        String expected = "Best Seller";
        Assert.assertEquals("Book is Best Seller verify",expected,actual);
    }

    @And("Verify other author and book related information from the search page")
    public void verifyOtherAuthorAndBookRelatedInformationFromTheSearchPage() {
        HomePage homePage = new HomePage();
        int actual = homePage.getSearchResult();
        Assert.assertTrue(actual>1);
        System.out.println("actual = " + actual);
    }

    @And("Check if Book is available in the format of an Kindle Edition")
    public void checkIfBookIsAvailableInTheFormatOfAnKindleEdition() throws InterruptedException {
        HomePage homePage = new HomePage();
        Thread.sleep(3000);
        String actual = homePage.isKindleEditionFormat.getText();
        Assert.assertEquals(" Kindle Edition verify","Kindle Edition", actual);
        System.out.println("actual = " + actual);
    }

    @Then("Select the book and proceed towards Check Out")
    public void selectTheBookAndProceedTowardsCheckOut() {
        HomePage homePage = new HomePage();
        homePage.clickBook.click();

        homePage.addToChartButton.click();

        homePage.proceedBtn.click();

        homePage.createAccount.click();

    }

    @And("Select Create Your Amazon Account and verify all fields")
    public void selectCreateYourAmazonAccountAndVerifyAllFields() {
        CreateAccountPage createAccountPage = new CreateAccountPage();
        createAccountPage.yourNameBox.sendKeys("Benjamin Pinar");
        createAccountPage.emailBox.sendKeys("bunyamin_pinar@gmail.com");
        createAccountPage.passBox.sendKeys("weeE.115665");
        createAccountPage.rePassBox.sendKeys("weeE.115665");
        //createAccountPage.LastCreateAccountBtn.click();
    }
}
