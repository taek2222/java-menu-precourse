package menu.view;

import static menu.global.constant.MessageConstant.NEW_LINE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCoachNames() {
        System.out.println(NEW_LINE.get() + "코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }
}
