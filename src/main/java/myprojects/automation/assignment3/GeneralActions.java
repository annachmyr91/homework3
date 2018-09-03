package myprojects.automation.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;


    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     *
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        // TODO implement logging in to Admin Panel

        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.className("btn-lg")).click();
    }

    /**
     * Adds new category in Admin Panel.
     * <p>
     * //* @param categoryName
     */

    public String generateString(int length) {
        final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        Random random = new Random();
        StringBuilder builder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }

        return builder.toString();
    }

    public void createCategory() {

        // TODO implement logic for new category creation
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        waitForContentLoad();
        Actions act = actions.moveToElement(driver.findElement(By.id("subtab-AdminCatalog")));
        waitForContentLoad();
        //   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        act.click(driver.findElement(By.cssSelector("#subtab-AdminCategories a"))).build().perform();
        waitForContentLoad();


/*        String[] categoryNames = {"Glasses_1", "Glasses_2", "Glasses_3", "Glasses_4", "Glasses_5"};
        Random random = new Random();
        int randomNumber = random.nextInt(categoryNames.length);
        String randomName = categoryNames[randomNumber];*/

        String randomName = null;
        try {
            randomName = generateString(Random.class.newInstance().nextInt(9));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        int i = 0;
        for (WebElement webElement : driver.findElements(By.xpath("//td[3]"))) {
            String categoryName = webElement.getText();

            if (categoryName.equals(randomName)) {
                i++;
            }
        }

        waitForContentLoad();

        driver.findElement(By.id("page-header-desc-category-new_category")).click();
        waitForContentLoad();


        driver.findElement(By.id("name_1")).sendKeys(randomName);

        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement saveNewCategoryBtn = driver.findElement(By.id("category_form_submit_btn"));
        je.executeScript("arguments[0].scrollIntoView(true);", saveNewCategoryBtn);
        saveNewCategoryBtn.click();
        waitForContentLoad();

        try {
            driver.findElement(By.xpath("//*[@class=\"alert alert-success\"]")).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Alert about successful category creation does not appear");
        }
        waitForContentLoad();

        driver.findElement(By.xpath("//th[3]//a[2]")).click();
        waitForContentLoad();

        int j = 0;
        for (WebElement webElement : driver.findElements(By.xpath("//td[3]"))) {
            String categoryName = webElement.getText();


            if (categoryName.equals(randomName)) {
                j++;
            }
        }

        if (j == (i + 1))
            System.out.println("Category added successfully");
        else System.out.println("New category hasn't added");
    }


    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        // TODO implement generic method to wait until page content is loaded
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

    }
}
