package com.herokuapp.theinternet.qa.pages;

import com.herokuapp.theinternet.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewWindowPage extends TestBase
{
    @FindBy(xpath="//h3")
    WebElement _mainHeader;

    public NewWindowPage() { PageFactory.initElements(webDriver,this); }

    public String getMainHeaderText(){ return _mainHeader.getText(); }
}
