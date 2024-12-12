package menu.global.util;

import static menu.domain.Food.BANH_MI;
import static menu.domain.Food.BUNJJA;
import static menu.domain.Food.KHAO_POD;
import static menu.domain.Food.NASI_GORENG;
import static menu.domain.Food.PAD_THAI;
import static menu.domain.Food.PINEAPPLE_FRIED_RICE;
import static menu.domain.Food.RICE_NOODLES;
import static menu.domain.Food.TOM_YUM_GOONG;
import static menu.domain.Food.VIETNAMESE_SPRING_ROLL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.domain.Category;
import menu.domain.Food;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FoodParserTest {

    @RepeatedTest(value = 10)
    void 같은_카테고리중_랜덤_음식을_반환한다() {
        // given
        List<Food> asianFoods = List.of(PAD_THAI, KHAO_POD, NASI_GORENG, PINEAPPLE_FRIED_RICE, RICE_NOODLES, TOM_YUM_GOONG,
                BANH_MI, VIETNAMESE_SPRING_ROLL, BUNJJA);

        Category asian = Category.ASIAN;

        // when
        Food result = Food.getRandomFoodIfCategory(asian);

        // then
        assertThat(asianFoods)
                .contains(result);
    }

    @Test
    void 입력의_음식들을_성공적으로_반환한다() {
        // given
        String input = "떡볶이,김밥";

        // when
        List<Food> result = FoodParser.parseFoods(input);

        // then
        assertThat(result)
                .contains(Food.TTEOKBOKKI, Food.KIMBAP);
    }

    @Test
    void 올바른__성공적으로_반환한다() {
        // given
        String input = "떡볶이,김밥";

        // when
        List<Food> result = FoodParser.parseFoods(input);

        // then
        assertThat(result)
                .contains(Food.TTEOKBOKKI, Food.KIMBAP);
    }

    @Test
    void 입력이_빈칸일_경우_NONE를_반환한다() {
        // given
        String input = "";

        // when
        List<Food> result = FoodParser.parseFoods(input);

        // then
        assertThat(result)
                .contains(Food.NONE);
    }

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {
            "김", // 없는 음식
            "김밥떡볶이", // 구분자 미추가
            "김밥,떡볶이,", // 잘못된 포맷
            ",",
            ",김밥,떡볶이"
    })
    void 올바른_입력이_아닌_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> FoodParser.parseFoods(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}