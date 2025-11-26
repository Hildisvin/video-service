package se.edufy.videoservice.dto;

public record SeriesDto(
        Long id,
        String title,
        Long channelId,
        String channelName
) {}
