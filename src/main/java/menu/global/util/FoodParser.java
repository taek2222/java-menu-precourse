package menu.global.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import menu.domain.Food;

public class FoodParser {

    private static final String PATTERN_REGEX = "^([가-힣]*)$";
    private static final Pattern PATTERN = Pattern.compile(PATTERN_REGEX);
    private static final int EXPECTED_MATCHER_COUNT = 1;

    public static List<Food> parseFoods(String input) {
        return Arrays.stream(input.split(","))
                .map(name -> {
                    Matcher matcher = PATTERN.matcher(name);
                    validateMatch(matcher);
                    String foodName = matcher.group(1);
                    return Food.findByName(foodName);
                }).toList();
    }

    private static void validateMatch(Matcher matcher) {
        if (!matcher.find() || matcher.groupCount() != EXPECTED_MATCHER_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
