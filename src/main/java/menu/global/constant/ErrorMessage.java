package menu.global.constant;

public enum ErrorMessage {
    INVALID_NAME_FORMAT("코치 이름 입력 형식이 잘못되었습니다."),
    INVALID_FOOD_FORMAT("음식 이름 입력 형식이 잘못되었습니다."),
    OUF_OF_COACH_NAME_RANGE("코치의 이름은 최소 2글자 이상, 5글자 이하만 입력 가능합니다."),
    DUPLICATE_NAME("코치의 이름은 중복될 수 없습니다"),
    OUF_OF_COACH_RANGE("코치의 수는 최소 2명 이상, 5명 이하만 입력 가능합니다."),
    OUF_OF_NOT_EATS_FOOD("못먹는 음식의 종류는 최대 2개까지 입력 가능합니다."),
    NOT_FOUND_FOOD("해당 음식을 찾을 수 없습니다. 음식 : (%s)"),
    NOT_FOUND_CATEGORY("해당 카테고리를 찾을 수 없습니다. 카테고리 : (%s)");

    private static final String PREFIX = "[ERROR] ";
    private static final String RETRY = " 다시 입력해 주세요.";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return PREFIX + message + RETRY;
    }

    public String get(Object... value) {
        return PREFIX + String.format(message, value) + RETRY;
    }
}