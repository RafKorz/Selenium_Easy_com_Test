import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Tests
{
    private WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafal\\Desktop\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.seleniumeasy.com/test/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void titleTest()
    {
        Assert.assertEquals(driver.getTitle(), "Selenium Easy - Best Demo website to practice Selenium Webdriver Online");
    }

    @Test
    public void listTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"at-cv-lightbox-close\"]"))));
        driver.findElement(By.xpath("//*[@id=\"at-cv-lightbox-close\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/a")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/ul/li[1]/a")));
        driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/ul/li[1]/a")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/a")));
//        new Select(driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/a"))).selectByIndex(0);
        Assert.assertEquals(true, verifyElementPresent(driver, By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/a")));
    }

    public static boolean verifyElementPresent(WebDriver driver, By by)
    {
        try{
            driver.findElement(by);
            System.out.println("Element found");
            return true;
        }
        catch (NoSuchElementException e){
            System.out.println("Element not found");
            return false;
        }
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
