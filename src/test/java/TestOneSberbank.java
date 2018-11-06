//import org.junit.After;
import org.junit.Assert;
//import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;

/**
 * Created by Anton on 26.10.18
 */
public class TestOneSberbank extends BaseTest {
//    WebDriver driver;
//    String baseUrl;
//
//    // Данный метод выполняется перед каждым тестом
//    @Before
//    public void beforeTest() {
//        //запуск драйвера браузера
//        System.setProperty("webdriver.chrome.driver", "draiver/chromedriver.exe");
//        baseUrl = "http://www.sberbank.ru/ru/person";
//        driver = new ChromeDriver();
//        //Установка неявного ожидания. в течении 30 сек искать елемент с заданным лакатором
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        //Развернуть окно на весь экран
//        driver.manage().window().maximize();
//        //Перейти на сайт
//        driver.get(baseUrl);
//    }

    @Test
    @Ignore
    public void testSberbank() {
        //Перейти на сайт
        driver.get(baseUrl);
        //Найти кнопку Страхование и кликнуть на неё
        driver.findElement(By.xpath("//li[contains(@class,'lg-menu')]//*[contains(text(), 'Страхование')]")).click();
        //Найти кнопку Путешествие и покупки и кликнуть на неё
        driver.findElement(By.xpath("//*[contains(@class,'lg-menu')]//*[contains(text(),'Путешествия и покупки')]")).click();
        //Задать время явного ожидания (5 сек ждем)
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        //Присввоили элементу значние искомого заголовка Страхование путешественников
        WebElement sendZag = driver.findElement(By.xpath("//div[contains(@class,'h')]//*[contains(text(),'Страхование путешественников')]"));
        //Ждем появления заголовка Страхование путешественников
        wait.until(ExpectedConditions.visibilityOf(sendZag));
        //Проверить корректность заголовка Страхование путешественников
        Assert.assertEquals("Страхование путешественников", sendZag.getText());
        //Найти кнопку Оформить онлайн и кликнуть на неё
        driver.findElement(By.xpath("//*[contains(@data-pid,'2247407')]//*[@class='kit-button kit-button_color_green kit-button_size_m']")).click();
        //Переключиться на новую вкладку
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        //Ждем появления кнопки минимальная
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='b-form-prog-box b-form-active-box']"))));
        //Найти кнопку Минимальная и кликнуть на неё
        driver.findElement(By.xpath("//*[@class='b-form-section']//*[@class='b-form-box-block']//*[@class='b-form-prog-box b-form-active-box']")).click();
        //Найти кнопку Оформить и кликнуть на неё
        driver.findElement(By.xpath("//span[contains(text(),'Оформить')]")).click();
        //Заполняем поля
        fillField(By.name("insured0_surname"), "Ivanov");
        fillField(By.name("insured0_name"), "Ivan");
        //new Select(driver.findElement(By.name("insured0_birthDate"))).deselectByVisibleText("11");
        fillField(By.name("insured0_birthDate"), "01011980");
        fillField(By.name("surname"), "Петров");
        fillField(By.name("name"), "Петр");
        fillField(By.name("middlename"), "Петрович");
        fillField(By.name("birthDate"), "01011980");
        driver.findElement(By.name("female")).click();
        fillField(By.name("passport_series"), "1111");
        fillField(By.name("passport_number"), "555555");
        fillField(By.name("issueDate"), "01012015");
        fillField(By.name("issuePlace"), "МВД");
        //Найти кнопку Продолжить и кликнуть на неё
        driver.findElement(By.xpath("//*[contains(@ng-click,'save()')]")).click();
        //Проверить заполнение полей
        Assert.assertEquals("Ivanov", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        Assert.assertEquals("Ivan", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        Assert.assertEquals("01.01.1980", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        Assert.assertEquals("Петров", driver.findElement(By.name("surname")).getAttribute("value"));
        Assert.assertEquals("Петр", driver.findElement(By.name("name")).getAttribute("value"));
        Assert.assertEquals("Петрович", driver.findElement(By.name("middlename")).getAttribute("value"));
        Assert.assertEquals("01.01.1980", driver.findElement(By.name("birthDate")).getAttribute("value"));
        Assert.assertEquals("1111", driver.findElement(By.name("passport_series")).getAttribute("value"));
        Assert.assertEquals("555555", driver.findElement(By.name("passport_number")).getAttribute("value"));
        Assert.assertEquals("01.01.2015", driver.findElement(By.name("issueDate")).getAttribute("value"));
        Assert.assertEquals("МВД", driver.findElement(By.name("issuePlace")).getAttribute("value"));
        //Проверить корректность сообщения об ошибке Заполнены не все обязательные поля
        Assert.assertEquals("Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//*[contains(text(),'Заполнены не все обязательные поля')]")).getText());
    }

//    //Метод для заполненеия полей
//    public void filldFind(By lacator, String value) {
//        driver.findElement(lacator).clear();
//        driver.findElement(lacator).sendKeys(value);
//    }

//    // Данный метод выполняется после каждого теста
//    @After
//    public void afterTest() {
//        //Закрыть браузер
//        driver.quit();
//    }
}
