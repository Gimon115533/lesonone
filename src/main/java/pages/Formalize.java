/*
 *Created by Anton 02/11/2018
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Formalize {

    @FindBy(xpath = "//span[contains(text(),'Оформить')]")
    public WebElement sendBatonFormalize;

    @FindBy(name = "insured0_surname")
    public WebElement insured0_surname;

    @FindBy(name = "insured0_name")
    public WebElement insured0_name;

    @FindBy(name = "insured0_birthDate")
    public WebElement insured0_birthDate;

    @FindBy(name = "surname")
    public WebElement surname;

    @FindBy(name = "name")
    public WebElement name;

    @FindBy(name = "middlename")
    public WebElement middlename;

    @FindBy(name = "birthDate")
    public WebElement birthDate;

    @FindBy(name = "female")
    public WebElement female;

    @FindBy(name = "passport_series")
    public WebElement passport_series;

    @FindBy(name = "passport_number")
    public WebElement passport_number;

    @FindBy(name = "issueDate")
    public WebElement issueDate;

    @FindBy(name = "issuePlace")
    public WebElement issuePlace;

    @FindBy(xpath = "//*[contains(@ng-click,'save()')]")
    public WebElement sendButonNext;

    @FindBy(xpath="//*[contains(text(),'Заполнены не все обязательные поля')]")
    public WebElement messeg;

    public Formalize(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillField(String fieldename, String value) {
        switch (fieldename) {
            case "первая фамилия":
                fillFieldt(insured0_surname, value);
                break;
            case "первое имя":
                fillFieldt(insured0_name,value);
                break;
            case "первая др":
                fillFieldt(insured0_birthDate, value);
                break;
            case "фамилия":
                fillFieldt(surname,value);
                break;
            case "имя":
                fillFieldt(name, value);
                break;
            case "отчество":
                fillFieldt(middlename,value);
                break;
            case "др":
                fillFieldt(birthDate, value);
                break;
            case "серия":
                fillFieldt(passport_series,value);
                break;
            case "номер":
                fillFieldt(passport_number, value);
                break;
            case "дата":
                fillFieldt(issueDate,value);
                break;
            case "кем":
                fillFieldt(issuePlace,value);
                break;
                default: throw new AssertionError("Поле "+fieldename+"не объявлено");
        }

    }

    protected void fillFieldt(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Заполнены не все обязательные поля":
                return messeg.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void checkFieldErrorMessage(String field, String errorMessage){
        String actualValue = messeg.getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }
}
