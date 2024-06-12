package io.bootify.my_app_bootify.repos;

import io.bootify.my_app_bootify.domain.Reservation;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
}
