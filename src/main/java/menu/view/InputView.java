package menu.view;

import static menu.global.constant.MessageConstant.INPUT_COACH_NAMES;
import static menu.global.constant.MessageConstant.INPUT_NOT_EAT_FOOD;
import static menu.global.constant.MessageConstant.NEW_LINE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCoachNames() {
        System.out.printf(NEW_LINE.get());
        System.out.println(INPUT_COACH_NAMES.get());
        return Console.readLine();
    }

    public String readNotEatFood(String name) {
        System.out.printf(NEW_LINE.get());
        System.out.println(INPUT_NOT_EAT_FOOD.get(name));
        return Console.readLine();
    }
}
