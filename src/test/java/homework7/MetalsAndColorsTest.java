package homework7;

import homework7.entities.Users;
import homework7.site.JdiSite;
import org.testng.annotations.Test;

import static homework7.entities.Defaults.DEFAULT_SUBSTANCES;
import static homework7.entities.HeaderMenuData.MetalsColors;
import static homework7.pages.MetalsAndColorsPage.resultsLog;
import static homework7.pages.MetalsAndColorsPage.substancesForm;
import static homework7.site.JdiSite.*;
import static org.testng.Assert.assertTrue;

public class MetalsAndColorsTest extends TestsInit {

    @Test
    public void userCanSubmitMetalsAndColorsForm() {
        JdiSite.open();
        homePage.login(Users.PITER);
        homePage.checkLoggedin(Users.PITER);

        homePage.shouldBeOpened();
        // TODO This is a really great idea to use this element, but
        // it will be better to pass here ENUM itself rather than String.
        headerMenu.select(MetalsColors);
        metalsColorsPage.checkOpened();
        substancesForm.submit(DEFAULT_SUBSTANCES);

        assertTrue(FormChecker.checkSubstancesForm(resultsLog, DEFAULT_SUBSTANCES));
    }
}
