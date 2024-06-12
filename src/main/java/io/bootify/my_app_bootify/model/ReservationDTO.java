package io.bootify.my_app_bootify.model;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReservationDTO {

    private UUID reservationId;

    @NotNull
    private LocalDate reservationInitialDate;

    @NotNull
    private LocalDate reservationFinalDate;

    @NotNull
    private UUID userId;

}
