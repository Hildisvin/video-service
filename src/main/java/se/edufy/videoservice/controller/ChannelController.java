package se.edufy.videoservice.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import se.edufy.videoservice.dto.ChannelDto;
import se.edufy.videoservice.dto.CreateChannelRequest;
import se.edufy.videoservice.dto.UpdateChannelRequest;
import se.edufy.videoservice.service.ChannelService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/channels")
public class ChannelController {

    private final ChannelService service;

    public ChannelController(ChannelService service) {
        this.service = service;
    }

    @GetMapping
    public List<ChannelDto> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ChannelDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public ChannelDto create(@Valid @RequestBody CreateChannelRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public ChannelDto update(@PathVariable Long id,
                             @Valid @RequestBody UpdateChannelRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
