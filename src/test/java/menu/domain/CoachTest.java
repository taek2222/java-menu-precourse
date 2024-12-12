package menu.domain;

import static menu.global.constant.ErrorMessage.OUF_OF_NOT_EATS_FOOD;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CoachTest {

    @Test
    void 못먹는_메뉴_입력이_2_초과인_경우_예외가_발생한다() {
        // given
        List<Food> foods = List.of(Food.HIGH_RICE, Food.QUICHE, Food.PINEAPPLE_FRIED_RICE);

        // when & then
        assertThatThrownBy(() -> new Coach("test", foods))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUF_OF_NOT_EATS_FOOD.get());
    }

}