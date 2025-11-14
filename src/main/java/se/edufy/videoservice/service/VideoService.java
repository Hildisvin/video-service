package se.edufy.videoservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.edufy.videoservice.dto.CreateVideoRequest;
import se.edufy.videoservice.dto.UpdateVideoRequest;
import se.edufy.videoservice.dto.VideoDto;
import se.edufy.videoservice.entity.GenreEntity;
import se.edufy.videoservice.entity.VideoEntity;
import se.edufy.videoservice.exception.BadRequestException;
import se.edufy.videoservice.exception.NotFoundException;
import se.edufy.videoservice.mapper.VideoMapper;
import se.edufy.videoservice.repository.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;



import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class VideoService {

    private final VideoRepository videos;
    private final ChannelRepository channels;
    private final GenreRepository genres;
    private final SeriesRepository series;
    private final VideoMapper mapper;

    public VideoService(VideoRepository videos,
                        ChannelRepository channels,
                        GenreRepository genres,
                        SeriesRepository series,
                        VideoMapper mapper) {
        this.videos = videos;
        this.channels = channels;
        this.genres = genres;
        this.series = series;
        this.mapper = mapper;
    }

    public VideoDto create(CreateVideoRequest r){
        var v = new VideoEntity();
        applyCreate(v, r);
        return mapper.toDto(videos.save(v));
    }

    @Transactional(readOnly = true)
    public VideoDto get(UUID id){
        return mapper.toDto(videos.findById(id)
                .orElseThrow(() -> new NotFoundException("Video saknas: " + id)));
    }

    @Transactional(readOnly = true)
    public Page<VideoDto> list(Optional<UUID> channelId,
                               Optional<UUID> seriesId,
                               Pageable p){
        if (channelId.isPresent()) {
            return videos.findByChannel_Id(channelId.get(), p).map(mapper::toDto);
        }
        if (seriesId.isPresent()) {
            var sorted = PageRequest.of(
                    p.getPageNumber(),
                    p.getPageSize(),
                    Sort.by("positionInSeries").ascending()
                            .and(Sort.by("releaseDate").ascending())
            );
            return videos.findBySeries_Id(seriesId.get(), sorted).map(mapper::toDto);
        }
        return videos.findAll(p).map(mapper::toDto);
    }

    public VideoDto update(UUID id, UpdateVideoRequest r){
        var v = videos.findById(id).orElseThrow(() -> new NotFoundException("Video saknas: " + id));
        applyUpdate(v, r);
        return mapper.toDto(v);
    }

    public void delete(UUID id){
        if (!videos.existsById(id)) throw new NotFoundException("Video saknas: " + id);
        videos.deleteById(id);
    }

    private void applyCreate(VideoEntity v, CreateVideoRequest r) {
        v.setTitle(r.title());
        v.setDescription(r.description());
        v.setReleaseDate(r.releaseDate());
        v.setStreamUrl(r.streamUrl());
        v.setChannel(channels.findById(parseUuid(r.channelId(), "channelId"))
                .orElseThrow(() -> new NotFoundException("Channel saknas: " + r.channelId())));
        if (r.seriesId() != null) {
            v.setSeries(series.findById(parseUuid(r.seriesId(), "seriesId"))
                    .orElseThrow(() -> new NotFoundException("Series saknas: " + r.seriesId())));
        }
        if (r.genres() != null) v.setGenres(resolveGenres(r.genres()));
        if (r.visibility() != null) v.setVisibility(VideoEntity.Visibility.valueOf(r.visibility()));
        if (r.positionInSeries() != null) {
            v.setPositionInSeries(r.positionInSeries());
        }
    }

    private void applyUpdate(VideoEntity v, UpdateVideoRequest r){
            if (r.title() != null) v.setTitle(r.title());
            if (r.description() != null) v.setDescription(r.description());
            if (r.releaseDate() != null) v.setReleaseDate(r.releaseDate());
            if (r.streamUrl() != null) v.setStreamUrl(r.streamUrl());
            if (r.channelId() != null) {
                v.setChannel(channels.findById(parseUuid(r.channelId(), "channelId"))
                        .orElseThrow(() -> new NotFoundException("Channel saknas: " + r.channelId())));
            }
            if (r.seriesId() != null) {
                v.setSeries(series.findById(parseUuid(r.seriesId(), "seriesId"))
                        .orElseThrow(() -> new NotFoundException("Series saknas: " + r.seriesId())));
            }
            if (r.genres() != null) v.setGenres(resolveGenres(r.genres()));
            if (r.visibility() != null) v.setVisibility(VideoEntity.Visibility.valueOf(r.visibility()));
            if (r.positionInSeries() != null) {v.setPositionInSeries(r.positionInSeries());
            }
        }

    private Set<GenreEntity> resolveGenres(List<String> names){
        return names.stream()
                .map(n -> genres.findByName(n)
                        .orElseThrow(() -> new NotFoundException("Genre saknas: " + n)))
                .collect(Collectors.toSet());
    }

    private static UUID parseUuid(String id, String label){
        try { return UUID.fromString(id); }
        catch (IllegalArgumentException e) {
            throw new BadRequestException(label + " är inte ett giltigt UUID: " + id);
        }
    }
}