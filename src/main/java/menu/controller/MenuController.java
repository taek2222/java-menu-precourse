package menu.controller;

import static menu.global.validation.CoachesValidator.validateCoaches;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Food;
import menu.view.OutputView;

public class MenuController {
    private final OutputView outputView;
    private final ViewHandler viewHandler;

    public MenuController(OutputView outputView, final ViewHandler viewHandler) {
        this.outputView = outputView;
        this.viewHandler = viewHandler;
    }

    public void run() {
        viewHandler.displayMenuStart();
        Coaches coaches = createCoaches();

        coaches.generateCategories();
        coaches.generateSuggestionFood();

        viewHandler.displayMenuResult(coaches);
    }

    private Coaches createCoaches() {
        List<String> names = getNames();
        List<Coach> coaches = names.stream()
                .map(this::createCoach)
                .toList();
        return new Coaches(coaches);
    }

    private Coach createCoach(final String name) {
        while (true) {
            try {
                List<Food> foods = viewHandler.readAndParserFoods(name);
                return new Coach(name, foods);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<String> getNames() { // 네이밍 이게 맞나
        while (true) {
            try {
                List<String> names = viewHandler.readAndParserCoachName();
                validateCoaches(names);
                return names;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
