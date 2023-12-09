package menu.model.constants;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.model.domain.Coach;

public enum CategoryMenu {
    JAPANESE_FOOD(1, "일식", "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼"),
    KOREAN_FOOD(2, "한식", "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음"),
    CHINESE_FOOD(3, "중식", "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채"),
    ASIAN_FOOD(4, "아시안", "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜"),
    WESTERN_FOOD(5, "양식", "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");

    private final int id;
    private final String category;
    private final String menus;

    CategoryMenu(int id, String category, String menus) {
        this.id = id;
        this.category = category;
        this.menus = menus;
    }

    public Integer getMenuNumber() {
        return id;
    }

    public String getMenuCategory() {
        return category;
    }

    public String getMenus() {
        return menus;
    }


    public static boolean hasMenu(String menu) {
        for (CategoryMenu category : CategoryMenu.values()) {
            if (category.menus.contains(menu)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> createCategorySequence() {
        List<String> categories = new ArrayList<>();
        categories.add("카테고리");
        while(categories.size() < 6) {
            String category = findCategoryById(Randoms.pickNumberInRange(1, 5));
            if(!isOverSelected(categories, category)) {
                categories.add(category);
            }
        }
        return categories;
    }

    private static boolean isOverSelected(List<String> categories, String category) {
        return categories.stream()
                .filter(categoryName -> categoryName.equals(category))
                .count() >= 2;
    }

    private static String findCategoryById(int id) {
        for (CategoryMenu categoryMenu : CategoryMenu.values()) {
            if (categoryMenu.getMenuNumber() == id) {
                return categoryMenu.getMenuCategory();
            }
        }
        return null;
    }

    public static List<String> createRecommends(Coach coach, List<String> categorySequence) {
        List<String> recommendResults = new ArrayList<>();
        recommendResults.add(coach.getName());
        for(String category : categorySequence) {
            String menu = findValidMenu(coach, category, recommendResults);
            recommendResults.add(menu);
        }
        return recommendResults;
    }

    private static String findValidMenu(Coach coach, String category, List<String> recommendResults) {
        while (true) {
            List<String> menus = Arrays.asList(findMenusByCategory(category).split(", "));
            List<String> shuffledMenus = Randoms.shuffle(menus);
            String randomMenu = shuffledMenus.get(0);
            if (!coach.isHateMenu(randomMenu) && !recommendResults.contains(randomMenu)) {
                return randomMenu;
            }
        }
    }

    private static String findMenusByCategory(String category) {
        for (CategoryMenu categoryMenu : CategoryMenu.values()) {
            if (category.equals(categoryMenu.category)) {
                return categoryMenu.menus;
            }
        }
        return null;
    }
}
