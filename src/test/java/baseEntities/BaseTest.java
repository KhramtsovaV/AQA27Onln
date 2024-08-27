package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.BrowsersService;
import steps.AddRemoveSteps;
import steps.LoginSteps;
import steps.OrderSteps;
import utils.InvokedListener;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected LoginSteps loginStep;
    protected AddRemoveSteps addRemoveStep;
    protected OrderSteps orderSteps;


    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        iTestContext.setAttribute("webdriver",driver);

        loginStep = new LoginSteps(driver);
        addRemoveStep = new AddRemoveSteps(driver);
        orderSteps = new OrderSteps(driver);

        driver.get(ReadProperties.getUrl());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
