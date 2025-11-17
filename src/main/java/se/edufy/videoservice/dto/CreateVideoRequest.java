package se.edufy.videoservice.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public record CreateVideoRequest(
        @NotBlank
        @Size(max = 200)
        String title,
        @Size(max = 4000)
        String description,
        LocalDate releaseDate,
        @NotBlank
        @Size(max = 1000)
        String streamUrl,
        @NotNull
        Long channelId,
        Long seriesId,
        List<@NotBlank String> genres,
        @Pattern(regexp = "PUBLIC|UNLISTED|PRIVATE")
        String visibility,
        @Positive
        Integer positionInSeries
) {}