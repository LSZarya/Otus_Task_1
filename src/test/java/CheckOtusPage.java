import Page.MainPage;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckOtusPage {

    private EventFiringWebDriver driver;
    private MainPage mainPage;

    @BeforeTest
    public void setUp(ITestContext context) {

        driver = new EventFiringWebDriver(WebDriverFactory.setupDriver(System.getProperty("browser")));
        driver.register(new MarkBeforeClickListener());
        context.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);// Пауза на 5 секунд, для явного ожидания элемента
        driver.manage().window().maximize();//Открытие сайта на весь экран
        mainPage = new MainPage(driver);
    }

    @AfterTest
    public void teamDown() {
        driver.quit();// Закрытие браузера
    }


    @Test
    public void CheckPopularCourse(){

        mainPage
                .openOtus()
                .PopularCourse(System.getProperty("namePopularCourse"));
    }

    @Test
    public void CheckSpecialCourse(){
        mainPage
                .openOtus()
                .SpecialCourse(System.getProperty("nameSpecialCourse"));
    }

    @Test
    public void CheckIsBeforePopularCourse(){
        mainPage
                .openOtus()
                .PopularCourseIsBefore();
    }

    @Test
    public void CheckIsAfterPopularCourse(){
        mainPage
                .openOtus()
                .PopularCourseIsAfter();
    }

    @Test
    public void CheckIsBeforeSpecialCourse(){
        mainPage
                .openOtus()
                .SpecialCourseIsBefore();
    }

    @Test
    public void CheckIsAfterSpecialCourse(){
        mainPage
                .openOtus()
                .SpecialCourseIsAfter();
    }

    @Test(enabled = false)
    public void CheckClickCourse(){
        mainPage
                .openOtus()
                .ClickCourse(Integer.parseInt(System.getProperty("nameOpenCourse")));
    }
}