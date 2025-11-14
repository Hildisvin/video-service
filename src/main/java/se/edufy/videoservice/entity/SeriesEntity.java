package se.edufy.videoservice.entity;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "series")
public class SeriesEntity {

    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 200)
    private String title;

    public UUID getId() { return id; }
    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }
}