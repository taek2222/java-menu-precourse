package menu.global.validation;

import static menu.global.constant.ErrorMessage.OUF_OF_COACH_NAME_RANGE;
import static menu.global.constant.ErrorMessage.OUF_OF_COACH_RANGE;

import java.util.List;

public class CoachesValidator {

    public static void validateCoaches(List<String> names) {
        validateSize(names);
        names.forEach(CoachesValidator::validateLength);
    }

    private static void validateSize(final List<String> inputs) {
        int size = inputs.size();
        if (size < 2 || size > 5) {
            throw new IllegalArgumentException(OUF_OF_COACH_RANGE.get());
        }
    }

    private static void validateLength(String input) {
        int length = input.length();
        if (length < 2 || length > 5) {
            throw new IllegalArgumentException(OUF_OF_COACH_NAME_RANGE.get());
        }
    }
}
