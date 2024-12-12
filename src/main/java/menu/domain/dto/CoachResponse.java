package menu.domain.dto;

import java.util.List;

public record CoachResponse(
        String name,
        List<String> eats
) {
}
