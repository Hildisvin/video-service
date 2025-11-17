package se.edufy.videoservice.service;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.edufy.videoservice.dto.CreateVideoRequest;
import se.edufy.videoservice.dto.UpdateVideoRequest;
import se.edufy.videoservice.dto.VideoDto;
import se.edufy.videoservice.entity.GenreEntity;
import se.edufy.videoservice.entity.VideoEntity;
import se.edufy.videoservice.exception.NotFoundException;
import se.edufy.videoservice.mapper.VideoMapper;
import se.edufy.videoservice.repository.ChannelRepository;
import se.edufy.videoservice.repository.GenreRepository;
import se.edufy.videoservice.repository.SeriesRepository;
import se.edufy.videoservice.repository.VideoRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class VideoService {

    private final VideoRepository videos;
    private final ChannelRepository channels;
    private final SeriesRepository series;
    private final GenreRepository genres;
    private final VideoMapper mapper;

    public VideoService(VideoRepository videos,
                        ChannelRepository channels,
                        SeriesRepository series,
                        GenreRepository genres,
                        VideoMapper mapper) {
        this.videos = videos;
        this.channels = channels;
        this.series = series;
        this.genres = genres;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public Page<VideoDto> list(Optional<Long> channelId,
                               Optional<Long> seriesId,
                               Pageable pageable) {

        if (channelId.isPresent()) {
            return videos.findByChannel_Id(channelId.get(), pageable)
                    .map(mapper::toDto);
        }

        if (seriesId.isPresent()) {
            PageRequest sorted = PageRequest.of(
                    pageable.getPageNumber(),
                    pageable.getPageSize(),
                    Sort.by("positionInSeries").ascending()
                            .and(Sort.by("releaseDate").ascending())
            );
            return videos.findBySeries_Id(seriesId.get(), sorted)
                    .map(mapper::toDto);
        }

        return videos.findAll(pageable).map(mapper::toDto);
    }

    @Transactional(readOnly = true)
    public VideoDto get(Long id) {
        VideoEntity v = videos.findById(id)
                .orElseThrow(() -> new NotFoundException("Video not found: " + id));
        return mapper.toDto(v);
    }

    public VideoDto create(CreateVideoRequest r) {
        VideoEntity v = new VideoEntity();
        applyCreate(v, r);
        VideoEntity saved = videos.save(v);
        return mapper.toDto(saved);
    }

    public VideoDto update(Long id, UpdateVideoRequest r) {
        VideoEntity v = videos.findById(id)
                .orElseThrow(() -> new NotFoundException("Video not found: " + id));
        applyUpdate(v, r);
        VideoEntity saved = videos.save(v);
        return mapper.toDto(saved);
    }

    public void delete(Long id) {
        if (!videos.existsById(id)) {
            throw new NotFoundException("Video not found: " + id);
        }
        videos.deleteById(id);
    }

    private void applyCreate(VideoEntity v, CreateVideoRequest r) {
        v.setTitle(r.title());
        v.setDescription(r.description());
        v.setReleaseDate(r.releaseDate());
        v.setStreamUrl(r.streamUrl());

        v.setChannel(
                channels.findById(r.channelId())
                        .orElseThrow(() -> new NotFoundException("Channel not found: " + r.channelId()))
        );

        if (r.seriesId() != null) {
            v.setSeries(
                    series.findById(r.seriesId())
                            .orElseThrow(() -> new NotFoundException("Series not found: " + r.seriesId()))
            );
        }

        if (r.genres() != null) {
            v.setGenres(resolveGenres(r.genres()));
        }

        if (r.visibility() != null) {
            v.setVisibility(VideoEntity.Visibility.valueOf(r.visibility()));
        }

        if (r.positionInSeries() != null) {
            v.setPositionInSeries(r.positionInSeries());
        }
    }

    private void applyUpdate(VideoEntity v, UpdateVideoRequest r) {
        if (r.title() != null) v.setTitle(r.title());
        if (r.description() != null) v.setDescription(r.description());
        if (r.releaseDate() != null) v.setReleaseDate(r.releaseDate());
        if (r.streamUrl() != null) v.setStreamUrl(r.streamUrl());

        if (r.channelId() != null) {
            v.setChannel(
                    channels.findById(r.channelId())
                            .orElseThrow(() -> new NotFoundException("Channel not found: " + r.channelId()))
            );
        }

        if (r.seriesId() != null) {
            v.setSeries(
                    series.findById(r.seriesId())
                            .orElseThrow(() -> new NotFoundException("Series not found: " + r.seriesId()))
            );
        }

        if (r.genres() != null) {
            v.setGenres(resolveGenres(r.genres()));
        }

        if (r.visibility() != null) {
            v.setVisibility(VideoEntity.Visibility.valueOf(r.visibility()));
        }

        if (r.positionInSeries() != null) {
            v.setPositionInSeries(r.positionInSeries());
        }
    }

    private Set<GenreEntity> resolveGenres(List<String> names) {
        if (names == null || names.isEmpty()) {
            return Collections.emptySet();
        }

        return names.stream()
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(name ->
                        genres.findByNameIgnoreCase(name)
                                .orElseGet(() -> {
                                    GenreEntity g = new GenreEntity();
                                    g.setName(name);
                                    return genres.save(g);
                                })
                )
                .collect(Collectors.toSet());
    }
}