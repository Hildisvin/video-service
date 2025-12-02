package se.edufy.videoservice.controller;

import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.edufy.videoservice.dto.CreateSeriesRequest;
import se.edufy.videoservice.dto.SeriesDto;
import se.edufy.videoservice.dto.UpdateSeriesRequest;
import se.edufy.videoservice.service.SeriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/v1/series")
public class SeriesController {

    private static final Logger log = LoggerFactory.getLogger(SeriesController.class);

    private final SeriesService service;

    public SeriesController(SeriesService service) {
        this.service = service;
    }

    @GetMapping
    public List<SeriesDto> list() {
        log.info("Request received: GET all series");
        List<SeriesDto> series = service.list();
        log.debug("Fetched {} series", series.size());
        return series;
    }

    @GetMapping("/by-channel/{channelId}")
    public List<SeriesDto> listByChannel(@PathVariable Long channelId) {
        log.info("Request received: GET series by channelId={}", channelId);
        List<SeriesDto> series = service.listByChannel(channelId);
        log.debug("Fetched {} series for channelId={}", series.size(), channelId);
        return series;
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('EDUFY_USER')")
    public List<SeriesDto> listMySeries() {
        log.info("Request received: GET series for current user (/me)");
        List<SeriesDto> series = service.listMySeries();
        log.debug("Fetched {} series for current user", series.size());
        return series;
    }

    @GetMapping("/{id}")
    public SeriesDto get(@PathVariable Long id) {
        log.info("Request received: GET series id={}", id);
        SeriesDto dto = service.get(id);
        log.debug("Series found: {}", dto);
        return dto;
    }

    @PostMapping
    public SeriesDto create(@Valid @RequestBody CreateSeriesRequest request) {
        log.info("Request received: CREATE series");
        log.debug("Create series request body: {}", request);
        SeriesDto created = service.create(request);
        log.info("Series created id={}", created.id());
        return created;
    }

    @PutMapping("/{id}")
    public SeriesDto update(@PathVariable Long id,
                            @Valid @RequestBody UpdateSeriesRequest request) {
        log.info("Request received: UPDATE series id={}", id);
        log.debug("Update series request body: {}", request);
        SeriesDto updated = service.update(id, request);
        log.info("Series updated id={}", id);
        return updated;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Request received: DELETE series id={}", id);
        service.delete(id);
        log.info("Series deleted id={}", id);
    }
}
