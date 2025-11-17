package se.edufy.videoservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "videos",
        indexes = {
                @Index(name = "idx_video_channel", columnList = "channel_id"),
                @Index(name = "idx_video_series", columnList = "series_id"),
                @Index(name = "idx_video_release", columnList = "release_date")
        }
)
public class VideoEntity {

    public enum Visibility { PUBLIC, UNLISTED, PRIVATE }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private long version;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(length = 4000)
    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "stream_url", nullable = false, length = 1000)
    private String streamUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Visibility visibility = Visibility.PUBLIC;

    @Column(name = "position_in_series")
    private Integer positionInSeries;

    @ManyToOne(optional = false)
    @JoinColumn(name = "channel_id")
    private ChannelEntity channel;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private SeriesEntity series;

    @ManyToMany
    @JoinTable(
            name = "video_genres",
            joinColumns = @JoinColumn(name = "video_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<GenreEntity> genres = new HashSet<>();

    public Long getId() {
        return id;
    }
    public long getVersion() {
        return version;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public String getStreamUrl() {
        return streamUrl;
    }
    public Visibility getVisibility() {
        return visibility;
    }
    public Integer getPositionInSeries() {
        return positionInSeries;
    }
    public ChannelEntity getChannel() {
        return channel;
    }
    public SeriesEntity getSeries() {
        return series;
    }
    public Set<GenreEntity> getGenres() {
        return genres;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }
    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }
    public void setPositionInSeries(Integer positionInSeries) {
        this.positionInSeries = positionInSeries;
    }
    public void setChannel(ChannelEntity channel) {
        this.channel = channel;
    }
    public void setSeries(SeriesEntity series) {
        this.series = series;
    }
    public void setGenres(Set<GenreEntity> genres) {
        this.genres = genres;
    }
}
