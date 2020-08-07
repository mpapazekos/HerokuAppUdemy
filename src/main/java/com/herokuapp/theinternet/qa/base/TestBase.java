package com.herokuapp.theinternet.qa.base;

import com.herokuapp.theinternet.qa.util.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class TestBase
{
    public static final String _propertiesFilePath = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "main"
            + File.separator + "java"
            + File.separator + "com"
            + File.separator + "herokuapp"
            + File.separator + "theinternet"
            + File.separator + "qa"
            + File.separator + "config"
            + File.separator + "config.properties";


    protected static Logger logger;
    protected static WebDriver webDriver ;
    protected static Properties properties;
    protected static WebDriverWait webDriverWait;
    protected static Actions interactWithCurrentPage;

    //-------------------------------------------------------------------------
    public TestBase()
    {
      try
      {
          properties = new Properties();
          FileInputStream inputStream = new FileInputStream(_propertiesFilePath);
          properties.load(inputStream);
      }
      catch(IOException ioException) { ioException.printStackTrace(); }
    }

    //-------------------------------------------------------------------------

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void initializeUpWebDriver(@Optional("firefox") String _browser, ITestContext _testContext)
    {
        if(_browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        else if (_browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }
        else if(_browser.equalsIgnoreCase("opera"))
        {
            WebDriverManager.operadriver().setup();
            webDriver = new OperaDriver();
        }
        else if(_browser.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }

        webDriverWait = new WebDriverWait(webDriver, TestUtil.EXPLICIT_WAIT);
        interactWithCurrentPage = new Actions(webDriver);

        String _callingClass = _testContext.getCurrentXmlTest().getName();
        logger = LogManager.getLogger(_callingClass);

        configWebDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownWebDriver() { webDriver.quit();}


    private void configWebDriver()
    {
        String baseUrl = properties.getProperty("url");

        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        //webDriver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        webDriver.get(baseUrl);
    }
}
