package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a//div[@class='lessons__new-item-title lessons__new-item-title_with-bg js-ellipse']")
    private List<WebElement> popularCourses;

    @FindBy(xpath = "//a//div[@class='lessons__new-item-start']")
    private List<WebElement> popularCoursesDate;

    @FindBy(xpath = "//a//div[contains(@class, 'lessons__new-item-title_bundle')]")
    private List<WebElement> specialCourses;

    @FindBy(xpath = "//div[@class='container-padding-bottom']//a//div[@class='lessons__new-item-time']")
    private List<WebElement> specialCoursesDate;

    @FindBy(css = "a.lessons__new-item")
    private List<WebElement> courses;

    @FindBy(css = "a.lessons__new-item .lessons__new-item-title")
    private List<WebElement> coursesNameAll;

    @FindBy(css = ".course-header2__title")
    private WebElement courseNameH1;

    public MainPage openOtus(){
        driver.get("https://otus.ru/");
        return this;
    }

    public MainPage PopularCourse(String name){
        try {
            for (int i = 0 ; ; i++) {
                String courses = popularCourses.get(i).getText();
                if (courses.contains(name)) {
                    System.out.println("Вы выбрали \"Популярные курсы\" курс-сы - " + courses);
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("Курс не найден");
            Assert.fail();
        }
        return this;
    }

    public MainPage SpecialCourse(String name){
        try {
            for (int i = 0 ; ; i++) {
                String courses = specialCourses.get(i).getText();
                if (courses.contains(name)) {
                    System.out.println("Вы выбрали \"Специальные курсы\" курс-сы - " + courses);
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("Курс не найден");
            Assert.fail();
        }
        return this;
    }

    public MainPage PopularCourseIsBefore(){

            int numberCourse = 0;

            LocalDate startDay = LocalDate.of(2023, 1, 1);
            LocalDate nextDay;

            for ( int i = 0; i != 3; i++) {

                String popular = popularCoursesDate.get(i).getText();

                String[] words = popular.split("[\\s]+");

                if (words.length == 3 || words[0].matches("[С]") || words[1].matches("[0-9]{2}") || words[2].matches("[а-я]+")) {
                    int dd = Integer.parseInt(words[1]);

                    nextDay = LocalDate.of(2022, dateMonthStringInInt(words[2]), dd);

                    if (nextDay.isBefore(startDay)) {
                        startDay = nextDay;
                        numberCourse = i;
                    }
                }
            }
            System.out.println("Популярный курс, который стартует раньше всех- " + popularCourses.get(numberCourse).getText() + "\nОн начинает- " + startDay);

        return this;
    }

    public MainPage PopularCourseIsAfter(){

        int numberCourse = 0;

        LocalDate startDay = LocalDate.of(2021, 1, 1);
        LocalDate nextDay;

        for ( int i = 0; i != 3; i++) {

            String popular = popularCoursesDate.get(i).getText();

            String[] words = popular.split("[\\s]+");

            if (words.length == 3 || words[0].matches("[С]") || words[1].matches("[0-9]{2}") || words[2].matches("[а-я]+")) {
                int dd = Integer.parseInt(words[1]);

                nextDay = LocalDate.of(2022, dateMonthStringInInt(words[2]), dd);

                if (nextDay.isAfter(startDay)) {
                    startDay = nextDay;
                    numberCourse = i;
                }
            }
        }
        System.out.println("Популярный курс, который стартует раньше всех- " + popularCourses.get(numberCourse).getText() + "\nОн начинает- " + startDay);

        return this;
    }

    public MainPage SpecialCourseIsBefore(){

        int numberCourse = 0;

        LocalDate startDay = LocalDate.of(2023, 1, 1);
        LocalDate nextDay;

        for ( int i = 0; i != 10; i++) {

            String popular = specialCoursesDate.get(i).getText();

            String[] words = popular.split("[\\s]+");

            if (words[0].matches("[0-9]{2}") || words[1].matches("[а-я]+")) {
                int yy = 2022;
                if (Objects.equals(words[2], "2021")){
                    yy = Integer.parseInt(words[2]);
                }
                int dd = Integer.parseInt(words[0]);
                nextDay = LocalDate.of(yy, dateMonthStringInInt(words[1]), dd);

                if (nextDay.isBefore(startDay)) {
                    startDay = nextDay;
                    numberCourse = i;
                }
            }
        }
        System.out.println("Популярный курс, который стартует раньше всех- " + specialCourses.get(numberCourse).getText() + "\nОн начинает- " + startDay);

        return this;
    }

    public MainPage SpecialCourseIsAfter(){

        int numberCourse = 0;

        LocalDate startDay = LocalDate.of(2021, 1, 1);
        LocalDate nextDay;

        for ( int i = 0; i != 10; i++) {

            String popular = specialCoursesDate.get(i).getText();

            String[] words = popular.split("[\\s]+");

            if (words[0].matches("[0-9]{2}") || words[1].matches("[а-я]+")) {
                int yy = 2022;
                if (Objects.equals(words[2], "2021")){
                    yy = Integer.parseInt(words[2]);
                }
                int dd = Integer.parseInt(words[0]);
                nextDay = LocalDate.of(yy, dateMonthStringInInt(words[1]), dd);

                if (nextDay.isAfter(startDay)) {
                    startDay = nextDay;
                    numberCourse = i;
                }
            }
        }
        System.out.println("Популярный курс, который стартует раньше всех- " + specialCourses.get(numberCourse).getText() + "\nОн начинает- " + startDay);

        return this;
    }

    public int dateMonthStringInInt(String Month){
        switch (Month) {
            case "января":
                return  1;
            case "февраля":
                return  2;
            case "марта":
                return  3;
            case "декабря":
                return  12;
            default:
                System.out.println("Лев добавь месяцы");
                return 0;
        }
    }

    public MainPage ClickCourse(int i){
        Actions actions = new Actions(driver);
        i--;
        String courseName = coursesNameAll.get(i).getText();

        actions
                .moveToElement(courses.get(i))
                .pause(1000)
                .click()
                .build()
                .perform();

        Assert.assertEquals(courseName, courseNameH1.getText());

        return this;
    }


}
