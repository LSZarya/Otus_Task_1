import Page.MainPage;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StartTest extends WebDriverFactory {

    public static EventFiringWebDriver driver;

    @BeforeTest
    public void setUp(ITestContext context) {

        driver = new EventFiringWebDriver(setupDriver(System.getProperty("browser")));
        driver.register(new MarkBeforeClickListener());
        context.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);// Пауза на 5 секунд, для явного ожидания элемента
        driver.manage().window().maximize();//Открытие сайта на весь экран

    }

    @AfterTest
    public void teamDown() {
        driver.quit();// Закрытие браузера
    }

    @Test
    public void CheckPopularCourse(){
        new MainPage(driver)
                .openOtus()
                .PopularCourse(System.getProperty("namePopularCourse"));
    }

    @Test
    public void CheckSpecialCourse(){
        new MainPage(driver)
                .openOtus()
                .SpecialCourse(System.getProperty("nameSpecialCourse"));
    }

    @Test
    public void CheckIsBeforePopularCourse(){
        new MainPage(driver)
                .openOtus()
                .PopularCourseIsBefore();
    }

    @Test
    public void CheckIsAfterPopularCourse(){
        new MainPage(driver)
                .openOtus()
                .PopularCourseIsAfter();
    }

    @Test
    public void CheckIsBeforeSpecialCourse(){
        new MainPage(driver)
                .openOtus()
                .SpecialCourseIsBefore();
    }

    @Test
    public void CheckIsAfterSpecialCourse(){
        new MainPage(driver)
                .openOtus()
                .SpecialCourseIsAfter();
    }

    @Test(enabled = false)
    public void CheckClickCourse(){
        new MainPage(driver)
                .openOtus()
                .ClickCourse(Integer.parseInt(System.getProperty("nameOpenCourse")));
    }
}