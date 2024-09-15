package pages.projects;

import elements.Button;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProjectPage extends BaseProjectPage {
    private final static String pagePath = "/index.php?/admin/projects/add/1";
    private final By ADD_PROJECT_BUTTON_LOCATOR = By.id("accept");
    private final By PROJECT_TYPE_RADIO_BUTTON_LOCATOR = By.cssSelector("[name='suite_mode']");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    public Button getAddProjectButton() {
        return new Button(driver, ADD_PROJECT_BUTTON_LOCATOR);
    }

    public RadioButton getProjectTypeRadioButton() {
        return new RadioButton(driver, PROJECT_TYPE_RADIO_BUTTON_LOCATOR);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

}