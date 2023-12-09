package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.model.domain.Coach;
import menu.model.service.RecommendService;
import menu.util.Separator;
import menu.validation.Validator;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    private final RecommendService recommendService;
    private final List<Coach> coaches = new ArrayList<>();

    public RecommendController(RecommendService recommendService) {
        this.recommendService = recommendService;
    }

    public void start() {
        makeCoachesProcess();
        recommendProcess();
    }

    private void makeCoachesProcess() {
        outputView.printStartingMessage();
        List<String> coachNames = Separator.separateByComma(inputView.getCoachNames());
        Validator.validateCoachInputs(coachNames);
        for (String coachName : coachNames) {
            List<String> hateMenus = Separator.separateByComma(inputView.getHateMenus(coachName));
            Validator.validateHateMenus(hateMenus);
            Coach coach = recommendService.setCoach(coachName, hateMenus);
            coaches.add(coach);
        }
    }

    private void recommendProcess() {
        List<List<String>> results = new ArrayList<>();
        List<String> categorySequence = recommendService.setCategorySequence();
        results.add(categorySequence);
        for(Coach coach : coaches) {
            List<String> recommends = recommendService.setRecommends(coach, categorySequence);
            results.add(recommends);
        }
        outputView.printRecommendResults(results);
    }
}
