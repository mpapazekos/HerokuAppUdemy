package com.herokuapp.theinternet.qa.qa.tests;

import com.herokuapp.theinternet.qa.base.TestBase;
import com.herokuapp.theinternet.qa.pages.JSAlertsPage;
import com.herokuapp.theinternet.qa.pages.WelcomePage;
import com.herokuapp.theinternet.qa.util.CsvDataProvider;
import com.herokuapp.theinternet.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class JSAlertsPageTests extends TestBase
{
    private JSAlertsPage _jsAlertsPage;

    @BeforeMethod
    public void SetUp()
    {
        WelcomePage _welcomePage = new WelcomePage();
        _jsAlertsPage = _welcomePage.goToJSAlertsPage();
    }

    @Test
    public void  user_should_be_able_to_click_on_a_simple_alert()
    {
        _jsAlertsPage.clickOnSimpleJSAlert();
        TestUtil.acceptCurrentAlert(true);

        String _result = _jsAlertsPage.getAlertResultText();
        Assert.assertEquals(_result,"You successfuly clicked an alert","Wrong alert message, found instead: " + "{ "+ _result + " }");
    }

    @Test(dataProvider = "csvReader", dataProviderClass = CsvDataProvider.class)
    public void user_should_be_able_to_interact_with_confirmation_alert(Map<String,String> _testData)
    {
        String _accepted = _testData.get("accepted");
        String _expectedMsg = _testData.get("expectedMessage");

        boolean _choice = _accepted.equalsIgnoreCase("yes");

        _jsAlertsPage.clickOnJSConfirmAlert();

        TestUtil.acceptCurrentAlert(_choice);

        String _result = _jsAlertsPage.getAlertResultText();
        Assert.assertEquals(_result,_expectedMsg);
    }

    @Test
    public void user_should_see_what_was_typed_in_alert_prompt()
    {
        // Given User clicks on alert prompt button
        _jsAlertsPage.clickOnJSPromptAlert();

        // And User types something in the prompt field shown
        String _message = "test message";
        _jsAlertsPage.typeIntoAlertPromptMsg(_message);

        // When User accepts or denies the alert
        TestUtil.acceptCurrentAlert(true);

        //Then User should see the appropriate message
        String _result = _jsAlertsPage.getAlertResultText();
        Assert.assertEquals(_result,"You entered: " + _message,"Wrong message: ");
    }
}
