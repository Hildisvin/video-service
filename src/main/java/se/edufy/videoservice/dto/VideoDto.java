package se.edufy.videoservice.dto;

import java.time.LocalDate;
import java.util.List;

public record VideoDto(
        String id,
        String title,
        String description,
        LocalDate releaseDate,
        String streamUrl,
        String visibility,
        String channelId,
        String channelName,
        String seriesId,
        String seriesTitle,
        Integer positionInSeries,
        List<String> genres
) {}