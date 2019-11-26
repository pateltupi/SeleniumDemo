import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utilities;

import java.util.concurrent.TimeUnit;


public class ChromeDriverDemo {

    private WebDriver driver;
    Utilities utilities;

    @Before
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "/Users/surajbharmal/IdeaProjects/seleniumdemo/driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utilities = new Utilities(driver);
    }

       @Test
               public void userShouldLoginSucceFully(){
        //loginLink click

        By loginLink = By.linkText("Log in");
        utilities.clickonElement(loginLink);

        //Find element of emailfield
        utilities.sendTextToElement(By.id("Email"),"ttp123@gmail.com");

        //find element of password
        utilities.sendTextToElement(By.name("Password"),"Abc123");

        //Find element of login buttonand click on login button
        utilities.clickonElement(By.xpath("//input[@value='Log in']"));


       }

        @After
                public void tearDown(){
            driver.quit();
        }










//        public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver","/Users/surajbharmal/IdeaProjects/seleniumdemo/driver/chromedriver");
//        WebDriver driver=new ChromeDriver();
//
//        driver.get("https://demo.nopcommerce.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        //find element of login link
//        WebElement loginLink=driver.findElement(By.linkText("Log in"));
//
//        loginLink.click();
//        //Enter email
//        WebElement emailField =driver.findElement(By.id("Email"));
//        emailField.sendKeys("gwgfsghf@email.com");
//
//        //Enter password
//        WebElement passwordField=driver.findElement(By.id("Password"));
//        passwordField.sendKeys("123456");
//
//
//        //login button
//        WebElement logInButton=driver.findElement(By.xpath("//input[@value='Log in']"));
//        logInButton.click();
//        Thread.sleep(5000);
//        driver.close();


    }

