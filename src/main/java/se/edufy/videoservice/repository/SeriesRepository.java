package se.edufy.videoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.edufy.videoservice.entity.SeriesEntity;

import java.util.List;

public interface SeriesRepository extends JpaRepository<SeriesEntity, Long> {
    List<SeriesEntity> findByChannel_Id(Long channelId);
}
