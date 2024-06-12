package io.bootify.my_app_bootify.repos;

import io.bootify.my_app_bootify.domain.Amenity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AmenityRepository extends JpaRepository<Amenity, UUID> {
}
