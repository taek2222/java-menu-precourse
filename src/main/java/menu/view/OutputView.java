package menu.view;

import java.util.List;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    public void printStartingMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printRecommendResults(List<List<String>> recommendResults) {
        System.out.println();
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        recommendResults.forEach(data -> System.out.println("[ " + String.join(" | ", data) + " ]"));
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }
}
