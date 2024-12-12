package menu.domain;

import java.util.List;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches(final List<Coach> coaches) {
        this.coaches = coaches;
    }

    private void validateCoachesSize(final List<Coach> coaches) {
        int size = coaches.size();
        if (size < 2 || size > 5) {
            throw new IllegalArgumentException();
        }
    }
}
