package menu.domain;

import static menu.domain.Category.getCategoryNames;
import static menu.domain.Category.getRandomCategory;

import java.util.ArrayList;
import java.util.List;
import menu.domain.dto.CoachResponse;
import menu.domain.dto.CoachesResponse;

public class Coaches {

    private static final int MAXIMUM_CATEGORY_LENGTH = 5;
    private static final int MAXIMUM_DUPLICATE_CATEGORY = 2;
    private final List<Coach> coaches;
    private final List<Category> categories;

    public Coaches(final List<Coach> coaches) {
        this.coaches = coaches;
        this.categories = new ArrayList<>();
    }

    public CoachesResponse createResponse() {
        List<CoachResponse> coachResponses = getCoachNames();
        return new CoachesResponse(getCategoryNames(categories), coachResponses);
    }

    public void generateSuggestionFood() {
        for (Category category : categories) {
            coaches.forEach(coach ->
                    coach.generateEatsIfCategory(category));
        }
    }

    public void generateCategories() {
        while (categories.size() < MAXIMUM_CATEGORY_LENGTH) {
            Category category = getRandomCategory();
            if (isOverDuplicateCategory(category)) {
                continue;
            }
            categories.add(category);
        }
    }

    private List<CoachResponse> getCoachNames() {
        return coaches.stream()
                .map(Coach::createResponse)
                .toList();
    }

    private boolean isOverDuplicateCategory(Category randomCategory) {
        long count = categories.stream()
                .filter(category -> category.equals(randomCategory))
                .count();
        return count >= MAXIMUM_DUPLICATE_CATEGORY;
    }
}
