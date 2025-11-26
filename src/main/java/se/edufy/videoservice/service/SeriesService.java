package se.edufy.videoservice.service;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.edufy.videoservice.dto.CreateSeriesRequest;
import se.edufy.videoservice.dto.SeriesDto;
import se.edufy.videoservice.dto.UpdateSeriesRequest;
import se.edufy.videoservice.entity.ChannelEntity;
import se.edufy.videoservice.entity.SeriesEntity;
import se.edufy.videoservice.exception.*;
import se.edufy.videoservice.repository.ChannelRepository;
import se.edufy.videoservice.repository.SeriesRepository;
import se.edufy.videoservice.security.SecurityUtils;

import java.util.List;

@Service
@Transactional
public class SeriesService {

    private final SeriesRepository series;
    private final ChannelRepository channels;

    public SeriesService(SeriesRepository series,
                         ChannelRepository channels) {
        this.series = series;
        this.channels = channels;
    }

    @Transactional(readOnly = true)
    public List<SeriesDto> list() {
        return series.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<SeriesDto> listByChannel(Long channelId) {
        return series.findByChannel_Id(channelId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<SeriesDto> listMySeries() {
        Long channelId = SecurityUtils.currentChannelId();
        return series.findByChannel_Id(channelId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public SeriesDto get(Long id) {
        SeriesEntity s = series.findById(id)
                .orElseThrow(() -> new NotFoundException("Series not found: " + id));
        return toDto(s);
    }

    public SeriesDto create(CreateSeriesRequest r) {
        Long channelId = SecurityUtils.currentChannelId();

        ChannelEntity channel = channels.findById(channelId)
                .orElseThrow(() -> new NotFoundException("Channel not found: " + channelId));

        SeriesEntity s = new SeriesEntity();
        s.setTitle(r.title());
        s.setChannel(channel);

        SeriesEntity saved = series.save(s);
        return toDto(saved);
    }

    public SeriesDto update(Long id, UpdateSeriesRequest r) {
        SeriesEntity s = requireOwnedSeries(id);

        if (r.title() != null) {
            s.setTitle(r.title());
        }

        SeriesEntity saved = series.save(s);
        return toDto(saved);
    }

    public void delete(Long id) {
        SeriesEntity s = requireOwnedSeries(id);
        series.delete(s);
    }

    private SeriesEntity requireOwnedSeries(Long id) {
        SeriesEntity s = series.findById(id)
                .orElseThrow(() -> new NotFoundException("Series not found: " + id));

        Long userChannelId = SecurityUtils.currentChannelId();
        Long seriesChannelId = s.getChannel().getId();

        if (!seriesChannelId.equals(userChannelId)) {
            throw new ForbiddenException("You are not the owner of this series");
        }
        return s;
    }

    private SeriesDto toDto(SeriesEntity s) {
        return new SeriesDto(
                s.getId(),
                s.getTitle(),
                s.getChannel().getId(),
                s.getChannel().getName()
        );
    }
}
