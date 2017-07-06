package zalando.assignment.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sneha.rao on 7/3/2017.
 */
public class JobsPage extends BasePage{



    @FindBy(how=How.CSS,using = "[class='input jobtype-input']")
    private WebElement roleSpecifierTextBox;

    @FindBy(how=How.CSS, using = "[class='input location-input']")
    private WebElement locationDropDownBox;

    @FindBy( how = How.CSS,  using= "[class='job-search__button button -background-orange -size-large']")
    private WebElement searchButton;

    private  WebDriver driver;



    public JobsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    public JobsPage selectLocation(String location) throws InterruptedException {
        waitForElement(searchButton);
        Select select = new Select(locationDropDownBox);
        select.selectByVisibleText(location);
        return this;
    }

    public ResultPage clickSearchButton() throws InterruptedException {
        searchButton.click();
        Thread.sleep(2000);
        return new ResultPage(driver);
    }

    public JobsPage enterRoleText(String roleText) throws InterruptedException { //Thread.sleep can be used for slower execution
        roleSpecifierTextBox.clear();
        roleSpecifierTextBox.sendKeys(roleText);
        return this;
    }
}
