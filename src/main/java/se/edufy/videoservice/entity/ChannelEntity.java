package se.edufy.videoservice.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "channels",
        indexes = { @Index(name = "ux_channel_handle", columnList = "handle", unique = true) })
public class ChannelEntity {

    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true, length = 200)
    private String name;

    @Column(nullable = false, unique = true, length = 64)
    private String handle;

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getHandle() { return handle; }

    public void setName(String name) { this.name = name; }
    public void setHandle(String handle) { this.handle = handle; }
}