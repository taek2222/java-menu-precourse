package menu.model.service;

import java.util.List;
import menu.model.domain.Coach;
import menu.util.Recommender;

public class RecommendService {
    private final Recommender recommender = new Recommender();

    public Coach setCoach(String coachName, List<String> hateMenus) {
        return new Coach(coachName, hateMenus);
    }

    public List<String> setCategorySequence() {
        return recommender.createCategorySequence();
    }

    public List<String> setRecommends(Coach coach, List<String> categorySequence) {
        return recommender.createRecommend(coach, categorySequence.subList(1, categorySequence.size()));
    }
}
