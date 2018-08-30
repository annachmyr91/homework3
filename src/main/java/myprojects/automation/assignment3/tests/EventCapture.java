package myprojects.automation.assignment3.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.util.Arrays;


public class EventCapture extends AbstractWebDriverEventListener {

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Driver navigates to " + s + " page");
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Driver navigated to " + s + " page");

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("WebElement with \"" + by + "\"  locator is to be found ");
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("WebElement with \"" + by + "\"  locator is found ");

    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println(webElement + " element is to be clicked ");

    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println(webElement + " element is clicked ");

    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("The " + Arrays.toString(charSequences) + " is to be typed into " + webElement + " field.");
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("The " + Arrays.toString(charSequences) + " is typed into " + webElement + " field.");

    }


    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        System.out.println("The exception " + throwable + " need to be handled");
    }
}
