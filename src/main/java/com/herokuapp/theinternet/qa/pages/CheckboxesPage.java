package com.herokuapp.theinternet.qa.pages;

import com.herokuapp.theinternet.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxesPage extends TestBase
{

    @FindAll(@FindBy(xpath="//input[@type = 'checkbox']"))
    List<WebElement> _checkBoxes;

    public CheckboxesPage() { PageFactory.initElements(webDriver,this); }

    public void selectAllCheckboxes()
    {
        for(WebElement _checkbox : _checkBoxes )
        {
            if(!_checkbox.isSelected())
                _checkbox.click();
        }
    }

    public boolean areAllCheckboxesSelected()
    {
        for(WebElement _checkbox : _checkBoxes )
        {
            if(!_checkbox.isSelected())
                return false;
        }
        return true;
    }
}
