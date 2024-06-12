package io.bootify.my_app_bootify.service;

import io.bootify.my_app_bootify.domain.Reservation;
import io.bootify.my_app_bootify.model.ReservationDTO;
import io.bootify.my_app_bootify.repos.ReservationRepository;
import io.bootify.my_app_bootify.util.NotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(final ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationDTO> findAll() {
        final List<Reservation> reservations = reservationRepository.findAll(Sort.by("reservationId"));
        return reservations.stream()
                .map(reservation -> mapToDTO(reservation, new ReservationDTO()))
                .toList();
    }

    public ReservationDTO get(final UUID reservationId) {
        return reservationRepository.findById(reservationId)
                .map(reservation -> mapToDTO(reservation, new ReservationDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public UUID create(final ReservationDTO reservationDTO) {
        final Reservation reservation = new Reservation();
        mapToEntity(reservationDTO, reservation);
        return reservationRepository.save(reservation).getReservationId();
    }

    public void update(final UUID reservationId, final ReservationDTO reservationDTO) {
        final Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(NotFoundException::new);
        mapToEntity(reservationDTO, reservation);
        reservationRepository.save(reservation);
    }

    public void delete(final UUID reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    private ReservationDTO mapToDTO(final Reservation reservation,
            final ReservationDTO reservationDTO) {
        reservationDTO.setReservationId(reservation.getReservationId());
        reservationDTO.setReservationInitialDate(reservation.getReservationInitialDate());
        reservationDTO.setReservationFinalDate(reservation.getReservationFinalDate());
        reservationDTO.setUserId(reservation.getUserId());
        return reservationDTO;
    }

    private Reservation mapToEntity(final ReservationDTO reservationDTO,
            final Reservation reservation) {
        reservation.setReservationInitialDate(reservationDTO.getReservationInitialDate());
        reservation.setReservationFinalDate(reservationDTO.getReservationFinalDate());
        reservation.setUserId(reservationDTO.getUserId());
        return reservation;
    }

}
