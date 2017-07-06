package zalando.assignment.tests;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import zalando.assignment.pageobjects.JobsPage;
import zalando.assignment.pageobjects.ResultPage;

import java.io.File;
import java.io.IOException;

/**
 * Created by sneha.rao on 7/3/2017.
 */
public class  Test1{
    private static WebDriver driver;
    private DesiredCapabilities capabilities;



@BeforeTest
    public void setUp()
{
    if (SystemUtils.IS_OS_WINDOWS){

        System.setProperty("webdriver.chrome.driver", "drivers/windows/chromedriver.exe");
        capabilities = DesiredCapabilities.chrome();
        driver = new ChromeDriver(capabilities);

    }


    else if (SystemUtils.IS_OS_LINUX)
    {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "drivers/linux/chromedriver");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("drivers/linux/chromedriver"))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        options.addArguments("--incognito","--disable-extensions");
        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);

        driver = new ChromeDriver(capabilities);


    }

}


@Test
    public void test1()  throws InterruptedException {
    driver.navigate().to("https://jobs.zalando.com/");      //Takes user to this URL
    JobsPage jobsPage = new JobsPage(driver);
    ResultPage resultPage=  jobsPage.selectLocation("Berlin").enterRoleText("Test Analyst").clickSearchButton().clickFilterJobs().checkContractType();
    jobsPage.scrollDownwards();
    Assert.assertTrue(resultPage.isJobDescriptionAvailable("Test Analyst for External Applications")); //checks if it is present
    Assert.assertEquals(resultPage.getJobCategoryForTheDesiredRole("Test Analyst for External Applications"),"Technology & UX/UI Design");
    Assert.assertEquals(resultPage.getJoblocationForTheDesiredRole("Test Analyst for External Applications"), "Berlin");

}


@AfterTest()
    public void clean()
{
    driver.quit();
}

}
