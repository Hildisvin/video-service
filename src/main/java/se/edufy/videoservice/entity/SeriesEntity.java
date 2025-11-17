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
    @OneToMany(mappedBy = "series")
    private Set<VideoEntity> videos = new HashSet<>();
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Set<VideoEntity> getVideos() {
        return videos;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setVideos(Set<VideoEntity> videos) {
        this.videos = videos;
    }
}
