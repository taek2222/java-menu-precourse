package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Food;
import menu.domain.dto.CoachesResponse;
import menu.global.util.CoachNameParser;
import menu.global.util.FoodParser;
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
        outputView.printMenuStart();

        String input = inputView.readCoachNames();
        List<String> names = CoachNameParser.parseCoachNames(input);

        Coaches coaches = createCoaches(names);
        coaches.generateCategories();
        coaches.generateSuggestionFood();

        CoachesResponse response = coaches.createResponse();
        outputView.printMenuResult(response);
    }

    private Coach createCoach(final String name) {
        String input = inputView.readNotEatFood(name);
        List<Food> foods = FoodParser.parseFoods(input);
        return new Coach(name, foods);
    }

    private Coaches createCoaches(final List<String> names) {
        List<Coach> coaches = names.stream()
                .map(this::createCoach)
                .toList();
        return new Coaches(coaches);
    }
}
