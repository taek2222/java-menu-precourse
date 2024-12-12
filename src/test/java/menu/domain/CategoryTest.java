package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class CategoryTest {

    @RepeatedTest(value = 10)
    void 랜덤_카테고리를_정상적으로_반환한다() {
        // given
        Category[] categories = Category.values();

        // when
        Category result = Category.getRandomCategory();

        // then
        assertThat(categories)
                .contains(result);
    }

}