package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public enum Category {
    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식"),
    NONE("none")
    ;

    private final String name;

    Category(final String name) {
        this.name = name;
    }

    public static Category getRandomCategory() {
        int number = Randoms.pickNumberInRange(1, 5);
        return Arrays.stream(values())
                .filter(category -> category.ordinal() == number)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("서버 에러 발생 : 카테고리 코드가 잘못 설정되어 있습니다."));
    }
}
