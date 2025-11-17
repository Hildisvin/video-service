package se.edufy.videoservice.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "channels")
public class ChannelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200, unique = true)
    private String name;
    @Column(nullable = false, length = 100, unique = true)
    private String handle;
    @OneToMany(mappedBy = "channel")
    private Set<VideoEntity> videos = new HashSet<>();
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getHandle() {
        return handle;
    }
    public Set<VideoEntity> getVideos() {
        return videos;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHandle(String handle) {
        this.handle = handle;
    }
    public void setVideos(Set<VideoEntity> videos) {
        this.videos = videos;
    }
}
