package homework7.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import homework7.entities.Substances;

public class SubstancesForm extends Form<Substances> {

    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Droplist colors;

    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Droplist metals;

    @JDropdown(root = "#vegetables",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Droplist vegetables;

    @XPath("//p[@class='checkbox'][contains(.,'%s')]//label")
    public UIElement elements;

    @Css("#odds-selector p")
    public RadioButtons odds;

    @Css("#even-selector p")
    public RadioButtons even;

    @UI("['Submit']")
    public Button submit;

    @Override
    public void submit(Substances entity) {
        colors.select(entity.getColors());
        metals.select(entity.getMetals());
        for (String element : entity.getElements()) {
            elements.select(element);
        }
        for (Integer digit : entity.getSummary()) {
            if (digit % 2 == 0) {
                even.select(digit.toString());
            } else {
                odds.select(digit.toString());
            }
        }
        for (String veg : entity.getVegetables()) {
            vegetables.select(veg);
        }

        submit.click();
    }

}

