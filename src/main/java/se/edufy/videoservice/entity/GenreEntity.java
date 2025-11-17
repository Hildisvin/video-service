package se.edufy.videoservice.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100, unique = true)
    private String name;
    @ManyToMany(mappedBy = "genres")
    private Set<VideoEntity> videos = new HashSet<>();
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Set<VideoEntity> getVideos() {
        return videos;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setVideos(Set<VideoEntity> videos) {
        this.videos = videos;
    }
}
