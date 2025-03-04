package io.github.karkkent.repository;

import io.github.karkkent.model.StreamingBroadcast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository  //  Spring
public interface StreamRepository extends JpaRepository<StreamingBroadcast, Long> {

    // Find nearest
    @Query("SELECT s FROM StreamingBroadcast s WHERE s.streamDate >= :now ORDER BY s.streamDate ASC LIMIT 1")
    Optional<StreamingBroadcast> findNextStream(LocalDateTime now);
}