package se.edufy.videoservice.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import se.edufy.videoservice.dto.CreateVideoRequest;
import se.edufy.videoservice.dto.UpdateVideoRequest;
import se.edufy.videoservice.dto.VideoDto;
import se.edufy.videoservice.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoController {

    private static final Logger log = LoggerFactory.getLogger(VideoController.class);

    private final VideoService service;

    public VideoController(VideoService service) {
        this.service = service;
    }
    @GetMapping
    public Page<VideoDto> list(@RequestParam(required = false) Long channelId,
                               @RequestParam(required = false) Long seriesId,
                               Pageable pageable) {
        log.info("Request received: GET paged videos channelId={}, seriesId={}, page={}, size={}",
                channelId, seriesId, pageable.getPageNumber(), pageable.getPageSize());

        Page<VideoDto> page = service.list(
                Optional.ofNullable(channelId),
                Optional.ofNullable(seriesId),
                pageable
        );

        log.debug("Fetched {} videos (page {} of {})",
                page.getNumberOfElements(), page.getNumber(), page.getTotalPages());

        return page;
    }

    @GetMapping("/all")
    public List<VideoDto> getAll() {
        log.info("Request received: GET all videos");
        List<VideoDto> videos = service.getAll();
        log.debug("Fetched {} videos", videos.size());
        return videos;
    }

    @GetMapping("/by-channel/{channelId}")
    public List<VideoDto> getAllByChannel(@PathVariable Long channelId) {
        log.info("Request received: GET videos by channelId={}", channelId);
        List<VideoDto> videos = service.getAllByChannel(channelId);
        log.debug("Fetched {} videos for channelId={}", videos.size(), channelId);
        return videos;
    }

    @GetMapping("/by-series/{seriesId}")
    public List<VideoDto> getAllBySeries(@PathVariable Long seriesId) {
        log.info("Request received: GET videos by seriesId={}", seriesId);
        List<VideoDto> videos = service.getAllBySeries(seriesId);
        log.debug("Fetched {} videos for seriesId={}", videos.size(), seriesId);
        return videos;
    }

    @GetMapping("/{id}")
    public VideoDto get(@PathVariable Long id) {
        log.info("Request received: GET video id={}", id);
        VideoDto dto = service.get(id);
        log.debug("Video found: {}", dto);
        return dto;
    }

    @PostMapping
    public VideoDto create(@Valid @RequestBody CreateVideoRequest request) {
        log.info("Request received: CREATE video");
        log.debug("Create video request body: {}", request);
        VideoDto created = service.create(request);
        log.info("Video created id={}", created.id());
        return created;
    }

    @PutMapping("/{id}")
    public VideoDto update(@PathVariable Long id,
                           @Valid @RequestBody UpdateVideoRequest request) {
        log.info("Request received: UPDATE video id={}", id);
        log.debug("Update video request body: {}", request);
        VideoDto updated = service.update(id, request);
        log.info("Video updated id={}", id);
        return updated;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Request received: DELETE video id={}", id);
        service.delete(id);
        log.info("Video deleted id={}", id);
    }
}