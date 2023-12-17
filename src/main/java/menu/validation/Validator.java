package menu.validation;

import java.util.List;
import menu.model.constants.CategoryMenu;

public class Validator {
    private final static String EXCEPTION_MESSAGE = "잘못된 입력입니다";

    public static void validateCoachInputs(List<String> names) {
        validateNamesLength(names);
        validateCoachNumbers(names);
    }

    private static void validateNamesLength(List<String> names) {
        for (String name : names) {
            if (hasInvalidLength(name)) {
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }

    private static boolean hasInvalidLength(String name) {
        return name.length() < 2 || name.length() > 4;
    }

    private static void validateCoachNumbers(List<String> names) {
        if (hasInvalidCoachNumbers(names)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private static boolean hasInvalidCoachNumbers(List<String> names) {
        for(String name : names) {
            if(name.length() < 2 || name.length() > 4) {
                return true;
            }
        }
        return false;
    }

    public static void validateHateMenus(List<String> hateMenus) {
        hasInvalidHateNumbers(hateMenus);
        hasInvalidHateMenu(hateMenus);
    }

    private static void hasInvalidHateMenu(List<String> hateMenus) {
        if(hateMenus.size() > 2) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private static void hasInvalidHateNumbers(List<String> hateMenus) {
        for(String name : hateMenus) {
            if(!CategoryMenu.hasMenu(name)){
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
    }
}
