package se.edufy.videoservice.controller;

import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.edufy.videoservice.dto.CreateSeriesRequest;
import se.edufy.videoservice.dto.SeriesDto;
import se.edufy.videoservice.dto.UpdateSeriesRequest;
import se.edufy.videoservice.service.SeriesService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/series")
public class SeriesController {

    private final SeriesService service;

    public SeriesController(SeriesService service) {
        this.service = service;
    }

    @GetMapping
    public List<SeriesDto> list() {
        return service.list();
    }

    @GetMapping("/by-channel/{channelId}")
    public List<SeriesDto> listByChannel(@PathVariable Long channelId) {
        return service.listByChannel(channelId);
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('EDUFY_USER')")
    public List<SeriesDto> listMySeries() {
        return service.listMySeries();
    }

    @GetMapping("/{id}")
    public SeriesDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public SeriesDto create(@Valid @RequestBody CreateSeriesRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public SeriesDto update(@PathVariable Long id,
                            @Valid @RequestBody UpdateSeriesRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
