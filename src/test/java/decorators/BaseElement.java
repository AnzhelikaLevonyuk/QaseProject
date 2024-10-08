package decorators;

import org.openqa.selenium.*;

import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseElement  implements WebElement {
    protected String label;
    protected WebElement element;
    public BaseElement(String label){
        this.label = label;
        this.element = getWebDriver().findElement(By.xpath(String.format("//label[text()='%s']/..//span", this.label)));
    }
    public void scrollIntoView() {
        ((JavascriptExecutor) getWebDriver()).
                executeScript("arguments[0].scrollIntoView(true);", this.element);
    }
    @Override
    public void click() {
        try {
            this.element.click();
        } catch (ElementNotInteractableException e){
            scrollIntoView();
            this.element.click();
        }
    }

    @Override
    public void submit() {
        this.element.submit();

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        element.clear();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return element.getLocation();
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public Rectangle getRect() {
        return element.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return element.getScreenshotAs(target);
    }
}
