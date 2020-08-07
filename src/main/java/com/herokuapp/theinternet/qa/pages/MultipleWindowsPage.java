package com.herokuapp.theinternet.qa.pages;

import com.herokuapp.theinternet.qa.base.TestBase;
import com.herokuapp.theinternet.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MultipleWindowsPage extends TestBase
{
    @FindAll(@FindBy(xpath="//a"))
    List<WebElement> _pageLinks;

    public MultipleWindowsPage() { PageFactory.initElements(webDriver,this); }

    public void clickOnNewWindowLink() { TestUtil.clickOnPageLink(_pageLinks,"/windows/new"); }

    public NewWindowPage switchToNewWindowPage()
    {
        TestUtil.switchToTab("New Window");
        return new NewWindowPage();
    }

}
