package com.herokuapp.theinternet.qa.pages;

import com.herokuapp.theinternet.qa.base.TestBase;
import com.herokuapp.theinternet.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WYSIWYGEditorPage extends TestBase
{
    @FindBy(id="tinymce")
    WebElement _textEditor;

    @FindBy(id="mce_0_ifr")
    WebElement _iframeWithEditor;

    public WYSIWYGEditorPage() { PageFactory.initElements(webDriver,this); }

    public String getEditorText()
    {
        return _textEditor.getText();
    }

    public void typeIntoTextEditor(String _toType)
    {
        TestUtil.switchToFrame(_iframeWithEditor);
        _textEditor.clear();
        _textEditor.sendKeys(_toType);
    }


}
