package zalando.assignment.tests;
import org.apache.commons.lang3.SystemUtils;
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
 * Created by sneha.rao on 7/4/2017.
 */
public class Test2 {
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
    public void test2() throws InterruptedException {
        driver.navigate().to("https://jobs.zalando.com/");
        JobsPage jobsPage = new JobsPage(driver);
        ResultPage resultPage=  jobsPage.selectLocation("Berlin").enterRoleText("Frontend Engineer").clickSearchButton().clickFilterJobs().checkContractType();
        Assert.assertFalse(resultPage.isJobDescriptionAvailable("Frontend Engineer"));

    }


    @AfterTest(alwaysRun = true)
    public void clean()
    {
        driver.quit();
    }

}
