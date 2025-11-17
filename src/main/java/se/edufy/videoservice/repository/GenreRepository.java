package se.edufy.videoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.edufy.videoservice.entity.GenreEntity;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {

    Optional<GenreEntity> findByNameIgnoreCase(String name);
}