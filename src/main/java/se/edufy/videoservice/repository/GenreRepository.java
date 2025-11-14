package se.edufy.videoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.edufy.videoservice.entity.GenreEntity;

import java.util.Optional;
import java.util.UUID;

public interface GenreRepository extends JpaRepository<GenreEntity, UUID> {
    Optional<GenreEntity> findByName(String name);
}