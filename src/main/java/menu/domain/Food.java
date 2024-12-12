package menu.domain;

import static menu.domain.Category.ASIAN;
import static menu.domain.Category.CHINESE;
import static menu.domain.Category.JAPANESE;
import static menu.domain.Category.KOREAN;
import static menu.domain.Category.WESTERN;
import static menu.global.constant.ErrorMessage.NOT_FOUND_FOOD;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public enum Food {
    GYUDON("규동", JAPANESE),
    UDON("우동", JAPANESE),
    MISO_SOUP("미소시루", JAPANESE),
    SUSHI("스시", JAPANESE),
    KATSUDON("가츠동", JAPANESE),
    ONIGIRI("오니기리", JAPANESE),
    HIGH_RICE("하이라이스", JAPANESE),
    RAMEN("라멘", JAPANESE),
    OKONOMIYAKI("오코노미야끼", JAPANESE),

    KIMBAP("김밥", KOREAN),
    KIMCHI_SOUP("김치찌개", KOREAN),
    SSAMBAP("쌈밥", KOREAN),
    SOY_BEAN_PASTE_SOUP("된장찌개", KOREAN),
    BIBIMBAP("비빔밥", KOREAN),
    KALGUKSU("칼국수", KOREAN),
    BULGOGI("불고기", KOREAN),
    TTEOKBOKKI("떡볶이", KOREAN),
    STIR_FRIED_PORK("제육볶음", KOREAN),

    KKANPUNGGI("깐풍기", CHINESE),
    FRIED_NOODLES("볶음면", CHINESE),
    DONGPO_MEAT("동파육", CHINESE),
    JJAJANGMYEON("짜장면", CHINESE),
    JJAMBBONG("짬뽕", CHINESE),
    MAPO_TOFU("마파두부", CHINESE),
    SWEET_AND_SOUR_PORK("탕수육", CHINESE),
    TOMATO_STIR_FRIED_EGG("토마토 달걀볶음", CHINESE),
    RED_PEPPER_JAPCHAE("고추잡채", CHINESE),

    PAD_THAI("팟타이", ASIAN),
    KHAO_POD("카오 팟", ASIAN),
    NASI_GORENG("나시고렝", ASIAN),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥", ASIAN),
    RICE_NOODLES("쌀국수", ASIAN),
    TOM_YUM_GOONG("똠얌꿍", ASIAN),
    BANH_MI("반미", ASIAN),
    VIETNAMESE_SPRING_ROLL("월남쌈", ASIAN),
    BUNJJA("분짜", ASIAN),

    LASAGNA("라자냐", WESTERN),
    GRATIN("그라탱", WESTERN),
    GNOCCHI("뇨끼", WESTERN),
    QUICHE("끼슈", WESTERN),
    FRENCH_TOAST("프렌치 토스트", WESTERN),
    BAGUETTE("바게트", WESTERN),
    SPAGHETTI("스파게티", WESTERN),
    PIZZA("피자", WESTERN),
    PANINI("파니니", WESTERN),

    NONE("none", Category.NONE);

    private final String name;
    private final Category category;

    Food(final String name, final Category category) {
        this.name = name;
        this.category = category;
    }

    public static List<String> convertFoodNames(List<Food> foods) {
        return foods.stream()
                .map(food -> food.name)
                .toList();
    }

    public static Food getRandomFoodIfCategory(Category category) { // 네이밍이 이게 맞나
        List<String> names = getFoodsIfCategory(category);
        String name = Randoms.shuffle(names).get(0);
        return findByName(name);
    }

    public static Food findByName(String name) {
        return Arrays.stream(values())
                .filter(food -> food.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_FOOD.get(name)));
    }

    private static List<String> getFoodsIfCategory(final Category category) {
        return Arrays.stream(values())
                .filter(food -> food.category == category)
                .map(food -> food.name)
                .toList();
    }
}