/*
 *Created by Anton 02/11/2018
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//*[@class='lg-menu__list']")
    WebElement mainMenu;

    @FindBy(xpath = "//*[contains(@class,'lg-menu')]//*[contains(text(),'Путешествия и покупки')]")
    public WebElement sendButonTreep;

    @FindBy(xpath = "//*[contains(@data-pid,'2247407')]//*[@class='kit-button kit-button_color_green kit-button_size_m']")
    public WebElement sendButonOnline;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectMainManu(String menuItem){
        mainMenu.findElement(By.xpath(".//*[contains(text(),'"+menuItem+"')]")).click();
    }
}
