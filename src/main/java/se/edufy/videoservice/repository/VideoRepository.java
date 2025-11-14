package se.edufy.videoservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se.edufy.videoservice.entity.VideoEntity;

import java.util.UUID;

public interface VideoRepository extends JpaRepository<VideoEntity, UUID> {
    Page<VideoEntity> findByChannel_Id(UUID channelId, Pageable p);
    Page<VideoEntity> findBySeries_Id(UUID seriesId, Pageable p);
}