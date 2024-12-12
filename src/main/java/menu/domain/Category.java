package menu.domain;

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
}
