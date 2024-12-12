package menu.view;

import static menu.global.constant.MessageConstant.NEW_LINE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readNotEatFood(String name) {
        System.out.printf(NEW_LINE.get());
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.", name);
        System.out.println();

        return Console.readLine();
    }

    public String readCoachNames() {
        System.out.println(NEW_LINE.get() + "코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }
}
