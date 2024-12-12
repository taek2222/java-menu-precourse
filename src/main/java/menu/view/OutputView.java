package menu.view;

import static menu.global.constant.MessageConstant.NEW_LINE;
import static menu.global.constant.MessageConstant.OUTPUT_CATEGORIES;
import static menu.global.constant.MessageConstant.OUTPUT_COACH_MENU;
import static menu.global.constant.MessageConstant.OUTPUT_DAY_OF_THE_WEEK;
import static menu.global.constant.MessageConstant.OUTPUT_MENU_RESULT;
import static menu.global.constant.MessageConstant.OUTPUT_MENU_START;
import static menu.global.constant.MessageConstant.OUTPUT_SUCCESS_RESULT;

import java.util.List;
import menu.domain.dto.CoachResponse;
import menu.domain.dto.CoachesResponse;

public class OutputView {

    private static final String DELIMITER_EAT = " | ";
    private static final String DELIMITER_CATEGORY = " | ";

    public void printMenuStart() {
        System.out.println(OUTPUT_MENU_START.get());
    }

    public void printMenuResult(CoachesResponse response) {
        System.out.printf(NEW_LINE.get());
        System.out.println(OUTPUT_MENU_RESULT.get());

        printDayOfTheWeek();
        printCategories(response.categories());
        response.coachResponses().forEach(this::printCoachMenu);
        printSuccessResult();
    }

    private void printDayOfTheWeek() {
        System.out.println(OUTPUT_DAY_OF_THE_WEEK.get());
    }

    private void printCategories(final List<String> categories) {
        String joinCategories = String.join(DELIMITER_CATEGORY, categories);
        System.out.println(OUTPUT_CATEGORIES.get(joinCategories));
    }

    private void printCoachMenu(CoachResponse response) {
        String joinEats = String.join(DELIMITER_EAT, response.eats());
        System.out.println(OUTPUT_COACH_MENU.get(response.name(), joinEats));
    }

    private void printSuccessResult() {
        System.out.printf(NEW_LINE.get());
        System.out.println(OUTPUT_SUCCESS_RESULT.get());
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
