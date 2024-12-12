package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Food;
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
        outputView.printMenuStartMessage();

        String input = inputView.readCoachNames();
        List<String> names = CoachNameParser.parseCoachNames(input);

        for (String name : names) {
            createCoach(name);
        }
    }

    private Coach createCoach(final String name) {
        String input = inputView.readNotEatFood(name);
        List<Food> foods = FoodParser.parseFoods(input);
        return new Coach(name, foods);
    }
}
