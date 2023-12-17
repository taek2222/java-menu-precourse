package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.model.constants.CategoryMenu;
import menu.model.domain.Coach;

public class Recommender {
    public List<String> createCategorySequence() {
        List<String> categories = new ArrayList<>();
        categories.add("카테고리");
        while(categories.size() < 6) {
            String category = CategoryMenu.findCategoryById(Randoms.pickNumberInRange(1, 5));
            if(!isOverSelected(categories, category)) {
                categories.add(category);
            }
        }
        return categories;
    }

    private boolean isOverSelected(List<String> categories, String category) {
        return categories.stream()
                .filter(categoryName -> categoryName.equals(category))
                .count() >= 2;
    }

    public List<String> createRecommend(Coach coach, List<String> categorySequence) {
        List<String> recommendResults = new ArrayList<>();
        recommendResults.add(coach.getName());
        for(String category : categorySequence) {
            String menu = findValidMenu(coach, category, recommendResults);
            recommendResults.add(menu);
        }
        return recommendResults;
    }

    private String findValidMenu(Coach coach, String category, List<String> recommendResults) {
        String menus = CategoryMenu.findMenusByCategory(category);
        while (true) {
            List<String> shuffledMenus = Randoms.shuffle(Arrays.asList(menus.split(", ")));
            String randomMenu = shuffledMenus.get(0);
            if (!coach.isHateMenu(randomMenu) && !recommendResults.contains(randomMenu)) {
                return randomMenu;
            }
        }
    }
}
