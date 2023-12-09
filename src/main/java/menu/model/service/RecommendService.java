package menu.model.service;

import java.util.List;
import menu.model.constants.CategoryMenu;
import menu.model.domain.Coach;

public class RecommendService {
    public Coach setCoach(String coachName, List<String> hateMenus) {
        return new Coach(coachName, hateMenus);
    }

    public List<String> setCategorySequence() {
        return CategoryMenu.createCategorySequence();
    }

    public List<String> setRecommends(Coach coach, List<String> categorySequence) {
        return CategoryMenu.createRecommends(coach, categorySequence.subList(1, categorySequence.size()));
    }
}
