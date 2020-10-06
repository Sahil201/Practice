import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JavaClass {
     public WebDriver driver;
    @Before
    public void setUp(){
        //open browser method
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver=new ChromeDriver();

        driver.manage().window().maximize(); // maximize browser
        driver.get("http://automationpractice.com/index.php"); // launch url
        driver.manage().deleteAllCookies(); //delete cookies
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // imp waits
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS); // pageload timeouts
    }
    @Test
    public void createAnAccount(){
        // validate user on home page
        String title = driver.getTitle();
        Assert.assertEquals(title,"My Store");

        driver.findElement(By.className("login")).click(); // click on signin button
        String authTitle =driver.findElement(By.className("page-heading")).getText();
        Assert.assertEquals(authTitle,"AUTHENTICATION");//validate user on  Anthentication page

        driver.findElement(By.id("email_create")).sendKeys("test124@gmail.com");
        driver.findElement(By.id("SubmitCreate")).click();

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
