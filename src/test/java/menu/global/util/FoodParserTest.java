package menu.global.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import java.util.List;
import menu.domain.Food;
import menu.global.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FoodParserTest {

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

}