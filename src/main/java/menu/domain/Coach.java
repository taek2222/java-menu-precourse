package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<Food> notEats; // 없는 경우 None 처리 중임
    private final List<Food> eats;

    public Coach(final String name, final List<Food> notEats) {
        validateName(name);
        validateNotEats(notEats);
        this.name = name;
        this.notEats = notEats;
        this.eats = new ArrayList<>();
    }

    private void generateEatsIfCategory(Category category) {
        while (true) {
            Food food = Food.getRandomFoodIfCategory(category);
            if (!notEats.contains(food) && !eats.contains(food)) {
                eats.add(food);
                break;
            }
        }
    }

    private void validateNotEats(List<Food> eats) {
        if (eats.size() > 2) {
            throw new IllegalArgumentException();
        }
    }

    private void validateName(String name) {
        int length = name.length();
        if (length < 2 || length > 5) {
            throw new IllegalArgumentException();
        }
    }
}
