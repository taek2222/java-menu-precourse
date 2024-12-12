package menu.controller;

import java.util.List;
import menu.global.util.CoachNamesParser;
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
        List<String> names = CoachNamesParser.parseCoachNames(input);
    }
}
