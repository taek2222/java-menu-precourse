package menu.domain.dto;

import java.util.List;

public record CoachesResponse(
        List<String> categories,
        List<CoachResponse> coachResponses
) {
}
