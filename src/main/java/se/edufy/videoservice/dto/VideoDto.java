package se.edufy.videoservice.dto;

import java.time.LocalDate;
import java.util.List;

public record VideoDto(
        Long id,
        String title,
        String description,
        LocalDate releaseDate,
        String streamUrl,
        String visibility,
        Long channelId,
        String channelName,
        Long seriesId,
        String seriesTitle,
        Integer positionInSeries,
        List<String> genres
) {}
