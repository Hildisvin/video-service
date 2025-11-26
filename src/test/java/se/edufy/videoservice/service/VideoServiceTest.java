package se.edufy.videoservice.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import se.edufy.videoservice.dto.CreateVideoRequest;
import se.edufy.videoservice.dto.VideoDto;
import se.edufy.videoservice.entity.ChannelEntity;
import se.edufy.videoservice.entity.GenreEntity;
import se.edufy.videoservice.entity.SeriesEntity;
import se.edufy.videoservice.entity.VideoEntity;
import se.edufy.videoservice.mapper.VideoMapper;
import se.edufy.videoservice.repository.ChannelRepository;
import se.edufy.videoservice.repository.GenreRepository;
import se.edufy.videoservice.repository.SeriesRepository;
import se.edufy.videoservice.repository.VideoRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VideoServiceTest {

    @Mock
    private VideoRepository videoRepository;

    @Mock
    private ChannelRepository channelRepository;

    @Mock
    private SeriesRepository seriesRepository;

    @Mock
    private GenreRepository genreRepository;

    @Mock
    private VideoMapper videoMapper;

    @InjectMocks
    private VideoService videoService;

    @AfterEach
    void clearSecurityContext() {
        SecurityContextHolder.clearContext();
    }

    private void setJwtWithChannelId(long channelId) {
        Jwt jwt = Jwt.withTokenValue("dummy-token")
                .header("alg", "none")
                .claim("channel_id", String.valueOf(channelId))
                .build();

        Authentication auth = new JwtAuthenticationToken(jwt, List.of());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    @Test
    void create_shouldSetDefaultReleaseDateAndGenerateStreamUrlWhenMissing() {

        setJwtWithChannelId(1L);

        ChannelEntity channel = new ChannelEntity();
        channel.setHandle("clintsreptiles");

        SeriesEntity series = new SeriesEntity();
        series.setTitle("Reptile Care Basics");

        when(channelRepository.findById(1L)).thenReturn(Optional.of(channel));
        when(seriesRepository.findById(1L)).thenReturn(Optional.of(series));

        GenreEntity genre = new GenreEntity();
        genre.setName("Animals");
        when(genreRepository.findByNameIgnoreCase("Animals"))
                .thenReturn(Optional.of(genre));

        when(videoMapper.toDto(any(VideoEntity.class)))
                .thenReturn(new VideoDto(
                        null,
                        "Test Video",
                        null,
                        null,
                        null,
                        "PUBLIC",
                        1L,
                        "Clint's Reptiles",
                        1L,
                        "Reptile Care Basics",
                        1,
                        List.of("Animals")
                ));

        CreateVideoRequest request = new CreateVideoRequest(
                "Test Video",
                "Description",
                null,
                null,
                1L,
                1L,
                List.of("Animals"),
                "PUBLIC",
                1
        );

        ArgumentCaptor<VideoEntity> videoCaptor = ArgumentCaptor.forClass(VideoEntity.class);
        when(videoRepository.save(videoCaptor.capture()))
                .thenAnswer(invocation -> invocation.getArgument(0));

        videoService.create(request);

        VideoEntity saved = videoCaptor.getValue();

        assertThat(saved.getReleaseDate()).isNotNull();
        assertThat(saved.getStreamUrl())
                .isEqualTo("https://edufy.com/video/reptile-care-basics/test-video");

        assertThat(saved.getChannel()).isSameAs(channel);
        assertThat(saved.getSeries()).isSameAs(series);

        assertThat(saved.getGenres())
                .extracting(GenreEntity::getName)
                .contains("Animals");
    }
}