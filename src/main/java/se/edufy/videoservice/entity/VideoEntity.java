package se.edufy.videoservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "videos",
        indexes = {
                @Index(name = "idx_video_channel", columnList = "channel_id"),
                @Index(name = "idx_video_series",  columnList = "series_id"),
                @Index(name = "idx_video_release", columnList = "releaseDate")
        })
public class VideoEntity {

    public enum Visibility { PUBLIC, UNLISTED, PRIVATE }

    @Id @GeneratedValue
    private UUID id;

    @Version
    private long version;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(length = 4000)
    private String description;

    private LocalDate releaseDate;

    @Column(nullable = false, length = 1000)
    private String streamUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Visibility visibility = Visibility.PUBLIC;

    @ManyToOne(optional = false)
    private ChannelEntity channel;

    @ManyToOne(optional = true)
    private SeriesEntity series;

    @Column(name = "position_in_series")
    private Integer positionInSeries;

    @ManyToMany
    @JoinTable(name = "video_genres",
            joinColumns = @JoinColumn(name = "video_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<GenreEntity> genres = new HashSet<>();

    public UUID getId() { return id; }
    public long getVersion() { return version; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDate getReleaseDate() { return releaseDate; }
    public String getStreamUrl() { return streamUrl; }
    public Visibility getVisibility() { return visibility; }
    public ChannelEntity getChannel() { return channel; }
    public SeriesEntity getSeries() { return series; }
    public Set<GenreEntity> getGenres() { return genres; }
    public Integer getPositionInSeries() { return positionInSeries; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }
    public void setStreamUrl(String streamUrl) { this.streamUrl = streamUrl; }
    public void setVisibility(Visibility visibility) { this.visibility = visibility; }
    public void setChannel(ChannelEntity channel) { this.channel = channel; }
    public void setSeries(SeriesEntity series) { this.series = series; }
    public void setGenres(Set<GenreEntity> genres) { this.genres = genres; }
    public void setPositionInSeries(Integer positionInSeries) { this.positionInSeries = positionInSeries; }
}