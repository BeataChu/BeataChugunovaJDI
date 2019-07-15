package homework7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Label;
import homework7.entities.Users;
import homework7.forms.JdiLoginForm;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebElement;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {

    public static JdiLoginForm loginForm;

    @Css("#user-name")
    public static Label userName;

    @Css(".profile-photo")
    public static Button profilePhoto;

    @Css(".fa-sign-out")
    public static WebElement logout;

    public void login(Users user) {
        profilePhoto.click();
        loginForm.login(user);
    }


    public void checkLoggedin(Users user) {
        userName.shouldBe().text(Matchers.equalTo(user.getFullName()));
    }
}
