package se.edufy.videoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.edufy.videoservice.entity.ChannelEntity;

public interface ChannelRepository extends JpaRepository<ChannelEntity, Long> {
}