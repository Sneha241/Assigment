package zalando.assignment.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.image.ImagingOpException;
import java.util.List;
/**
 * Created by sneha.rao on 7/3/2017.
 */
public class ResultPage  extends BasePage{

    @FindBy(how=How.CSS, using = "[class='button -layout-block -color-orange']")
    private WebElement filterJobsButton;


    @FindBy(how = How.CSS, using = "[class='multi-select search-filters-contractTypes'] > li:nth-child(2) ")
    private WebElement checkFullTime;

   @FindAll(@FindBy(how = How.CSS, using = "[class='card--job-result__title']"))
   private List<WebElement> jobTitles;


    @FindAll(@FindBy(how = How.CSS, using = "[class='card--job-result__categories-container']"))
    private List<WebElement> jobCategory;


    @FindAll(@FindBy(how = How.CSS, using = "[class='card--job-result__locations-container']"))
    private List<WebElement> jobLocation;



    private  String jobCategoryOfSelectedDescription;
    private String  jobLocationOfSelectedDescription;





    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    public ResultPage clickFilterJobs() throws InterruptedException {

        waitForElement(filterJobsButton);
        Actions actions = new Actions (driver);
        actions.moveToElement(filterJobsButton).click().perform();
        return this;
    }

    public ResultPage checkContractType() throws InterruptedException{
            checkFullTime.click();
            Thread.sleep(2000);
            return this;
        }





    public Boolean isJobDescriptionAvailable(String jobDescription)
    {
        boolean flag = false;
        for(int i=0; i<jobTitles.size();i++)
        {
            if(jobTitles.get(i).getText().equalsIgnoreCase(jobDescription))
            {
                flag=true;
                break;
            }

        }
       return flag;
    }


    public String getJobCategoryForTheDesiredRole(String jobDescription)
    {

        for(int i=0; i< jobTitles.size();i++)
        {
            if(jobTitles.get(i).getText().equalsIgnoreCase(jobDescription))
            {

                jobCategoryOfSelectedDescription = jobCategory.get(i).getText();
                break;
            }
        }
        return jobCategoryOfSelectedDescription;
    }

    public String getJoblocationForTheDesiredRole(String jobDescription)
    {
        for(int i=0; i< jobTitles.size();i++)
        {
            if(jobTitles.get(i).getText().equalsIgnoreCase(jobDescription))
            {
                jobLocationOfSelectedDescription = jobLocation.get(i).getText();
                break;
            }
        }
        return jobLocationOfSelectedDescription;


    }

}



