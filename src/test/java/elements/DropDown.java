package elements;

import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.WaitsService;

import java.util.ArrayList;
import java.util.List;

public class DropDown {
    private UIElement uiElement;
    private UIElement actionElement;
    private UIElement optionsElement;
    private WaitsService waitsService;
    private List<UIElement> optionsList = new ArrayList<>();

    public DropDown(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
        this.actionElement = uiElement.findUIElement(By.tagName("a"));
        this.optionsElement = uiElement.findUIElement(By.className("chzn-drop"));
        waitsService = new WaitsService(driver);
    }

    private void openDropDown() {
        actionElement.click();
        waitsService.waitVisibilityOf(optionsElement);
        optionsList.addAll(uiElement.findUIElements(By.tagName("li")));
    }

    public void selectByText(String text) {
        openDropDown();
        for (UIElement element : optionsList) {
            if (element.getText().equals(text)) {
                element.click();
                return;
            }
        }

        throw new IllegalArgumentException("Option with the specified text does not exist");
    }

    public void selectByIndex(int index) {
        openDropDown();
        if (index >= 0 && index < optionsList.size()) {
            optionsList.get(index).click();
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }
}
