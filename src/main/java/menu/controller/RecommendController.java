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
    private final RecommendService recommendService;
    private List<Coach> coaches = new ArrayList<>();

    public RecommendController(RecommendService recommendService) {
        this.recommendService = recommendService;
    }
    public void makeCoachesProcess() {
        OutputView.printStartingMessage();
        List<String> coachNames = Separator.separateByComma(InputView.getCoachNames());
        Validator.validateCoachInputs(coachNames);
        for (String coachName : coachNames) {
            List<String> hateMenus = Separator.separateByComma(InputView.getHateMenus(coachName));
            Validator.validateHateMenus(hateMenus);
            Coach coach = recommendService.setCoach(coachName, hateMenus);
            coaches.add(coach);
        }
    }

    public void recommendProcess() {
        List<List<String>> results = new ArrayList<>();
        List<String> categorySequence = recommendService.setCategorySequence();
        results.add(categorySequence);
        for(Coach coach : coaches) {
            List<String> recommends = recommendService.setRecommends(coach, categorySequence);
            results.add(recommends);
        }
        OutputView.printRecommendResults(results);
    }
}
