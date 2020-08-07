package com.herokuapp.theinternet.qa.qa.tests;

import com.herokuapp.theinternet.qa.base.TestBase;
import com.herokuapp.theinternet.qa.pages.KeyPressesPage;
import com.herokuapp.theinternet.qa.pages.WelcomePage;
import com.herokuapp.theinternet.qa.util.TestUtil;

import org.openqa.selenium.Keys;

import org.testng.Assert;
import org.testng.annotations.*;

public class KeyPressesPageTests extends TestBase
{
    private KeyPressesPage _keyPressesPage;

    //-------------------------------------------------------------------------
    @BeforeMethod
    public void Setup()
    {
        WelcomePage _welcomePage = new WelcomePage();
        _keyPressesPage = _welcomePage.goToKeyPressesPage();
    }

    //-------------------------------------------------------------------------

    @Test(dataProvider = "listOfAllKeys")
    public void user_should_see_last_pressed_key_input(Keys _pressedKey)
    {
        TestUtil.pressKey(_pressedKey);
        String _expectedMsg = "You entered: " + _pressedKey.name();

        String _actualMsg = _keyPressesPage.getPressedKeyInfo();
        Assert.assertEquals(_actualMsg,_expectedMsg);
    }

    @DataProvider(name = "listOfAllKeys")
    private Object[] getListOfAllKeys() { return Keys.values(); }
}
