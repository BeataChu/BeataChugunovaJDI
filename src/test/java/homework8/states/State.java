package homework8.states;

import homework7.pages.HomePage;

import static homework7.site.JdiSite.userIcon;

public class State {
    public static void loggedOut() {
        if (HomePage.userName.isDisplayed()) {
            if (!(HomePage.logout.isDisplayed()))
                userIcon.click();
            HomePage.logout.click();
        }
    }
}