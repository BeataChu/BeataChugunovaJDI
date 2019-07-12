package homework7;

import homework7.entities.Users;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import homework7.site.JdiSite;

import java.util.ArrayList;
import java.util.List;

import static homework7.entities.Defaults.DEFAULT_SUBSTANCES;
import static homework7.entities.HeaderMenuData.MetalsColors;
import static homework7.site.JdiSite.*;
import static org.testng.Assert.assertTrue;
import static homework7.pages.MetalsAndColorsPage.resultsLog;
import static homework7.pages.MetalsAndColorsPage.substancesForm;

public class MetalsAndColorsTest extends TestsInit {

    @Test
    public void userCanSubmitMetalsAndColorsForm() throws InterruptedException {
        JdiSite.open();
        homePage.login(Users.PITER);
        homePage.checkLoggedin(Users.PITER);

        homePage.shouldBeOpened();
        headerMenu.select(MetalsColors.getUpperCase());
        metalsColorsPage.checkOpened();
        substancesForm.vegetables.select("Vegetables");
        substancesForm.submit(DEFAULT_SUBSTANCES);

        //check result log
        List<String> actualResults = new ArrayList<>();
        for (WebElement item : resultsLog) {
            actualResults.add(item.getText());
        }

        List<String> expectedResults = new ArrayList<>();
        Integer sum = 0;
        for (Integer digit : DEFAULT_SUBSTANCES.getSummary()) {
            sum += digit;
        }
        expectedResults.add("Summary: " + sum);
        expectedResults.add(buildLine("Elements: ", DEFAULT_SUBSTANCES.getElements()));
        expectedResults.add("Color: " + DEFAULT_SUBSTANCES.getColors());
        expectedResults.add("Metal: " + DEFAULT_SUBSTANCES.getMetals());
        expectedResults.add(buildLine("Vegetables: ", DEFAULT_SUBSTANCES.getVegetables()));

        assertTrue(actualResults.containsAll(expectedResults));

    }

    public String buildLine(String title, List<String> substances) {
        StringBuilder sb = new StringBuilder();
        for (String sub : substances) {
            if (sb.length() == 0) {
                sb.append(title);
            } else {
                sb.append(", ");
            }
            sb.append(sub);
        }
        return sb.toString();
    }

}
