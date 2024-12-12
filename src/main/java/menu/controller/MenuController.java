package menu.controller;

import static menu.global.util.CoachNameParser.parseCoachNames;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Food;
import menu.domain.dto.CoachesResponse;
import menu.global.util.FoodParser;
import menu.global.validation.CoachesValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        displayMenuStart();
        Coaches coaches = createCoaches();

        coaches.generateCategories();
        coaches.generateSuggestionFood();

        displayMenuResult(coaches);
    }

    private void displayMenuStart() {
        outputView.printMenuStart();
    }

    private Coaches createCoaches() {
        List<String> names = readAndParserCoachNames();
        List<Coach> coaches = names.stream()
                .map(this::createCoach)
                .toList();
        return new Coaches(coaches);
    }

    private Coach createCoach(final String name) {
        while (true) {
            try {
                List<Food> foods = readAndParserFoods(name);
                return new Coach(name, foods);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<String> readAndParserCoachNames() {
        while (true) {
            try {
                String input = inputView.readCoachNames();
                List<String> names = parseCoachNames(input);
                CoachesValidator.validateCoaches(names);
                return names;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Food> readAndParserFoods(final String name) {
        String input = inputView.readNotEatFood(name);
        return FoodParser.parseFoods(input);
    }

    private void displayMenuResult(final Coaches coaches) {
        CoachesResponse response = coaches.createResponse();
        outputView.printMenuResult(response);
    }
}
