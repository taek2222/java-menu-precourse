package menu.domain;

import static menu.global.constant.ErrorMessage.OUF_OF_COACH_NAME_RANGE;
import static menu.global.constant.ErrorMessage.OUF_OF_NOT_EATS_FOOD;

import java.util.ArrayList;
import java.util.List;
import menu.domain.dto.CoachResponse;

public class Coach {

    private final String name;
    private final List<Food> notEats; // 없는 경우 None 처리 중임
    private final List<Food> eats;

    public Coach(final String name, final List<Food> notEats) {
        validateNotEats(notEats);
        this.name = name;
        this.notEats = notEats;
        this.eats = new ArrayList<>();
    }

    public CoachResponse createResponse() {
        return new CoachResponse(
                name,
                Food.getFoodNames(eats)
        );
    }

    public void generateEatsIfCategory(Category category) {
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
            throw new IllegalArgumentException(OUF_OF_NOT_EATS_FOOD.get());
        }
    }
}
