package se.edufy.videoservice.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import se.edufy.videoservice.dto.CreateVideoRequest;
import se.edufy.videoservice.dto.UpdateVideoRequest;
import se.edufy.videoservice.dto.VideoDto;
import se.edufy.videoservice.service.VideoService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoController {

    private final VideoService service;

    public VideoController(VideoService service) {
        this.service = service;
    }
    @GetMapping
    public Page<VideoDto> list(@RequestParam(required = false) Long channelId,
                               @RequestParam(required = false) Long seriesId,
                               Pageable pageable) {
        return service.list(
                Optional.ofNullable(channelId),
                Optional.ofNullable(seriesId),
                pageable
        );
    }
    @GetMapping("/{id}")
    public VideoDto get(@PathVariable Long id) {
        return service.get(id);
    }
    @PostMapping
    public VideoDto create(@Valid @RequestBody CreateVideoRequest request) {
        return service.create(request);
    }
    @PutMapping("/{id}")
    public VideoDto update(@PathVariable Long id,
                           @Valid @RequestBody UpdateVideoRequest request) {
        return service.update(id, request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}