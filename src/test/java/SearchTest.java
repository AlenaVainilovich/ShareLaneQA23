import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchTest {

    @Test
    public void searchBookByName() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=56987&first_name=John&last_name=Doe" +
                "&email=sharelane%40gmail.com&password1=12345678&password2=12345678");
        String email = driver.findElement(By.xpath("//*[contains(text(), 'Email')]/..//b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("keyword")).sendKeys("The Alchemist");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        boolean foundedBook = driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/p[2]/a/img")).isDisplayed();
        Assert.assertTrue(foundedBook);
        driver.quit();
    }

    @Test
    public void searchBookByAuthor() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=56987&first_name=John&last_name=Doe" +
                "&email=sharelane%40gmail.com&password1=12345678&password2=12345678");
        String email = driver.findElement(By.xpath("//*[contains(text(), 'Email')]/..//b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("keyword")).sendKeys("Mark Twain");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        boolean foundedBook = driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/p[2]/a/img")).isDisplayed();
        Assert.assertTrue(foundedBook);
        driver.quit();
    }
}



