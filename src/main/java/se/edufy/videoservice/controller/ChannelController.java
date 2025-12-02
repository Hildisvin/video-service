package se.edufy.videoservice.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import se.edufy.videoservice.dto.ChannelDto;
import se.edufy.videoservice.dto.CreateChannelRequest;
import se.edufy.videoservice.dto.UpdateChannelRequest;
import se.edufy.videoservice.service.ChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/v1/channels")
public class ChannelController {

    private static final Logger log = LoggerFactory.getLogger(ChannelController.class);

    private final ChannelService service;

    public ChannelController(ChannelService service) {
        this.service = service;
    }

    @GetMapping
    public List<ChannelDto> list() {
        log.info("Request recieved: GET all channels");
        List<ChannelDto> channels = service.list();
        log.debug("Fetched {} channels", channels.size());
        return channels;
    }

    @GetMapping("/{id}")
    public ChannelDto get(@PathVariable Long id) {
        log.info("Request recieved: GET channel with id {}", id);
        ChannelDto dto = service.get(id);
        log.debug("Channel found: {}", dto);
        return dto;
    }

    @PostMapping
    public ChannelDto create(@Valid @RequestBody CreateChannelRequest request) {
        log.info("Request received: CREATE channel");
        log.debug("Create channel request body: {}", request);
        ChannelDto created = service.create(request);
        log.info("Channel created id={}", created.id());
        return created;
    }

    @PutMapping("/{id}")
    public ChannelDto update(@PathVariable Long id,
                             @Valid @RequestBody UpdateChannelRequest request) {
        log.info("Request received: UPDATE channel id={}", id);
        log.debug("Update channel request body: {}", request);
        ChannelDto updated = service.update(id, request);
        log.info("Channel updated id={}", id);
        return updated;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Request received: DELETE channel id={}", id);
        service.delete(id);
        log.info("Channel deleted id={}", id);
    }
}