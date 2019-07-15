package homework7.site;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.base.HtmlList;
import com.epam.jdi.light.ui.html.complex.Menu;
import homework7.custom.MenuItem;
import homework7.entities.Users;
import homework7.pages.HomePage;
import homework7.pages.MetalsAndColorsPage;
import org.openqa.selenium.WebElement;

@JSite("https://epam.github.io/JDI/")
public class JdiSite {

    public static HomePage homePage;
    public static MetalsAndColorsPage metalsColorsPage;

    @FindBy(id = "login-form")
    public static Form<Users> loginForm;

    @Css(".profile-photo [ui=label]")
    public static UIElement userName;

    @Css("img#user-icon")
    public static WebElement userIcon;

    @Css(".m-l8")
    public static Menu headerMenu = new HtmlList() {
        @Override
        public void select(String value) {
            super.select(value.toUpperCase());
        }
    };

    @UI(".sidebar-menu li")
    public static JList<MenuItem> menu;

    public static void open() {
        homePage.open();
    }
}

