package homework7.custom;

import com.epam.jdi.light.ui.html.base.HtmlElement;

public class MenuItem extends HtmlElement {
    @Override
    public boolean isSelected() {
        return hasClass("active")
                && attr("ui").equals("label");
    }
}
