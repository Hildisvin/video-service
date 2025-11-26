package se.edufy.videoservice.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "series")
public class SeriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @ManyToOne(optional = false)
    @JoinColumn(name = "channel_id")
    private ChannelEntity channel;

    @OneToMany(mappedBy = "series")
    private Set<VideoEntity> videos = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public ChannelEntity getChannel() {
        return channel;
    }

    public Set<VideoEntity> getVideos() {
        return videos;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setChannel(ChannelEntity channel) {
        this.channel = channel;
    }

    public void setVideos(Set<VideoEntity> videos) {
        this.videos = videos;
    }
}
