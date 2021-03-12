package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
    public CreateAccountPage() {
        PageFactory.initElements(Driver.get(), this);
    }

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

}
