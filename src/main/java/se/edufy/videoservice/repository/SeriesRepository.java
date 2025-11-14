package se.edufy.videoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.edufy.videoservice.entity.SeriesEntity;

import java.util.UUID;

public interface SeriesRepository extends JpaRepository<SeriesEntity, UUID> {
}