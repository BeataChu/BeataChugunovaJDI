package homework8;

import homework7.FormChecker;
import homework7.TestsInit;
import homework7.entities.Substances;
import homework7.entities.Users;
import homework7.site.JdiSite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static homework7.entities.HeaderMenuData.MetalsColors;
import static homework7.pages.MetalsAndColorsPage.resultsLog;
import static homework7.pages.MetalsAndColorsPage.substancesForm;
import static homework7.site.JdiSite.*;
import static homework8.states.State.loggedOut;
import static org.testng.Assert.assertTrue;

public class DataProviderMetalsColorsTest extends TestsInit {


    @Test(dataProviderClass = InputProvider.class, dataProvider = "inputData")
    public void useJsonToSubmitMetalsColorsForm(Substances entity) {
        JdiSite.open();
        homePage.login(Users.PITER);
        homePage.checkLoggedin(Users.PITER);

        homePage.shouldBeOpened();
        headerMenu.select(MetalsColors);
        metalsColorsPage.checkOpened();
        substancesForm.submit(entity);

        assertTrue(FormChecker.checkSubstancesForm(resultsLog, entity));
    }

    @AfterMethod
    public void tearDown() {
        loggedOut();
    }

}
