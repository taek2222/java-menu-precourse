package menu.controller;

import static menu.global.util.CoachNameParser.parseCoachNames;

import java.util.List;
import menu.domain.Coaches;
import menu.domain.Food;
import menu.domain.dto.CoachesResponse;
import menu.global.util.FoodParser;
import menu.view.InputView;
import menu.view.OutputView;

public class ViewHandler { // 이거 해도 되는건지

    private final InputView inputView;
    private final OutputView outputView;

    public ViewHandler(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void displayMenuStart() {
        outputView.printMenuStart();
    }

    public List<String> readAndParserCoachName() {
        String input = inputView.readCoachNames();
        return parseCoachNames(input);
    }

    public List<Food> readAndParserFoods(final String name) {
        String input = inputView.readNotEatFood(name);
        return FoodParser.parseFoods(input);
    }

    public void displayMenuResult(final Coaches coaches) {
        CoachesResponse response = coaches.createResponse();
        outputView.printMenuResult(response);
    }
}
