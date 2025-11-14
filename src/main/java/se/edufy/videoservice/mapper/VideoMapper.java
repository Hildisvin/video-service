package se.edufy.videoservice.mapper;

import org.springframework.stereotype.Component;
import se.edufy.videoservice.dto.VideoDto;
import se.edufy.videoservice.entity.GenreEntity;
import se.edufy.videoservice.entity.VideoEntity;

import java.util.stream.Collectors;

@Component
public class VideoMapper {

    public VideoDto toDto(VideoEntity e) {
        return new VideoDto(
                e.getId().toString(),
                e.getTitle(),
                e.getDescription(),
                e.getReleaseDate(),
                e.getStreamUrl(),
                e.getVisibility().name(),
                e.getChannel() != null ? e.getChannel().getId().toString() : null,
                e.getChannel() != null ? e.getChannel().getName() : null,
                e.getSeries() != null ? e.getSeries().getId().toString() : null,
                e.getSeries() != null ? e.getSeries().getTitle() : null,
                e.getPositionInSeries(),
                e.getGenres().stream().map(GenreEntity::getName).collect(Collectors.toList())
        );
    }
}