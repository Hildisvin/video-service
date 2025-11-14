package se.edufy.videoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.edufy.videoservice.entity.ChannelEntity;

import java.util.Optional;
import java.util.UUID;

public interface ChannelRepository extends JpaRepository<ChannelEntity, UUID> {
    Optional<ChannelEntity> findByHandle(String handle);
}