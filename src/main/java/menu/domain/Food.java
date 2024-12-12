package menu.domain;

public enum Food {
    GYUDON("규동", Category.JAPANESE),
    UDON("우동", Category.JAPANESE),
    MISO_SOUP("미소시루", Category.JAPANESE),
    SUSHI("스시", Category.JAPANESE),
    KATSUDON("가츠동", Category.JAPANESE),
    ONIGIRI("오니기리", Category.JAPANESE),
    HIGH_RICE("하이라이스", Category.JAPANESE),
    RAMEN("라멘", Category.JAPANESE),
    OKONOMIYAKI("오코노미야끼", Category.JAPANESE),

    KIMBAP("감밥", Category.KOREAN),
    KIMCHI_SOUP("김치찌개", Category.KOREAN),
    SSAMBAP("쌈밥", Category.KOREAN),
    SOY_BEAN_PASTE_SOUP("된장찌개", Category.KOREAN),
    BIBIMBAP("비빔밥", Category.KOREAN),
    KALGUKSU("칼국수", Category.KOREAN),
    BULGOGI("불고기", Category.KOREAN),
    TTEOKBOKKI("떡볶이", Category.KOREAN),
    STIR_FRIED_PORK("제육볶음", Category.KOREAN),

    KKANPUNGGI("깐풍기", Category.CHINESE),
    FRIED_NOODLES("볶음면", Category.CHINESE),
    DONGPO_MEAT("동파육", Category.CHINESE),
    JJAJANGMYEON("짜장면", Category.CHINESE),
    JJAMBBONG("짬뽕", Category.CHINESE),
    MAPO_TOFU("마파두부", Category.CHINESE),
    SWEET_AND_SOUR_PORK("탕수육", Category.CHINESE),
    TOMATO_STIR_FRIED_EGG("토마토 달걀볶음", Category.CHINESE),
    RED_PEPPER_JAPCHAE("고추잡채", Category.CHINESE),

    PAD_THAI("팟타이", Category.ASIAN),
    KHAO_POD("카오_팟", Category.ASIAN),
    NASI_GORENG("나시고렝", Category.ASIAN),
    PINEAPPLE_FRIED_RICE("파인애플_볶음밥", Category.ASIAN),
    RICE_NOODLES("쌀국수", Category.ASIAN),
    TOM_YUM_GOONG("똠얌꿍", Category.ASIAN),
    BANH_MI("반미", Category.ASIAN),
    VIETNAMESE_SPRING_ROLL("월남쌈", Category.ASIAN),
    BUNJJA("분짜", Category.ASIAN),

    LASAGNA("라자냐", Category.WESTERN),
    GRATIN("그라탱", Category.WESTERN),
    GNOCCHI("뇨끼", Category.WESTERN),
    QUICHE("끼슈", Category.WESTERN),
    FRENCH_TOAST("프렌치_토스트", Category.WESTERN),
    BAGUETTE("바게트", Category.WESTERN),
    SPAGHETTI("스파게티", Category.WESTERN),
    PIZZA("피자", Category.WESTERN),
    PANINI("파니니", Category.WESTERN)
    ;

    private final String name;
    private final Category category;

    Food(final String name, final Category category) {
        this.name = name;
        this.category = category;
    }


}