package se.edufy.videoservice.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import se.edufy.videoservice.dto.CreateVideoRequest;
import se.edufy.videoservice.dto.UpdateVideoRequest;
import se.edufy.videoservice.dto.VideoDto;
import se.edufy.videoservice.service.VideoService;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoController {

    private final VideoService svc;

    public VideoController(VideoService svc){ this.svc = svc; }

    @PostMapping
    public ResponseEntity<VideoDto> create(@Valid @RequestBody CreateVideoRequest r,
                                           UriComponentsBuilder ucb){
        var dto = svc.create(r);
        var uri = ucb.path("/api/v1/videos/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public Page<VideoDto> list(@RequestParam Optional<UUID> channelId,
                               @RequestParam Optional<UUID> seriesId,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "20") int size){
        return svc.list(channelId, seriesId, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public VideoDto get(@PathVariable UUID id){
        return svc.get(id);
    }

    @PutMapping("/{id}")
    public VideoDto update(@PathVariable UUID id,
                           @Valid @RequestBody UpdateVideoRequest r){
        return svc.update(id, r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}