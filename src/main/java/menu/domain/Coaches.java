package menu.domain;

import static menu.global.constant.ErrorMessage.OUF_OF_COACH_RANGE;

import java.util.ArrayList;
import java.util.List;
import menu.domain.dto.CoachResponse;
import menu.domain.dto.CoachesResponse;

public class Coaches {

    private final List<Coach> coaches;
    private final List<Category> categories;

    public Coaches(final List<Coach> coaches) {
        this.coaches = coaches;
        this.categories = new ArrayList<>();
    }

    public CoachesResponse createResponse() {
        List<CoachResponse> coachResponses = coaches.stream()
                .map(Coach::createResponse)
                .toList();

        return new CoachesResponse(
                Category.getCategoryNames(categories),
                coachResponses
        );
    }

    public void generateSuggestionFood() {
        for (Category category : categories) {
            coaches.forEach(coach ->
                    coach.generateEatsIfCategory(category));
        }
    }

    public void generateCategories() {
        while (categories.size() < 5) {
            Category category = Category.getRandomCategory();
            if (isOverDuplicateCategory(category)) {
                continue;
            }
            categories.add(category);
        }
    }

    private boolean isOverDuplicateCategory(Category randomCategory) {
        long count = categories.stream()
                .filter(category -> category.equals(randomCategory))
                .count();
        return count >= 2;
    }
}
