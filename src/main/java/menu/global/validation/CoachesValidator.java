package menu.global.validation;

import static menu.global.constant.ErrorMessage.DUPLICATE_NAME;
import static menu.global.constant.ErrorMessage.OUF_OF_COACH_NAME_RANGE;
import static menu.global.constant.ErrorMessage.OUF_OF_COACH_RANGE;

import java.util.HashSet;
import java.util.List;

public class CoachesValidator {

    public static void validateCoaches(List<String> names) {
        validateSize(names);
        validateDuplicate(names);
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

    private static void validateDuplicate(List<String> inputs) {
        HashSet<String> check = new HashSet<>(inputs);
        if (check.size() != inputs.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME.get());
        }
    }
}
