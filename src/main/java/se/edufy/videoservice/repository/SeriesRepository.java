package se.edufy.videoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.edufy.videoservice.entity.SeriesEntity;

public interface SeriesRepository extends JpaRepository<SeriesEntity, Long> {
}