/*
*Created by Anton 02/11/2018
 */

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendAppPage {

    @FindBy(xpath = "//*[@class='b-form-section']//*[@class='b-form-box-block']//*[@class='b-form-prog-box b-form-active-box']")
    public WebElement sendButonMin;



    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(sendButonMin)).click();
    }

}
