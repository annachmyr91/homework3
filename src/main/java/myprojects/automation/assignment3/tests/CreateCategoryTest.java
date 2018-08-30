package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class CreateCategoryTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException {
        // TODO predriver.getpare driver object
        EventFiringWebDriver edriver = getConfiguredDriver();

        EventCapture eventCapture = new EventCapture();
        edriver.register(eventCapture);

        edriver.navigate().to(Properties.getBaseAdminUrl());

        edriver.manage().window().maximize();

        GeneralActions generalActions = new GeneralActions(edriver);

        generalActions.login(" webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
        generalActions.waitForContentLoad();
        generalActions.createCategory();
        edriver.close();
    }

}


// login

// create category

// check that new category appears in Categories table

// finish script
