package menu.view;

import static menu.global.constant.MessageConstant.NEW_LINE;

import java.util.List;
import menu.domain.dto.CoachResponse;
import menu.domain.dto.CoachesResponse;

public class OutputView {

    public void printMenuResult(CoachesResponse response) {
        System.out.println();
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        List<String> categories = response.categories();
        System.out.printf("[ 카테고리 | %s ]", String.join(" | ", categories));
        System.out.println();

        response.coachResponses()
                .forEach(this::printCoachMenu);
        System.out.println(NEW_LINE.get() + "추천을 완료했습니다.");
    }

    private void printCoachMenu(CoachResponse response) {
        List<String> eats = response.eats();
        System.out.printf("[ %s | %s ]", response.name(), String.join(" | ", eats));
        System.out.println();
    }

    public void printMenuStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
