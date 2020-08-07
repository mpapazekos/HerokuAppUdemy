package com.herokuapp.theinternet.qa.pages;

import com.herokuapp.theinternet.qa.base.TestBase;

import com.herokuapp.theinternet.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WelcomePage extends TestBase
{
    @FindAll(@FindBy(xpath="//a"))
    List<WebElement> _pageLinks;

    //-------------------------------------------------------------------------
    public WelcomePage() { PageFactory.initElements(webDriver, this); }

    //-------------------------------------------------------------------------
    public FormAuthPage goToFormAuthPage() {
        TestUtil.clickOnPageLink(_pageLinks, "/login");
        return new FormAuthPage();
    }

    public CheckboxesPage goToCheckboxesPage() {
        TestUtil.clickOnPageLink(_pageLinks, "/checkboxes");
        return new CheckboxesPage();
    }

    public DropDownPage goToDropDownPage() {
        TestUtil.clickOnPageLink(_pageLinks, "/dropdown");
        return new DropDownPage();
    }

    public JSAlertsPage goToJSAlertsPage() {
        TestUtil.clickOnPageLink(_pageLinks, "/javascript_alerts");
        return new JSAlertsPage();
    }

    public MultipleWindowsPage goToMultipleWindowsPage() {
        TestUtil.clickOnPageLink(_pageLinks, "/windows");
        return new MultipleWindowsPage();
    }

    public WYSIWYGEditorPage goToWYSIWYGEditorPage() {
        TestUtil.clickOnPageLink(_pageLinks, "/tinymce");
        return new WYSIWYGEditorPage();
    }

    public KeyPressesPage goToKeyPressesPage() {
        TestUtil.clickOnPageLink(_pageLinks, "/key_presses");
        return new KeyPressesPage();
    }

    public FileUploadPage goToFileUploadPage() {
        TestUtil.clickOnPageLink(_pageLinks, "/upload");
        return new FileUploadPage();
    }
}
