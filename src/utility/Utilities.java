package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

    WebDriver driver;

    public Utilities(WebDriver driver){
        this.driver = driver;

    }
    public  void clickonElement(By by){
        driver.findElement(by).click();

    }
    public void sendTextToElement(By by, String str){
        driver.findElement(by).sendKeys(str);
    }

    /* This mehtod is for select visible text from drop down menu

     */
    public void selectVisibleTextFromDropDownMenu(By by, String text){
        Select dropDown = new Select((driver.findElement(by)));
        dropDown.selectByVisibleText(text);
    }
    /* this method is for select by value from drop down Menu

     */
    public void selectByValueFromDropDownMenu(By by, String value){
        Select dropDown = new Select(driver.findElement(by));
        dropDown.selectByValue(value);
    }
    /* This method is for select by Index from drop down Menu

     */
    public void selectByIndexFromDropDownMenu(By by,int index){
        Select dropDown = new Select(driver.findElement(by));
        dropDown.selectByIndex(index);
    }
    /* This method is for Action by mouseHover

     */
    public void mouseHover(WebElement element){
        Actions actions= new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
    /*This method is for mouse hover to element

     */
    public void mouseHoverToElement(By by){
        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
    /*This is mehtod for click and drag

     */


    public void clickAndHoldToElement(WebElement element){
         Actions actions = new Actions(driver);
         actions.clickAndHold(element).build().perform();
    }
    /*This is for click and drag with By by

     */
    public void clickAndHoldElement(By by){
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(by)).build().perform();
    }
    /* This is for drag and drop with webelemen

     */
    public void dropAndDragElement(WebElement fromElement, WebElement toElement){
        Actions actions = new Actions(driver);
        actions.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
    }
    /*This is the actions class swithching frame from one side to another side

     */
    public void dragAndDropElement(WebElement element){
        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);
       // actions.dragAndDrop(element ).perform();
    }
    /* This menthod will wait until  web driver until presence of element is located

     */
    public void waitUntilPresenceOfElementLocated(By by, int timeout){
        WebDriverWait wait= new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }
    /* This mehtod will wait until webdriver find element tobe clickable

     */
    public void waitUntilPresenceOfElementClickAble(By by, int timeout){
        WebDriverWait wait= new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /* This method will wait until webdriver find visiablity of located webelement by locater

     */
    public void waitUntilVisiablityOfElementLocated(By by, int timeout){
        WebDriverWait wait= new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


}
