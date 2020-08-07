package com.herokuapp.theinternet.qa.pages;

import com.herokuapp.theinternet.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends TestBase
{
    @FindBy(id = "dropdown")
    WebElement _dropdown;

    public DropDownPage() { PageFactory.initElements(webDriver,this); }

    public void selectOptionByIndex(int _index)
    {
        Select _select = new Select(_dropdown);

        _select.selectByIndex(_index);
    }

    public String getSelectedOption()
    {
        Select _select = new Select(_dropdown);

        return _select.getFirstSelectedOption().getText();
    }
}
