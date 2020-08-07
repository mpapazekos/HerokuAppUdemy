package com.herokuapp.theinternet.qa.qa.tests;

import com.herokuapp.theinternet.qa.base.TestBase;
import com.herokuapp.theinternet.qa.pages.WYSIWYGEditorPage;
import com.herokuapp.theinternet.qa.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WYSIWYGEditorPageTests extends TestBase
{
    private WYSIWYGEditorPage _wysiwygEditorPage;

    @BeforeMethod
    public void SetUp()
    {
        WelcomePage _welcomePage = new WelcomePage();
        _wysiwygEditorPage = _welcomePage.goToWYSIWYGEditorPage();
    }

    @Test
    public void user_should_get_exactly_what_was_typed_in_editor()
    {
        String _typedMsg = "This is a Test Message &*&*(%&$*(#&% I just tried to Ypte 1123!)_($)_!@_!(_%*+!_%*";
        _wysiwygEditorPage.typeIntoTextEditor(_typedMsg);

        String _msgInEditor = _wysiwygEditorPage.getEditorText();
        Assert.assertEquals(_msgInEditor,_typedMsg);
    }
}
