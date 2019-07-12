package homework7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import homework7.forms.SubstancesForm;
import org.openqa.selenium.WebElement;

import java.util.List;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    @FindBy(className = "form")
    public static SubstancesForm substancesForm;

    @Css(".panel-body-list.results li")
    public static List<WebElement> resultsLog;


}
