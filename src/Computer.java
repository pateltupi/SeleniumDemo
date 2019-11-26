import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import utility.ActionClass;
import utility.Utilities;

import java.util.concurrent.TimeUnit;

public class Computer {
    private WebDriver driver;
    Utilities utilities;



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/surajbharmal/IdeaProjects/seleniumdemo/driver/chromedriver");
        driver= new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        utilities =new Utilities(driver);

        //Select  topmenu from list



    }
    @Test
    public void userShouldClickOnComputer() throws InterruptedException{

        //hovering all topmenu index button
        //hovering on computer in topmenu

        utilities.mouseHoverToElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]"));
        By Apparel = (By.xpath("//ul[@class='top-menu']//a[contains(text(),'Apparel')]"));
        utilities.mouseHoverToElement(Apparel);
        utilities.waitUntilPresenceOfElementLocated(Apparel, 5);
        By Electronics =(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Electronics')]"));
        utilities.mouseHoverToElement(Electronics);
        utilities.mouseHoverToElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Digital downloads')]"));
        By Books = (By.xpath("//ul[@class='top-menu']//a[contains(text(),'Books')]"));
        utilities.mouseHoverToElement(Books);
        utilities.waitUntilPresenceOfElementLocated(Books, 3);
        System.out.println("Element wait tobe click for 3 second");
        utilities.mouseHoverToElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Jewelry')]"));
        utilities.mouseHoverToElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Gift Cards')]"));



        //hovering on computer in topmenu

        utilities.mouseHoverToElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]"));

        System.out.println("Hovering on computer");
        //
        utilities.clickonElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Desktops')]"));

        System.out.println("Clicking on desktop to get in desktop page");
        //click on product

        utilities.clickonElement((By.xpath("//img[@title='Show details for Lenovo IdeaCentre 600 All-in-One PC']")));
        //Adding product to cart by clicking element
        By addToCart= (By.xpath("//div[@class='add-to-cart-panel']//input[@value='Add to cart']"));
        utilities.clickonElement(addToCart);
        utilities.waitUntilPresenceOfElementLocated(addToCart,10);
        //Click on shopping cart
        By AddToCart= (By.xpath("//span[@class='cart-label']"));
        utilities.clickonElement(AddToCart);
        utilities.waitUntilPresenceOfElementClickAble(AddToCart,5);
        //clicking on Terms and conition agree
        utilities.clickonElement((By.xpath("//label[@for='termsofservice']")));
        //Clicking on chekout button
        By CheckOut = (By.id("checkout"));
        // wait for elemtn to be clickable
        utilities.waitUntilPresenceOfElementClickAble(CheckOut,5);
        System.out.println("wait until 5 second");
        utilities.clickonElement((CheckOut));
        System.out.println("User can click on checkout button ");

        WebElement text=driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
               Assert.assertTrue("Welcome, Please Sign In!",text.isDisplayed());
               String expectedText="Welcome, Please Sign In!";
               String actualText =driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")).getText();
               Assert.assertEquals("Welcome, Please Sign In!",expectedText,actualText);


               System.out.println("this check out can see on screen");
    }

    @After
    public void tearDown(){
        driver.quit();
    }



//    public static void main(String[] args) {
//
//        System.setProperty("webdriver.chrome.driver","/Users/surajbharmal/IdeaProjects/seleniumdemo/driver/chromedriver");
//        //System.setProperty("webdriver.chrome.driver","/Users/surajbharmal/IdeaProjects/seleniumdemo/driver");
//        WebDriver driver= new ChromeDriver();
//        driver.get("https://demo.nopcommerce.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        //computer
//        WebElement computer=driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]"));
//        computer.click();
//        //Desktop selection
//        WebElement Desktop = driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Desktops')]"));
//        Desktop.click();
//        //click on product to open
//        WebElement product =driver.findElement(By.xpath("//img[@title='Show details for Lenovo IdeaCentre 600 All-in-One PC']"));
//        product.click();
//
//        //Adding to cart
//        WebElement cart=driver.findElement(By.xpath("//div[@class='add-to-cart-panel']//input[@value='Add to cart']"));
//        cart.click();
//
//        //shopping cart
//        WebElement shopping=driver.findElement(By.xpath("//span[@class='cart-label']"));
//        shopping.click();
//
//        //Select agree terms button
//        WebElement Agree= driver.findElement(By.xpath("//label[@for='termsofservice']"));
//        Agree.click();
//
//        //checkout button
//        WebElement checkout= driver.findElement(By.id("checkout"));
//        checkout.click();
//
//
//         driver.close();
//
//
//    }
}
