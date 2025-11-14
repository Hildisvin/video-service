package se.edufy.videoservice.entity;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "genres")
public class GenreEntity {

    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    public UUID getId() { return id; }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}