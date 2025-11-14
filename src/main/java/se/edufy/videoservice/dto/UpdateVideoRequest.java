package se.edufy.videoservice.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public record UpdateVideoRequest(
        @Size(max = 200) String title,
        @Size(max = 4000) String description,
        LocalDate releaseDate,
        @Size(max = 1000) String streamUrl,
        String channelId,
        String seriesId,
        List<String> genres,
        @Pattern(regexp = "PUBLIC|UNLISTED|PRIVATE") String visibility,
        @Positive Integer positionInSeries
) {}