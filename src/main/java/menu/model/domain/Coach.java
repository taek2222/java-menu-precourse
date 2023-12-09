package menu.model.domain;

import java.util.List;

public class Coach {
    private final String name;
    private final List<String> hateMenus;

    public Coach(String name, List<String> hateMenus) {
        this.name = name;
        this.hateMenus = hateMenus;
    }

    public boolean isHateMenu(String menu) {
        return hateMenus.contains(menu);
    }
}
