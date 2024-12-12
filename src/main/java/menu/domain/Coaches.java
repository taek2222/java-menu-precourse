package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches;
    private final List<Category> categories;

    public Coaches(final List<Coach> coaches) {
        validateCoachesSize(coaches);
        this.coaches = coaches;
        this.categories = new ArrayList<>();
    }

    public void generateCategories() {
        while (categories.size() < 6) {
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

    private void validateCoachesSize(final List<Coach> coaches) {
        int size = coaches.size();
        if (size < 2 || size > 5) {
            throw new IllegalArgumentException();
        }
    }
}
