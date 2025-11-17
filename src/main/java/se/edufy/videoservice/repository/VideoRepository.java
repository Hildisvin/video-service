package se.edufy.videoservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se.edufy.videoservice.entity.VideoEntity;

public interface VideoRepository extends JpaRepository<VideoEntity, Long> {

    Page<VideoEntity> findByChannel_Id(Long channelId, Pageable pageable);

    Page<VideoEntity> findBySeries_Id(Long seriesId, Pageable pageable);
}