import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Testing {

    protected static WebDriver driver;

    public static void main(String[] args)  throws InterruptedException {

        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "/Users/surajbharmal/IdeaProjects/seleniumdemo/driver/chromedriver");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // Select sub menu from top menu list and navigate to sub menu page.


        selectSubMenuByName("Apparel", "Shoes");

    }


    /**
     * This Method is used to select submenu from top menu list and click on menu.
     *
     * @param topMenuName
     * @param subMenuName
     */
    public static void selectSubMenuByName(String topMenuName, String subMenuName)  throws InterruptedException{

        Actions action = new Actions(driver);
        WebElement topMenu = driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'" + topMenuName + "')]"));
        action.moveToElement(topMenu).build().perform();

        Thread.sleep(5000);
        if (topMenuName.equalsIgnoreCase("Digital downloads") ||
                topMenuName.equalsIgnoreCase("Books") ||
                topMenuName.equalsIgnoreCase("Jewelry") ||
                topMenuName.equalsIgnoreCase("Gift Cards")) {
            topMenu.click();
        } else {
            List<WebElement> topMenuList = driver.findElements(By.xpath("//ul[@class='top-menu']/li[a[contains(text(),'" + topMenuName + "')]]/ul/li/a"));
            for (WebElement menu : topMenuList) {
                try {
                    if (menu.getText().equalsIgnoreCase(subMenuName)) {
                        menu.click();
                    }

                } catch (StaleElementReferenceException ex) {
                    ex.getMessage();
                }
            }
         }
        driver.close();
    }
}

