package zalando.assignment.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sneha.rao on 7/5/2017.
 */
public class BasePage {

    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }


    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void scrollDownwards() throws InterruptedException {

       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("javascript:window.scrollBy(250,350)");
       Thread.sleep(2000);
    }
}
