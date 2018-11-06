/*
 *Created by Anton 02/11/2018
 */

import org.junit.Test;
import pages.Formalize;
import pages.MainPage;
import pages.SendAppPage;

import java.util.ArrayList;

public class MyRefaktoringTest extends BaseTest {

    @Test
    public void newInshuransTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainManu("Страхование");
        mainPage.sendButonTreep.click();
        mainPage.sendButonOnline.click();
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        new SendAppPage(driver).sendButonMin.click();
        Formalize formalize=new Formalize(driver);
        formalize.sendBatonFormalize.click();
        formalize.fillField("первая фамилия", "Ivanov");
        formalize.fillField("первое имя","Ivan");
        formalize.fillField("первая др","01011980");
        formalize.fillField("фамилия","фамилия");
        formalize.fillField("имя","имя");
        formalize.fillField("отчество","отчество");
        formalize.fillField("др","01011980");
        formalize.fillField("серия","1234");
        formalize.fillField("номер","123456");
        formalize.fillField("дата","01012015");
        formalize.fillField("кем","кем");
        formalize.female.click();
        formalize.sendButonNext.click();
        formalize.checkFieldErrorMessage("Заполнены не все обязательные поля", "Заполнены не все обязательные поля");

    }
}
