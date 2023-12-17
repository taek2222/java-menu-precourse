package menu;

import menu.controller.RecommendController;
import menu.model.service.RecommendService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RecommendController controller = new RecommendController(new RecommendService());
        controller.start();
    }
}
