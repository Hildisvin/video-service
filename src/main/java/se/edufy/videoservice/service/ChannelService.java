package se.edufy.videoservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.edufy.videoservice.dto.ChannelDto;
import se.edufy.videoservice.dto.CreateChannelRequest;
import se.edufy.videoservice.dto.UpdateChannelRequest;
import se.edufy.videoservice.entity.ChannelEntity;
import se.edufy.videoservice.exception.NotFoundException;
import se.edufy.videoservice.repository.ChannelRepository;

import java.util.List;

@Service
@Transactional
public class ChannelService {

    private final ChannelRepository channels;

    public ChannelService(ChannelRepository channels) {
        this.channels = channels;
    }

    @Transactional(readOnly = true)
    public List<ChannelDto> list() {
        return channels.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public ChannelDto get(Long id) {
        ChannelEntity c = channels.findById(id)
                .orElseThrow(() -> new NotFoundException("Channel not found: " + id));
        return toDto(c);
    }

    public ChannelDto create(CreateChannelRequest r) {
        ChannelEntity c = new ChannelEntity();
        c.setName(r.name());
        c.setHandle(r.handle());
        ChannelEntity saved = channels.save(c);
        return toDto(saved);
    }

    public ChannelDto update(Long id, UpdateChannelRequest r) {
        ChannelEntity c = channels.findById(id)
                .orElseThrow(() -> new NotFoundException("Channel not found: " + id));

        if (r.name() != null) {
            c.setName(r.name());
        }
        if (r.handle() != null) {
            c.setHandle(r.handle());
        }

        ChannelEntity saved = channels.save(c);
        return toDto(saved);
    }

    public void delete(Long id) {
        if (!channels.existsById(id)) {
            throw new NotFoundException("Channel not found: " + id);
        }
        channels.deleteById(id);
    }

    private ChannelDto toDto(ChannelEntity c) {
        return new ChannelDto(
                c.getId(),
                c.getName(),
                c.getHandle()
        );
    }
}
