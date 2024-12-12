package menu.global.constant;

public enum MessageConstant {
    // Output
    OUTPUT_MENU_START("점심 메뉴 추천을 시작합니다."),
    OUTPUT_MENU_RESULT("메뉴 추천 결과입니다."),
    OUTPUT_DAY_OF_THE_WEEK("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    OUTPUT_CATEGORIES("[ 카테고리 | %s ]"),
    OUTPUT_COACH_MENU("[ %s | %s ]"),
    OUTPUT_SUCCESS_RESULT("추천을 완료했습니다."),

    // Input
    INPUT_COACH_NAMES("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_NOT_EAT_FOOD("%s(이)가 못 먹는 메뉴를 입력해 주세요."),

    NEW_LINE(System.lineSeparator());

    private final String message;

    MessageConstant(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

    public String get(Object... value) {
        return String.format(message, value);
    }
}