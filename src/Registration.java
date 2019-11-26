import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utility.Utilities;

import java.util.concurrent.TimeUnit;



public class Registration {
    private WebDriver driver;
    Utilities utilities;



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/surajbharmal/IdeaProjects/seleniumdemo/driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utilities = new Utilities(driver);



    }
    @Test
    public void userShouldNavigateToRegister() throws InterruptedException {

        //Clicking on register link
        By registerLink = (By.linkText("Register"));
        utilities.clickonElement(registerLink);
        System.out.println("click on register link");

        By genderLink = (By.id("gender-male"));
        utilities.clickonElement(genderLink);
        System.out.println("selecting gender by clicking on it");

        //First name with send key
        By firstName= (By.id("FirstName"));
        utilities.sendTextToElement(firstName, "Simon");
        System.out.println("input firstName");

        //Lastname input
       // By lastName= (By.id("LastName"));
        utilities.sendTextToElement(By.id("LastName"),"Wilson");
        System.out.println("Input Lastname");

         /*date of Birth by calling select method from utilities class
         */


        By DOB= (By.name("DateOfBirthDay"));
        utilities.selectByIndexFromDropDownMenu(DOB,2);

        System.out.println("user select 2nd date of birth");

        //Month of date
        By month = (By.name("DateOfBirthMonth"));
        utilities.selectVisibleTextFromDropDownMenu(month,"August");
//        System.out.println("User select month");

        //Year of birth
        By year = (By.name("DateOfBirthYear"));
        utilities.selectByValueFromDropDownMenu(year,"1985");
        System.out.println("user can select year");
//
//        //Input Email address

        By Email= (By.id("Email"));
        utilities.sendTextToElement(Email,"wilson@gmai.com");
        System.out.println("Insert email");

        //input comapny
        By Company= (By.id("Company"));
        utilities.sendTextToElement(Company,"S&W Pvt Ltd");
        System.out.println("Input your company name");
        utilities.waitUntilPresenceOfElementLocated(Company, 2);

        System.out.println("Located time 2");

        //New letter click
        By newsletter=(By.id("Newsletter"));
        utilities.clickonElement(newsletter);
        System.out.println("Select news letters");

        //Password input
        By password= (By.id("Password"));
        utilities.sendTextToElement(password,"abcd123");
        System.out.println("input passwrod abcd123");
        //confirm password

        By confirm = (By.id("ConfirmPassword"));
        utilities.sendTextToElement(confirm, "abcd123");
        System.out.println("confirm password with abcd123");
        Thread.sleep(5000);

        //Click register button
        By RegButton= (By.id("register-button"));
        utilities.clickonElement(RegButton);
        System.out.println("click on register button");
        utilities.waitUntilPresenceOfElementClickAble(RegButton,5);
        System.out.println("Element wait for 5 second");


         WebElement text=driver.findElement(By.className("result"));
        Assert.assertTrue("Your registration completed",text.isDisplayed());
        String expectedText="Your registration completed";
        String actualText =driver.findElement(By.className("result")).getText();
        Assert.assertEquals("Countinue is  not Displayed",expectedText,actualText);


       // Thread.sleep(5000);


    }
    @After
    public void tearDown(){
        driver.quit();
    }




//    public static void main(String[] args) throws InterruptedException {
//
//        System.setProperty("webdriver.chrome.driver", "/Users/surajbharmal/IdeaProjects/seleniumdemo/driver/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://demo.nopcommerce.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        //find element of register
//
//        WebElement registerLink = driver.findElement(By.linkText("Register"));
//        registerLink.click();
//
//
//        WebElement genderLink = driver.findElement(By.id("gender-male"));
//        genderLink.click();
//        Thread.sleep(1000);
//        //input firstname and lastname field
//        //firstname
//        WebElement firstnameField= driver.findElement (By.id("FirstName"));
//        firstnameField.sendKeys("Simon");
//        Thread.sleep(5000);
//
//        //Lastname
//        WebElement lastnameField = driver.findElement(By.id("LastName"));
//        //driver.findElement(By.id("LastName")).sendKeys("Wilson");
//        lastnameField.sendKeys("Wilson");
//        Thread.sleep(1000);
//
//        //Date of Birth
//        WebElement DOB=driver.findElement(By.name("DateOfBirthDay"));
//        DOB.sendKeys("8");
//        Thread.sleep(2000);
//
//
//        //month
//        WebElement month=driver.findElement(By.name("DateOfBirthMonth"));
//        month.sendKeys("February");
//        Thread.sleep(2000);
//        //year
//        WebElement year=driver.findElement(By.name("DateOfBirthYear"));
//        year.sendKeys("1985");
//        Thread.sleep(2000);
//
//        //Email address
//        WebElement Email= driver.findElement(By.id("Email"));
//        Email.sendKeys("abcd@gmail.com");
//        Thread.sleep(2000);
//
//        //Company
//
//        WebElement comapny=driver.findElement(By.id("Company"));
//        comapny.sendKeys("J&T");
//        Thread.sleep(2000);
//
//        //Newsletter
//        WebElement news=driver.findElement(By.id("Newsletter"));
//        news.click();
//
//        //password
//        WebElement password= driver.findElement(By.id("Password"));
//        password.sendKeys("rush1234");
//        Thread.sleep(2000);
//
//        //Confirm Password
//        WebElement confirm= driver.findElement(By.id("ConfirmPassword"));
//        confirm.sendKeys("rush1234");
//
//        //register button click
//        WebElement register= driver.findElement(By.id("register-button"));
//        register.click();
//
//
//
//        driver.close();
//    }
}
