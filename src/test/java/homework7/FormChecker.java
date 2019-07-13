package homework7;

import homework7.entities.Substances;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FormChecker {

    public static boolean checkSubstancesForm(List<WebElement> resultsLog, Substances substances) {
        List<String> actualResults = new ArrayList<>();
        for (WebElement item : resultsLog) {
            actualResults.add(item.getText());
        }

        List<String> expectedResults = new ArrayList<>();
        Integer sum = 0;
        for (Integer digit : substances.getSummary()) {
            sum += digit;
        }
        expectedResults.add("Summary: " + sum);
        expectedResults.add(buildLine("Elements: ", substances.getElements()));
        expectedResults.add("Color: " + substances.getColors());
        expectedResults.add("Metal: " + substances.getMetals());
        expectedResults.add(buildLine("Vegetables: ", substances.getVegetables()));

        return actualResults.containsAll(expectedResults);
    }

    public static String buildLine(String title, List<String> substances) {
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
