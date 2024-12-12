package menu.domain;

import static menu.global.constant.ErrorMessage.NOT_FOUND_CATEGORY;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public enum Category {
    NONE("none"),
    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식");

    private static final int JAPANESE_INDEX = 1;
    private static final int WESTERN_INDEX = 5;

    private final String name;

    Category(final String name) {
        this.name = name;
    }

    public static List<String> getCategoryNames(List<Category> categories) {
        return categories.stream()
                .map(category -> category.name)
                .toList();
    }

    public static Category getRandomCategory() {
        int number = Randoms.pickNumberInRange(JAPANESE_INDEX, WESTERN_INDEX);
        return Arrays.stream(values())
                .filter(category -> category.ordinal() == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_CATEGORY.get()));
    }
}
